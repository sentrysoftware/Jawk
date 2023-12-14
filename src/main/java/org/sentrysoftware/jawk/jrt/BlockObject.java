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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * An item which blocks until something useful can be
 * done with the object. The BlockManager multiplexes
 * BlockObjects such that unblocking one
 * BlockObject causes the BlockManager to dispatch
 * the notifier tag result of the BlockObject.
 * <p>
 * BlockObjects are chained. The BlockManager
 * blocks on all chained BlockObjects until one
 * is unblocked.
 *
 * <p>
 * Subclasses must provide meaningful block()
 * and getNotifierTag() routines.
 *
 * <p>
 * BlockObjects do not actually perform the client
 * blocking. This is done by the BlockManager at the
 * AVM (interpreted) or compiled runtime environment.
 * The AVM/compiled environments make special provision
 * to return the head block object to the BlockManager
 * (within _EXTENSION_ keyword processing).
 *
 * @see BlockManager
 * @author Danny Daglas
 */
public abstract class BlockObject {

	private BlockObject nextBlockObject = null;

	/**
	 * <p>Constructor for BlockObject.</p>
	 */
	protected BlockObject() {}

	/**
	 * Construct a meaningful notifier tag for this BlockObject.
	 *
	 * @return a {@link java.lang.String} object
	 */
	public abstract String getNotifierTag();

	/**
	 * Block until meaningful data is made available for
	 * the client application. This is called by the BlockManager
	 * in a way such that the BlockManager waits for one
	 * BlockObject to unblock.
	 *
	 * @throws java.lang.InterruptedException if any.
	 */
	public abstract void block() throws InterruptedException;


	/**
	 * Eliminate the rest of the BlockObject chain.
	 */
	public final void clearNextBlockObject() {
		this.nextBlockObject = null;
	}

	/**
	 * Chain this BlockObject to another BlockObject.
	 * The chain is linear and there is no upper bounds on
	 * the number of BlockObjects that can be supported.
	 *
	 * @param bo a {@link org.sentrysoftware.jawk.jrt.BlockObject} object
	 */
	public void setNextBlockObject(BlockObject bo) {
		this.nextBlockObject = bo;
	}

	/**
	 * <p>Getter for the field <code>nextBlockObject</code>.</p>
	 *
	 * @return a {@link org.sentrysoftware.jawk.jrt.BlockObject} object
	 */
	protected final BlockObject getNextBlockObject() {
		return nextBlockObject;
	}

	/**
	 * Obtain all chained BlockObjects as a List,
	 * including this one.
	 * A BlockObject chain cycle causes a runtime exception
	 * to be thrown.
	 *
	 * @return A List of chained BlockObjects, including
	 *   this one.
	 * @throws org.sentrysoftware.jawk.jrt.AwkRuntimeException if the BlockObject
	 *   chain contains a cycle.
	 */
	public List<BlockObject> getBlockObjects() {
		List<BlockObject> retval = new LinkedList<BlockObject>();
		Set<BlockObject> blockObjects = new HashSet<BlockObject>();
		BlockObject ref = this;
		while (ref != null) {
			if (blockObjects.contains(ref)) {
				throw new AwkRuntimeException("Block chain contains a cycle (duplicate) : " + ref.getClass().getName() + " / " + ref.getNotifierTag());
			} else {
				blockObjects.add(ref);
			}
			retval.add(ref);
			ref = ref.getNextBlockObject();
		}
		return retval;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Ensure non-evaluation of a BlockObject by throwing an AWK Runtime
	 * exception, in case it leaks into AWK evaluation space.
	 */
	@Override
	public final String toString() {
		throw new AwkRuntimeException("Extension Violation : Cannot AWK-evaluate a BlockObject.");
	}
}
