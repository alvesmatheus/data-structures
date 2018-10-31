package singlyLinkedList.iterative;

/**
 * A iterative Linked List is based on the connection of several nodes. A
 * SinglyLinkedListNode must contain one of the elements stored by the list and
 * a link to its successor (called "next"). The nodes are responsible for
 * guarantee the possibility to iterate over the whole list just using the
 * links.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SinglyLinkedListNode<T> {

	protected T data;
	protected SinglyLinkedListNode<T> next;

	/**
	 * Constructs an empty SinglyLinkedListNode (data and next will be null), known
	 * as NIL.
	 * 
	 */
	public SinglyLinkedListNode() {
	}

	/**
	 * Constructs a SinglyLinkedListNode containing the data given as parameter and
	 * whose next is also a SinglyLinkedListNode given as parameter.
	 * 
	 * @param data The data that must be stored at the node.
	 * @param next The next node of the SinglyLinkedList containing this node.
	 * 
	 */
	public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyLinkedListNode<T> getNext() {
		return this.next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}

	/**
	 * Returns true if the node executing this method is a NIL. Otherwise, returns
	 * false. To be a NIL, a node must have null data attribute.
	 * 
	 * @return The boolean that indicates if the node is a NIL.
	 * 
	 */
	public boolean isNIL() {
		return (this.data == null);
	}

	/**
	 * Compares the node executing this method with the Object given as parameter to
	 * determine if they are equals. To be equals, if the SinglyLinkedListNode is
	 * not a NIL, the Object must contain the same data. Otherwise, it must be a NIL
	 * too.
	 * 
	 * @return The boolean that indicates the equality between the node and the
	 *         object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;

		if (obj instanceof SinglyLinkedListNode) {
			if (!this.isNIL()) {
				equals = this.data.equals(((SinglyLinkedListNode<T>) obj).data);
			} else {
				equals = ((SinglyLinkedListNode<T>) obj).isNIL();
			}

		}

		return equals;
	}

	/**
	 * Returns a textual representation of the node using this method. For NIL nodes
	 * it will be "NIL", for regular nodes the representation will be the toString()
	 * of the stored data.
	 * 
	 * @return The textual representation of the node.
	 * 
	 */
	@Override
	public String toString() {
		String toString = null;

		if (!isNIL()) {
			toString = this.data.toString();
		} else {
			toString = "NIL";
		}

		return toString;
	}

}
