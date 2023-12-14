package org.sentrysoftware.jawk.backend;

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
