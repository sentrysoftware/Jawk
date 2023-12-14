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
 */
public interface VariableManager {

	/**
	 * <p>getARGC.</p>
	 *
	 * @return the contents of the ARGC variable.
	 */
	Object getARGC();

	/**
	 * <p>getARGV.</p>
	 *
	 * @return the contents of the ARGV variable.
	 */
	Object getARGV();

	/**
	 * <p>getCONVFMT.</p>
	 *
	 * @return the contents of the CONVFMT variable.
	 */
	Object getCONVFMT();

	/**
	 * <p>getFS.</p>
	 * 
	 * @return the contents of the FS variable.
	 */
	Object getFS();

	/**
	 * <p>getRS.</p>
	 *
	 * @return the contents of the RS variable.
	 */
	Object getRS();

	/**
	 * <p>getOFS.</p>
	 *
	 * @return the contents of the OFS variable.
	 */
	Object getOFS();

	/**
	 * <p>getSUBSEP.</p>
	 *
	 * @return the contents of the SUBSEP variable.
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
