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

import java.util.ArrayList;

/**
 * A stack implemented with an ArrayList.
 * Unlike the <code>java.util.Stack</code> which uses a
 * <code>java.util.Vector</code> as a storage mechanism,
 * this implementation is non-synchronized to improve performance.
 * <p>
 * It performs quicker than the <code>LinkedListStackImpl</code> version.
 *
 * <p>
 * There is no maximum capacity which is enforced, nor is there any
 * checks if <code>pop()</code> is executed on an empty stack.
 *
 * @author Danny Daglas
 */
public class ArrayStackImpl<E> extends ArrayList<E> implements MyStack<E> {

	private static final long serialVersionUID = 1L;

	/**
	 * Allocates an ArrayList with a capacity of 100.
	 */
	public ArrayStackImpl() {
		super(100);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Push an item to the stack.
	 */
	@Override
	public void push(E o) {
		add(o);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Pops an item off the stack.
	 * <p>
	 * Warning: no checks are done in terms of size, etc.
	 * If a <code>pop()</code> is called on an empty stack,
	 * an <code>ArrayIndexOutOfBoundException</code> is thrown.
	 */
	@Override
	public E pop() {
		return remove(size() - 1);
	}

	/** {@inheritDoc} */
	@Override
	public E peek() {
		return get(size() - 1);
	}
}
