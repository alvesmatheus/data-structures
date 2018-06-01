package stack;

import abstractStructures.Stack;
import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

/**
 * A stack is a Last-In-First-Out (LIFO) data structure which elements are kept
 * in order and which main operations are push and pop. In a LIFO data
 * structure, the first element added will be the last one to be removed. A
 * stack is an example of a linear data structure, or more abstractly, a
 * sequential collection.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class BasicStack<T> implements Stack<T> {

	private T[] array;
	private int top;

	/**
	 * Constructs a BasicStack from the given size parameter. This BasicStack is
	 * initially empty, so its top starts as -1. Also, this stack will be able to
	 * contain and operate with T-typed objects. The size must be positive.
	 * 
	 * @param size
	 *            The size of the new BasicStack.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BasicStack(int size) {
		if (size >= 1) {
			array = (T[]) new Object[size];
			top = -1;
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
	 * Returns true, if the stack is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the stack is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.top == (this.array.length - 1));
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
		T top = null;

		if (!this.isEmpty()) {
			top = this.array[this.top];
		}

		return top;
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
			this.array[++this.top] = element;
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
		this.top--;

		return unstacked;
	}

}
