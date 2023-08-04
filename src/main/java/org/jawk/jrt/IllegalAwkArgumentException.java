package org.jawk.jrt;

/**
 * Differentiate from IllegalArgumentException to assist
 * in programmatic distinction between Jawk and other
 * argument exception issues.
 *
 * @version $Id: $Id
 */
public class IllegalAwkArgumentException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for IllegalAwkArgumentException.</p>
	 *
	 * @param msg a {@link java.lang.String} object
	 */
	public IllegalAwkArgumentException(String msg) {
		super(msg);
	}
}
