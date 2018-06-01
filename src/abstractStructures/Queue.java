package abstractStructures;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

/**
 * The interface of a generic queue. The queue is able to store any kind of
 * data.
 *
 */
public interface Queue<T> {

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
	public void enqueue(T element) throws QueueOverflowException;

	/**
	 * If the queue has elements, it removes the oldest one in the queue and returns
	 * it. Otherwise, it throws an exception.
	 * 
	 * @return the dequeued element.
	 * 
	 * @throws QueueUnderflowException
	 * 
	 */
	public T dequeue() throws QueueUnderflowException;

	/**
	 * Returns (without removing) the oldest element of the queue or null if the
	 * queue is empty.
	 * 
	 * @return the first element of the queue (or null if the queue is empty).
	 * 
	 */
	public T head();

	/**
	 * Returns true, if the queue is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns true, if the queue is full, or false, otherwise.
	 * 
	 * @return the boolean meaning if the queue is full.
	 * 
	 */
	public boolean isFull();

}