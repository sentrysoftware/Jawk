package org.jawk.util;

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
