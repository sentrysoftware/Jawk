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
 * A runtime exception thrown by Jawk. It is provided
 * to conveniently distinguish between Jawk runtime
 * exceptions and other runtime exceptions.
 *
 * @author Danny Daglas
 */
public class AwkRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for AwkRuntimeException.</p>
	 *
	 * @param msg a {@link java.lang.String} object
	 */
	public AwkRuntimeException(String msg) {
		super(msg);
	}

	/**
	 * <p>Constructor for AwkRuntimeException.</p>
	 *
	 * @param lineno a int
	 * @param msg a {@link java.lang.String} object
	 */
	public AwkRuntimeException(int lineno, String msg) {
		super(msg + " (line: " + lineno + ")");
	}
}
