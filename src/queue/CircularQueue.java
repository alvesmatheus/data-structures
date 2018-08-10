package queue;

import abstractStructures.Queue;
import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

/**
 * A queue is a First-In-First-Out (FIFO) data structure which elements are kept
 * in order and which main operations are enqueue and dequeue. In a FIFO data
 * structure, the first element added will be the first one to be removed. A
 * circular queue is an optimization of the basic queue that guarantees that
 * every operation will be done in O(1).
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	/**
	 * Constructs a CircularQueue from the given size parameter. This CircularQueue
	 * is initially empty, so its tail and head starts as -1, while its elements are
	 * initially 0. Also, this queue will be able to contain and operate with
	 * T-typed objects. The size must be positive.
	 * 
	 * @param size
	 *            The size of the new CircularQueue.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		if (size >= 1) {
			this.array = (T[]) new Object[size];
			this.elements = 0;
			this.head = -1;
			this.tail = -1;
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
	 * Returns true, if the queue is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the queue is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.elements == 0);
	}

	/**
	 * Returns true, if the queue is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the queue is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.elements == this.array.length);
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
			head = this.array[this.head];
		}

		return head;
	}

	/**
	 * Inserts a new element at the queue or throws an exception if the queue is
	 * already full. Null elements are not allowed. If the given element is null,
	 * the queue will remain unchanged.
	 * 
	 * @param element
	 *            The element to be enqueued.
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
			if ((this.head == -1) && (this.tail == -1)) {
				this.head++;
				this.tail++;
			}

			else {
				this.tail = (this.tail + 1) % this.array.length;
			}

			this.array[this.tail] = element;
			this.elements++;
		}
	}

	/**
	 * Removes the oldest element from the queue and returns it. If the queue is
	 * empty, this method throws a exception.
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
		this.elements--;

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % this.array.length;
		}

		return dequeued;
	}

}
