package abstractStructures;

/**
 * The interface of a generic bidirectional linked list (also known as doubly
 * linked list).
 * 
 */
public interface BidirectionalLinkedList<T> extends LinkedList<T> {

	/**
	 * Inserts a new element in the first position (head) of the list. The "head"
	 * reference must be updated.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	public void insertFirst(T element);

	/**
	 * Removes the first element (head) of the list. The "head" reference must be
	 * updated.
	 * 
	 */
	public void removeFirst();

	/**
	 * Removes the last element (last) of the list. The "last" reference must be
	 * updated.
	 * 
	 */
	public void removeLast();
}
