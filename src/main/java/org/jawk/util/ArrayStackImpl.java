package org.jawk.util;

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
 * @version $Id: $Id
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
