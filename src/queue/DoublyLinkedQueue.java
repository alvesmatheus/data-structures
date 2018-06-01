package queue;

import abstractStructures.Queue;
import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;
import iterativeLinkedList.DoublyLinkedList;

/**
 * A doubly linked queue is a First-In-First-Out (FIFO) data structure re kept
 * in order using a doubly linked list instead of their physical placement in
 * memory. The main operations are enqueue and dequeue. As a FIFO data
 * structure, the first element added will be the first one to be removed.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class DoublyLinkedQueue<T> implements Queue<T> {

	protected DoublyLinkedList<T> list;
	protected int size;

	/**
	 * Constructs a DoublyLinkedQueue from the given positive size parameter. This
	 * DoublyLinkQueue is initially empty, so its list starts as an empty
	 * DoublyLinkedList. Also, this queue will be able to contain and operate with
	 * T-typed objects. The size must be positive.
	 * 
	 * @param size
	 *            The size of the new DoublyLinkedQueue.
	 * 
	 */
	public DoublyLinkedQueue(int size) {
		if (size >= 0) {
			this.size = size;
			this.list = new DoublyLinkedList<T>();
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
			this.list.insert(element);
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
		this.list.removeFirst();

		return dequeued;
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
		return ((DoublyLinkedList<T>) this.list).getHead().getData();
	}

	/**
	 * Returns true, if the queue is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Returns true, if the queue is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is full.
	 * 
	 */
	@Override
	public boolean isFull() {
		return (this.size == this.list.size());
	}

}
