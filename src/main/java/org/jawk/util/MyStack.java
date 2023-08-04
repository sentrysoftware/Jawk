package org.jawk.util;

/**
 * A stack-like interface.
 * <p>
 * Unfortunately, <code>java.util.Stack</code> uses a Vector, and is,
 * therefore, needlessly synchronized in a non-multi-threaded
 * environment. As a result, it was necessary to re-implement the
 * stack in this manner by using a non-synchronized list.
 *
 * @version $Id: $Id
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
