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

/**
 * Thrown when exit() is called within a Jawk script.
 * <p>
 * Within Jawk, EndException is caught twice. The first
 * catch block executes when exit() is called within BEGIN
 * or action blocks. When invoked, the END blocks are
 * executed. The second catch block executes when exit() is
 * called within any of the END blocks. When invoked,
 * Jawk terminates with an exit code.
 *
 * @author Danny Daglas
 */
public class EndException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for EndException.</p>
	 *
	 * @param s a {@link java.lang.String} object
	 */
	public EndException(String s) {
		super(s);
	}

	/**
	 * <p>Constructor for EndException.</p>
	 */
	public EndException() {
		super();
	}
}