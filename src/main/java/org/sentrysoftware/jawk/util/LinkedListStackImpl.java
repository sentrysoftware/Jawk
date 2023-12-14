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

import java.util.LinkedList;

/**
 * A simple delegate to a LinkedList.
 * Unlike <code>java.util.Stack</code>,
 * this implementation is non-synchronized to improve performance.
 * <p>
 * It performs slower than the ArrayStackImpl version.
 *
 * <p>
 * There is no maximum capacity which is enforced, nor is there any
 * checks if pop() is executed on an empty stack.
 *
 * @author Danny Daglas
 */
public class LinkedListStackImpl<E> extends LinkedList<E> implements MyStack<E> {

	private static final long serialVersionUID = 1L;

	/** {@inheritDoc} */
	@Override
	public void push(E o) {
		addFirst(o);
	}

	/** {@inheritDoc} */
	@Override
	public E pop() {
		return removeFirst();
	}
}
