package org.sentrysoftware.jawk.ext;

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

import org.sentrysoftware.jawk.jrt.IllegalAwkArgumentException;
import org.sentrysoftware.jawk.jrt.JRT;
import org.sentrysoftware.jawk.jrt.VariableManager;
import org.sentrysoftware.jawk.util.AwkSettings;

/**
 * Base class of various extensions.
 * <p>
 * Provides functionality common to most extensions,
 * such as VM and JRT variable management, and convenience
 * methods such as checkNumArgs() and toAwkString().
 *
 * @author Danny Daglas
 */
public abstract class AbstractExtension implements JawkExtension {

	private JRT jrt;
	private VariableManager vm;
	private AwkSettings settings;

	/** {@inheritDoc} */
	@Override
	public void init(VariableManager vm, JRT jrt, final AwkSettings settings) {
		this.vm = vm;
		this.jrt = jrt;
		this.settings = settings;
	}

	/**
	 * Convert a Jawk variable to a Jawk string
	 * based on the value of the CONVFMT variable.
	 *
	 * @param obj The Jawk variable to convert to a Jawk string.
	 * @return A string representation of obj after CONVFMT
	 *   has been applied.
	 */
	protected final String toAwkString(Object obj) {
		return JRT.toAwkString(obj, getVm().getCONVFMT().toString(), settings.getLocale());
	}

	/**
	 * {@inheritDoc}
	 *
	 * Assume no guarantee of any extension parameter being an
	 * associative array.
	 */
	@Override
	public int[] getAssocArrayParameterPositions(String extensionKeyword, int argCount) {
		return new int[0];
	}

	/**
	 * Verifies that an exact number of arguments
	 * has been passed in by checking the length
	 * of the argument array.
	 *
	 * @param arr The arguments to check.
	 * @param expectedNum The expected number of arguments.
	 */
	protected static void checkNumArgs(Object[] arr, int expectedNum) {
		// some sanity checks on the arguments
		// (made into assertions so that
		// production code does not perform
		// these checks)
		assert arr != null;
		assert expectedNum >= 0;

		if (arr.length != expectedNum) {
			throw new IllegalAwkArgumentException("Expecting " + expectedNum + " arg(s), got " + arr.length);
		}
	}

	/**
	 * <p>Getter for the field <code>jrt</code>.</p>
	 *
	 * @return the Runtime
	 */
	protected JRT getJrt() {
		return jrt;
	}

	/**
	 * <p>Getter for the field <code>vm</code>.</p>
	 *
	 * @return the Variable Manager
	 */
	protected VariableManager getVm() {
		return vm;
	}

	/**
	 * <p>Getter for the field <code>settings</code>.</p>
	 *
	 * @return the Settings
	 */
	protected AwkSettings getSettings() {
		return settings;
	}
}
