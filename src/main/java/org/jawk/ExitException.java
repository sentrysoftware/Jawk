package org.jawk;

/**
 * With this Exception, any part of the code may request a
 * <code>System.exit(code)</code> call with a specific code.
 *
 * @version $Id: $Id
 */
public class ExitException extends Exception {

	private static final long serialVersionUID = 1L;

	/** Constant <code>EXIT_CODE_OK=0</code> */
	public static final int EXIT_CODE_OK = 0;

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
