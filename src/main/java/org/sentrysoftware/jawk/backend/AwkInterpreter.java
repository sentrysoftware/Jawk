package org.sentrysoftware.jawk.backend;

/*-
 * ╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲
 * Jawk
 * ჻჻჻჻჻჻
 * Copyright (C) 2006 - 2023 Sentry Software
 * ჻჻჻჻჻჻
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * ╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱
 */

import org.sentrysoftware.jawk.ExitException;
import org.sentrysoftware.jawk.intermediate.AwkTuples;

/**
 * Interpret a Jawk script within this JVM.
 *
 * @author Danny Daglas
 */
public interface AwkInterpreter {

	/**
	 * Traverse the tuples, interpreting tuple opcodes and arguments
	 * and acting on them accordingly.
	 *
	 * @param tuples The tuples to compile.
	 * @throws org.sentrysoftware.jawk.ExitException indicates that the interpreter would like
	 *   the application to exit.
	 */
	void interpret(AwkTuples tuples) throws ExitException;
}
