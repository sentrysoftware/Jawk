package org.sentrysoftware.jawk.jrt;

/*-
 * ╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲
 * Jawk
 * ჻჻჻჻჻჻
 * Copyright 2006 - 2023 Sentry Software
 * ჻჻჻჻჻჻
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱
 */

import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages multiple blocking code segments simultaneously such that
 * unblocking one block condition releases the block of all other
 * block code segments.
 *
 * @see BlockObject
 * @author Danny Daglas
 */
public class BlockManager {

	private static final Logger LOG = LoggerFactory.getLogger(BlockManager.class);

	private final Object notifierLock = "NOTIFIER_LOCK";
	private String notifier = null;

	/**
	 * Executes all block segments simultaneously, waiting for
	 * one block release.
	 * <p>
	 * The algorithm is as follows:
	 * <ul>
	 * <li>Collect linked block objects into a List.
	 * <li>Spawn a BlockThread for each block object.
	 * <li>Wait for notification from any of the BlockThreads.
	 * <li>Interrupt remaining block threads.
	 * <li>Wait for each BlockThread to die.
	 * <li>Return the block object notifier which satisfied their block condition.
	 * </ul>
	 * <p>
	 * And, the BlockThread algorithm is as follows:
	 *
	 * <ul>
	 * <li>try, catch for InterruptedException ...
	 *   <ul>
	 *   <li>Execute the BlockObject block segment.
	 *   <li>Assign the notifier from this BlockObject
	 *     if one isn't already assigned (to mitigate
	 *     a race condition).
	 *   <li>Notify the BlockManager.
	 *   </ul>
	 * <li>If interrupted, do nothing and return.
	 * </ul>
	 *
	 * @param bo BlockObject to employ. Other block objects
	 *   may be linked to this block object. In this event,
	 *   employ all block objects simultaneously.
	 * @return a {@link java.lang.String} object
	 */
	public String block(BlockObject bo) {
		// get all block objects
		List<BlockObject> bos = bo.getBlockObjects();
		// each block object contains a wait statement
		// (either indefinite or timed)

		// for each block object
		// 	spawn a thread (preferably using a threadpool)
		// 	do the wait
		//	signal a break in the block
		// interrupt all other threads, resulting in InterruptedExceptions

		List<Thread> threadList = new LinkedList<Thread>();
		synchronized (BlockManager.this) {
			for (BlockObject blockobj : bos) {
				// spawn a thread
				Thread t = new BlockThread(blockobj);
				t.start();
				threadList.add(t);
			}

			// now, wait for notification from one of the BlockThreads
			try {
				BlockManager.this.wait();
			} catch (InterruptedException ie) {}
		}

		// block successful, interrupt other blockers
		// and wait for thread deaths
		for (Thread t : threadList) {
			t.interrupt();
			try {
				t.join();
			} catch (InterruptedException ie) {}
		}

		// return who was the notifier
		assert notifier != null;
		return notifier;
	}

	private final class BlockThread extends Thread {

		private BlockObject bo;

		private BlockThread(BlockObject bo) {
			setName("BlockThread for " + bo.getNotifierTag());
			this.bo = bo;
		}

		@Override
		public void run() {
			try {
				bo.block();
				synchronized (notifierLock) {
					if (notifier == null) {
						notifier = bo.getNotifierTag();
					}
				}
				synchronized (BlockManager.this) {
					BlockManager.this.notify();
				}
			} catch (InterruptedException ie) {
			} catch (RuntimeException re) {
				LOG.error("exitting", re);
				System.exit(1);
			}
		}
	}
}