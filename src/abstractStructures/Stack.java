package abstractStructures;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

/**
 * A stack is a Last-In-First-Out (LIFO) data structure which elements are kept
 * in order and which main operations are push and pop. In a LIFO data
 * structure, the first element added will be the last one to be removed.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface Stack<T> {

	/**
	 * Returns true, if the stack is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the stack is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the stack is full.
	 * 
	 */
	public boolean isFull();

	/**
	 * Returns (without removing) the latest element of the stack or null if the
	 * stack is empty.
	 * 
	 * @return the latest element of the stack (or null if the stack is empty).
	 * 
	 */
	public T top();

	/**
	 * Inserts a new element in the stack or throws an exception if the stack is
	 * already full. Null elements are not allowed. If the given element is null,
	 * the stack will remain unchanged.
	 * 
	 * @param element
	 *            The element to be pushed.
	 * 
	 * @throws StackOverflowException
	 * 
	 */
	public void push(T element) throws StackOverflowException;

	/**
	 * Removes the latest element from the queue and returns it. If the stack is
	 * empty, this method throws a exception.
	 * 
	 * @return the popped element.
	 * 
	 * @throws StackUnderflowException
	 * 
	 */
	public T pop() throws StackUnderflowException;

}
