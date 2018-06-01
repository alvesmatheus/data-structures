package iterativeLinkedList;

import abstractStructures.BidirectionalLinkedList;

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
public class DoublyLinkedList<T> extends SinglyLinkedList<T> implements BidirectionalLinkedList<T> {

	protected DoublyLinkedListNode<T> last;

	/**
	 * Constructs a new DoublyLinkedList which head and last attributes will start
	 * as the same NIL node.
	 * 
	 */
	public DoublyLinkedList() {
		this.last = new DoublyLinkedListNode<T>();
		super.setHead(this.last);
	}

	public DoublyLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoublyLinkedListNode<T> last) {
		this.last = last;
	}

	/**
	 * This method validates a element received by the list. The element must not be
	 * null to the list operations work properly.
	 * 
	 * @param element
	 *            The element that must be used in a list operation.
	 * 
	 * @return the boolean that represents the element validity.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * Inserts a new element at the end of the list. Null elements are not allowed
	 * (the list remains unchanged).
	 * 
	 * @param element
	 *            the element to be inserted.
	 */
	@Override
	public void insert(T element) {
		if (this.isValidInput(element)) {

			DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();

			newNIL.setPrevious(newNode);

			newNode.setData(element);
			newNode.setNext(newNIL);
			newNode.setPrevious(this.last);

			this.getLast().setNext(newNode);

			if (this.getLast().isNIL()) {
				setHead(newNode);
			}

			setLast(newNode);
		}
	}

	/**
	 * Inserts a new element in the first position (head) of the list. The "head"
	 * reference must be updated.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insertFirst(T element) {
		if (this.isValidInput(element)) {

			DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();

			newNIL.setNext(newNode);

			newNode.setData(element);
			newNode.setNext(this.getHead());
			newNode.setPrevious(newNIL);

			((DoublyLinkedListNode<T>) this.getHead()).setPrevious(newNode);

			if (this.getHead().isNIL()) {
				setLast(newNode);
			}

			setHead(newNode);
		}
	}

	/**
	 * Removes an element from the list. If the element is not contained in the
	 * list, the list must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 */
	@Override
	public void remove(T element) {
		if (this.isValidInput(element)) {

			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			}

			else if (this.getLast().getData().equals(element)) {
				this.removeLast();
			}

			else {
				DoublyLinkedListNode<T> auxNode = (DoublyLinkedListNode<T>) this.getHead();

				while ((!auxNode.isNIL()) && (!auxNode.getData().equals(element))) {
					auxNode = (DoublyLinkedListNode<T>) auxNode.getNext();
				}

				if (!auxNode.isNIL()) {
					auxNode.getPrevious().setNext(auxNode.getNext());
					((DoublyLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
				}
			}
		}
	}

	/**
	 * Removes the first element (head) of the list. The "head" reference must be
	 * updated.
	 * 
	 */
	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {

			if (this.getHead().getNext().isNIL()) {
				setHead(new DoublyLinkedListNode<T>()); // The list is now a single NIL.
				setLast((DoublyLinkedListNode<T>) this.getHead());
			}

			else {
				DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
				newNIL.setNext(this.getHead().getNext());

				setHead(this.head.getNext());
				((DoublyLinkedListNode<T>) this.getHead()).setPrevious(newNIL);
			}
		}
	}

	/**
	 * Removes the last element (last) of the list. The "last" reference must be
	 * updated.
	 * 
	 */
	@Override
	public void removeLast() {
		if (!this.isEmpty()) {

			if (this.last.getPrevious().isNIL()) {
				setHead(new DoublyLinkedListNode<T>()); // The list is now a single NIL.
				setLast((DoublyLinkedListNode<T>) this.getHead());
			}

			else {
				DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
				newNIL.setPrevious(this.getLast().getPrevious());

				setLast(this.getLast().getPrevious());
				this.getLast().setNext(newNIL);
			}
		}
	}

}
