package org.jawk.jrt;

/**
 * The AWK Variable Manager.
 * It provides getter/setter methods for global AWK variables.
 * Its purpose is to expose a variable management interface to
 * the JRT, even though the implementation is provided by
 * the AWK script at script compile-time.
 * <p>
 * The getters/setters here do not access <strong>all</strong>
 * special AWK variables, such as <code>RSTART</code>
 * and <code>ENVIRON</code>. That's because these variables
 * are not referred to within the JRT.
 *
 * @see JRT
 * @author Danny Daglas
 * @version $Id: $Id
 */
public interface VariableManager {

	/** @return the contents of the ARGC variable. */
	/**
	 * <p>getARGC.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getARGC();

	/** @return the contents of the ARGV variable. */
	/**
	 * <p>getARGV.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getARGV();

	/** @return the contents of the CONVFMT variable. */
	/**
	 * <p>getCONVFMT.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getCONVFMT();

	/** @return the contents of the FS variable. */
	/**
	 * <p>getFS.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getFS();

	/** @return the contents of the RS variable. */
	/**
	 * <p>getRS.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getRS();

	/** @return the contents of the OFS variable. */
	/**
	 * <p>getOFS.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getOFS();

	/** @return the contents of the SUBSEP variable. */
	/**
	 * <p>getSUBSEP.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getSUBSEP();

	/**
	 * Set the contents of the FILENAME variable.
	 *
	 * @param fileName File name
	 */
	void setFILENAME(String fileName);

	/**
	 * Set the contents of the NF variable.
	 *
	 * @param newNf Value for NF
	 */
	void setNF(Integer newNf);

	/**
	 * Increases the NR variable by 1.
	 */
	void incNR();

	/**
	 * Increases the FNR variable by 1.
	 */
	void incFNR();

	/**
	 * Resets the FNR variable to 0.
	 */
	void resetFNR();

	/**
	 * Set the contents of a user-defined AWK
	 * variable. Used when processing
	 * <em>name=value</em> command-line arguments
	 * (either via -v or via ARGV).
	 *
	 * @param name The AWK variable name.
	 * @param value The new contents of the variable.
	 */
	void assignVariable(String name, Object value);

}
