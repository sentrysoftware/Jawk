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

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Relay data from an input stream to an output stream.
 * A thread is created to do the work.
 * <p>
 * Jawk uses data pumps to relay stdin, stdout, and stderr
 * of a spawned process (by, for example, system() or
 * "cmd" | getline) to the stdin, stdout, and/or stderr
 * of the calling process (the interpreter itself).
 *
 * @author Danny Daglas
 */
public class DataPump implements Runnable {

	private InputStream is;
	private PrintStream os;

	/**
	 * Represents a data pump.
	 *
	 * @param in The input stream.
	 * @param out The output stream.
	 */
	public DataPump(InputStream in, PrintStream out) {
		this.is = in;
		this.os = out;
		//setDaemon(true);
	}

	/**
	 * Allocate the data pump and start the thread.
	 *
	 * @param desc A human-readable description of this data pump.
	 *   It is part of the thread name, and, therefore, visible
	 *   upon a VM thread dump.
	 * @param in The input stream.
	 * @param out The output stream.
	 */
	public static void dump(String desc, InputStream in, PrintStream out) {
		new Thread(new DataPump(in, out), desc).start();
	}

	/**
	 * {@inheritDoc}
	 *
	 * VM entry point for the thread. It performs the data
	 * relay.
	 */
	@Override
	public final void run() {
		try {
			byte[] b = new byte[4096];
			int len;
			while ((len = is.read(b, 0, b.length)) >= 0) {
				os.write(b, 0, len);
			}
		} catch (IOException ioe) {
			// ignore
		}
		try {
			is.close();
		} catch (IOException ioe) {}
	}
}