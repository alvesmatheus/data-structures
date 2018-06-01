package queue;

import abstractStructures.Queue;
import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

/**
 * A queue is a First-In-First-Out (FIFO) data structure which elements are kept
 * in order and which main operations are enqueue and dequeue. In a FIFO data
 * structure, the first element added will be the first one to be removed. A
 * queue is an example of a linear data structure, or more abstractly, a
 * sequential collection.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class BasicQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;

	/**
	 * Constructs a BasicQueue from the given positive size parameter. This BasicQueue is
	 * initially empty, so its tail starts as -1. Also, this queue will be able to
	 * contain and operate with T-typed objects. The size must be positive.
	 * 
	 * @param size
	 *            The size of the new BasicQueue.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BasicQueue(int size) {
		if (size >= 1) {
			array = (T[]) new Object[size];
			tail = -1;
		}
	}

	/**
	 * This method validates a element received by the queue. The element must not
	 * be null to the queue operations work properly.
	 * 
	 * @param element
	 *            The element that must be used in a queue operation.
	 * 
	 * @return the boolean that represents the element validity.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * Returns true, if the queue is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.tail == -1);
	}

	/**
	 * Returns true, if the queue is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.tail == (this.array.length - 1));
	}

	/**
	 * Returns (without removing) the oldest element of the queue or null if the
	 * queue is empty.
	 * 
	 * @return the first element of the queue (or null if the queue is empty).
	 * 
	 */
	@Override
	public T head() {
		T head = null;

		if (!this.isEmpty()) {
			head = this.array[0];
		}

		return head;
	}

	/**
	 * Inserts a new element in the queue or returns an exception if the queue is
	 * already full. Null elements are not allowed (the queue remains unchanged).
	 * 
	 * @param element
	 *            The element that must be enqueued.
	 * 
	 * @throws QueueOverflowException
	 * 
	 */
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}

		if (this.isValidInput(element)) {
			this.array[++this.tail] = element;
		}
	}

	/**
	 * Iterates over the queue's array, making every element equal to its successor.
	 * It is a linear operation that helps the dequeuing process.
	 * 
	 */
	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++) {
			this.array[i] = this.array[i + 1];
		}
	}

	/**
	 * If the queue has elements, it removes the oldest one in the queue and returns
	 * it. Otherwise, it throws an exception.
	 * 
	 * @return the dequeued element.
	 * 
	 * @throws QueueUnderflowException
	 * 
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}

		T dequeued = this.head();
		this.shiftLeft();
		this.tail--;

		return dequeued;
	}

}