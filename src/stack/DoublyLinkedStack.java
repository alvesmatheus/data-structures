package stack;

import abstractStructures.Stack;
import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;
import iterativeLinkedList.DoublyLinkedList;

/**
 * A doubly linked stack is a Last-In-First-Out (LIFO) data structure which
 * elements are kept in order using a doubly linked list instead of their
 * physical placement in memory. The main operations are push and pop. As a LIFO
 * data structure, the first element added will be the last one to be removed.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class DoublyLinkedStack<T> implements Stack<T> {

	protected DoublyLinkedList<T> list;
	protected int size;

	/**
	 * Constructs a DoublyLinkedStack from the given size parameter. This
	 * DoublyLinkedStack is initially empty and its list starts as an empty
	 * DoublyLinkedList. This stack will be able to contain and operate with T-typed
	 * objects. The size must be positive.
	 * 
	 * @param size
	 *            The size of the new DoublyLinkedStack.
	 * 
	 */
	public DoublyLinkedStack(int size) {
		if (size >= 0) {
			this.size = size;
			this.list = new DoublyLinkedList<T>();
		}
	}

	/**
	 * This method validates a element received by the queue. The element must not
	 * be null to be validated.
	 * 
	 * @param element
	 *            The element to be validated.
	 * 
	 * @return the boolean that indicates if the element is valid.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * Returns true, if the stack is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the stack is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the stack is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.size == this.list.size());
	}

	/**
	 * Returns (without removing) the latest element of the stack or null if the
	 * stack is empty.
	 * 
	 * @return the latest element of the stack (or null if the stack is empty).
	 * 
	 */
	@Override
	public T top() {
		return ((DoublyLinkedList<T>) this.list).getHead().getData();
	}

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
	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}

		if (this.isValidInput(element)) {
			this.list.insertFirst(element);
		}

	}

	/**
	 * Removes the latest element from the queue and returns it. If the stack is
	 * empty, this method throws a exception.
	 * 
	 * @return the popped element.
	 * 
	 * @throws StackUnderflowException
	 * 
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}

		T unstacked = this.top();
		this.list.removeFirst();

		return unstacked;
	}

}