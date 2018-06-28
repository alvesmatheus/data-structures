package abstractStructures;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

/**
 * A queue is a First-In-First-Out (FIFO) data structure which elements are kept
 * in order and which main operations are enqueue and dequeue. In a FIFO data
 * structure, the first element added will be the first one to be removed.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface Queue<T> {

	/**
	 * Returns true, if the queue is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the queue is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns true, if the queue is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the queue is full.
	 * 
	 */
	public boolean isFull();

	/**
	 * Returns (without removing) the oldest element of the queue or null if the
	 * queue is empty.
	 * 
	 * @return the first element of the queue (or null if the queue is empty).
	 * 
	 */
	public T head();

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
	public void enqueue(T element) throws QueueOverflowException;

	/**
	 * Removes the oldest element from the queue and returns it. If the queue is
	 * empty, this method throws a exception.
	 * 
	 * @return the dequeued element.
	 * 
	 * @throws QueueUnderflowException
	 * 
	 */
	public T dequeue() throws QueueUnderflowException;

}