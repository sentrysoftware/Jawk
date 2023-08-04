package org.jawk.jrt;

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
 * @version $Id: $Id
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
