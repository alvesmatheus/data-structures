package abstractStructures;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

/**
 * The interface of a generic stack. The stack is able to store any kind of
 * data.
 *
 */
public interface Stack<T> {

	/**
	 * Inserts a new element in the stack or returns an exception if the stack is
	 * already full. Null elements are not allowed (the queue remains unchanged).
	 * 
	 * @param element
	 *            The element that must be pushed.
	 * 
	 * @throws StackOverflowException
	 * 
	 */
	public void push(T element) throws StackOverflowException;

	/**
	 * If the stack has elements, it removes the newest one in the stack and returns
	 * it. Otherwise, it throws an exception.
	 * 
	 * @return the popped element.
	 * 
	 * @throws StackUnderflowException
	 * 
	 */
	public T pop() throws StackUnderflowException;

	/**
	 * Returns (without removing) the top of the stack or null if the stack is
	 * empty.
	 * 
	 * @return the newest element of the stack (or null if the stack is empty).
	 * 
	 */
	public T top();

	/**
	 * Returns true, if the stack is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is full.
	 * 
	 */
	public boolean isFull();

}
