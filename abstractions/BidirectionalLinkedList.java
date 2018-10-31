package abstractions;

/**
 * A doubly linked list is a linked data structure that consists of a set of
 * sequentially linked nodes. Each node contains two links that references the
 * previous and the next nodes in the list. The beginning and ending nodes point
 * to a sentinel node (NIL) to facilitate iterates over the list. While adding
 * or removing a node in a doubly linked list requires changing more links than
 * the same operations on a singly linked list, the operations are simpler and
 * potentially more efficient.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface BidirectionalLinkedList<T> extends LinkedList<T> {

	/**
	 * Inserts a new element in the first position (head) of the list. The "head"
	 * reference must be updated.
	 * 
	 * @param element the element to be inserted.
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
