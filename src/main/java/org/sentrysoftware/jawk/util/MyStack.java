package org.sentrysoftware.jawk.util;

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
 * A stack-like interface.
 * <p>
 * Unfortunately, <code>java.util.Stack</code> uses a Vector, and is,
 * therefore, needlessly synchronized in a non-multi-threaded
 * environment. As a result, it was necessary to re-implement the
 * stack in this manner by using a non-synchronized list.
 *
 * @author Danny Daglas
 */
public interface MyStack<E> {

	/**
	 * Push an item onto the stack.
	 *
	 * @param o The item to push onto the stack.
	 */
	void push(E o);

	/**
	 * Pop an item off the stack and return that item
	 * to the callee.
	 *
	 * @return The top of the stack, which is subsequently
	 *   removed from the stack.
	 */
	E pop();

	/**
	 * <p>size.</p>
	 *
	 * @return The number of elements within the stack.
	 */
	int size();

	/**
	 * Eliminate all items from the stack.
	 */
	void clear();

	/**
	 * Inspect the top-most element without affecting the stack.
	 *
	 * @return the top of the stack, without removing it from the stack
	 */
	E peek();
}
