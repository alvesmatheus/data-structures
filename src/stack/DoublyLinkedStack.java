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
	 * DoublyLinkedList. This stack will be able to contain and operate with
	 * T-typed objects. The size must be positive.
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
	 * This method validates a element received by the stack. The element must not
	 * be null to the stack operations work properly.
	 * 
	 * @param element
	 *            The element that must be used in a stack operation.
	 * 
	 * @return the boolean that represents the element validity.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

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
	 * If the stack has elements, it removes the newest one in the stack and returns
	 * it. Otherwise, it throws an exception.
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

	/**
	 * Returns (without removing) the newest element of the stack or null if the
	 * stack is empty.
	 * 
	 * @return the newest element of the stack (or null if the stack is empty).
	 * 
	 */
	@Override
	public T top() {
		return ((DoublyLinkedList<T>) this.list).getHead().getData();
	}

	/**
	 * Returns true, if the stack is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.size == this.list.size());
	}

}