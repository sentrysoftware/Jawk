package org.sentrysoftware.jawk;

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
 * With this Exception, any part of the code may request a
 * <code>System.exit(code)</code> call with a specific code.
 *
 * @author Danny Daglas
 */
public class ExitException extends Exception {

	private static final long serialVersionUID = 1L;

	/** Constant <code>EXIT_CODE_OK=0</code> */
	public static final int EXIT_CODE_OK = 0;

	/** The exit code being returned */
	private final int code;

	/**
	 * Request exit with the <code>EXIT_CODE_OK</code>.
	 */
	public ExitException() {
		this(EXIT_CODE_OK);
	}

	/**
	 * <p>Constructor for ExitException.</p>
	 *
	 * @param code a int
	 */
	public ExitException(int code) {
		this(code, "");
	}

	/**
	 * <p>Constructor for ExitException.</p>
	 *
	 * @param message a {@link java.lang.String} object
	 */
	public ExitException(String message) {
		this(EXIT_CODE_OK, message);
	}

	/**
	 * <p>Constructor for ExitException.</p>
	 *
	 * @param code a int
	 * @param message a {@link java.lang.String} object
	 */
	public ExitException(int code, String message) {
		this(code, message, null);
	}

	/**
	 * <p>Constructor for ExitException.</p>
	 *
	 * @param code a int
	 * @param cause a {@link java.lang.Throwable} object
	 */
	public ExitException(int code, Throwable cause) {
		this(code, "", cause);
	}

	/**
	 * <p>Constructor for ExitException.</p>
	 *
	 * @param code a int
	 * @param message a {@link java.lang.String} object
	 * @param cause a {@link java.lang.Throwable} object
	 */
	public ExitException(int code, String message, Throwable cause) {
		super(message + " (exit-code: " + code + ")", cause);
		this.code = code;
	}

	/**
	 * Returns the code to be passed to the <code>System.exit(code)</code> call.
	 *
	 * @return a int
	 */
	public int getCode() {
		return code;
	}
}
