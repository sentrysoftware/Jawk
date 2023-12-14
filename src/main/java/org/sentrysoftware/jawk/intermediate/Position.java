package org.sentrysoftware.jawk.intermediate;

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
 * Marks a position within the tuple list (queue).
 *
 * @author Danny Daglas
 */
public interface Position {

	/**
	 * <p>isEOF.</p>
	 *
	 * @return true whether we are at the end
	 *   of the tuple list, false otherwise
	 */
	boolean isEOF();

	/**
	 * Advances the position to the next tuple,
	 * as ordered within the tuple list (queue).
	 */
	void next();

	/**
	 * <p>opcode.</p>
	 *
	 * @return the opcode for the tuple at this
	 *	position
	 */
	int opcode();

	/**
	 * Get the integer representation for a particular
	 * element within the tuple.
	 *
	 * @param idx The item to retrieve from the tuple.
	 * @return the integer representation of the item.
	 */
	long intArg(int idx);

	/**
	 * Get the boolean representation for a particular
	 * element within the tuple.
	 *
	 * @param idx The item to retrieve from the tuple.
	 * @return the boolean representation of the item.
	 */
	boolean boolArg(int idx);

	/**
	 * Get a reference to a particular element
	 * within the tuple.
	 *
	 * @param idx The item to retrieve from the tuple.
	 * @return a reference to the item.
	 */
	Object arg(int idx);

	/**
	 * Obtain the address argument for this tuple.
	 * <p>
	 * This is a special form in that the tuple
	 * has only the address argument, and nothing else.
	 *
	 * @return a {@link org.sentrysoftware.jawk.intermediate.Address} object
	 */
	Address addressArg();

	/**
	 * Obtain the class argument for this tuple.
	 * <p>
	 * This is a special form in that the tuple
	 * has only the class argument, and nothing else.
	 *
	 * @return a {@link java.lang.Class} object
	 */
	Class<?> classArg();

	/**
	 * Get the source line number for this position.
	 *
	 * @return a int
	 */
	int lineNumber();
}
