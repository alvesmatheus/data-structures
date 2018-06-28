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
		return (this.top == -1);
	}

	/**
	 * Returns true, if the stack is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the stack is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.top == (this.array.length - 1));
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
		T top = null;

		if (!this.isEmpty()) {
			top = this.array[this.top];
		}

		return top;
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
			this.array[++this.top] = element;
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
		this.top--;

		return unstacked;
	}

}
