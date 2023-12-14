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
 * An interface to a tuple position for interpretation.
 * <p>
 * This is differentiated from a position interface for
 * compilation because compilation requires linear
 * access (i.e., non-jumps) to the tuple list, while
 * interpretation requires this as well as jump capability.
 *
 * @author Danny Daglas
 */
public interface PositionForInterpretation extends Position {

	/**
	 * Reposition to the tuple located at a particular address.
	 * This is usually done in a response to an if condition.
	 * However, this is also done to perform loops, etc.
	 *
	 * @param address The target address for the jump.
	 */
	void jump(Address address);

	/**
	 * <p>current.</p>
	 *
	 * @return The current index into the tuple list (queue)
	 *	of the tuple located at the current position.
	 */
	int current();

	/**
	 * Reposition to the tuple located at a particular index
	 * into the tuple list (queue)..
	 *
	 * @param idx The target index for the jump.
	 */
	void jump(int idx);
}
