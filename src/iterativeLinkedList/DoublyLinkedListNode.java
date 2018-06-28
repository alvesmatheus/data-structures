package iterativeLinkedList;

/**
 * A iterative Doubly Linked List is based on the connection of several nodes. A
 * DoublyLinkedListNode must contain one of the elements stored by the list and
 * two links: one to its successor (called "next") and other to its predecessor
 * (called "previous"). The nodes are responsible for guarantee the possibility
 * to iterate over the whole list (in both directions) just using the links.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class DoublyLinkedListNode<T> extends SinglyLinkedListNode<T> {

	protected DoublyLinkedListNode<T> previous;

	/**
	 * Constructs an empty DoublyLinkedListNode (data, previous and next will be
	 * null), known as NIL.
	 * 
	 */
	public DoublyLinkedListNode() {
	}

	/**
	 * Constructs a DoublyLinkedListNode containing the data given as parameter and
	 * whose next and previous are also a DoublyLinkedListNode given as parameters.
	 * 
	 * @param data
	 *            The data to be stored in the node.
	 * @param next
	 *            The next node of the DoublyLinkedList containing this node.
	 * @param next
	 *            The previous node of the DoublyLinkedList containing this node.
	 * 
	 */
	public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public DoublyLinkedListNode<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(DoublyLinkedListNode<T> previous) {
		this.previous = previous;
	}

}
