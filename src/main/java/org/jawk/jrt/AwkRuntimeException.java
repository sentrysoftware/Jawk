package org.jawk.jrt;

/**
 * A runtime exception thrown by Jawk. It is provided
 * to conveniently distinguish between Jawk runtime
 * exceptions and other runtime exceptions.
 *
 * @version $Id: $Id
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
