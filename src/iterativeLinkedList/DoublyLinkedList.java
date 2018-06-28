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
	 * Constructs a new DoublyLinkedList whose head and last attributes will start
	 * as the same NIL node.
	 * 
	 */
	public DoublyLinkedList() {
		this.last = new DoublyLinkedListNode<T>();
		super.setHead(this.last);
	}

	public DoublyLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoublyLinkedListNode<T> last) {
		this.last = last;
	}

	/**
	 * Inserts a new element at the end of the list. Null elements are not allowed.
	 * If the given element is null, the list will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {
		if (super.isValidInput(element)) {

			DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();

			newNIL.setPrevious(newNode);

			newNode.setData(element);
			newNode.setNext(newNIL);
			newNode.setPrevious(this.getLast());

			this.getLast().setNext(newNode);

			if (this.getLast().isNIL()) {
				setHead(newNode);
			}

			setLast(newNode);
		}
	}

	/**
	 * Inserts a new element at the beginning of the list. Null elements are not
	 * allowed. If the given element is null, the list will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insertFirst(T element) {
		if (super.isValidInput(element)) {

			DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();

			newNIL.setNext(newNode);

			newNode.setData(element);
			newNode.setNext(super.getHead());
			newNode.setPrevious(newNIL);

			((DoublyLinkedListNode<T>) super.getHead()).setPrevious(newNode);

			if (this.getHead().isNIL()) {
				setLast(newNode);
			}

			setHead(newNode);
		}
	}

	/**
	 * Removes an element from the list. If the list does not contain the element,
	 * the list must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (super.isValidInput(element)) {

			if (super.getHead().getData().equals(element)) {
				this.removeFirst();
			}

			else if (this.getLast().getData().equals(element)) {
				this.removeLast();
			}

			else {
				DoublyLinkedListNode<T> auxNode = (DoublyLinkedListNode<T>) super.getHead();

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
	 * Removes the first element of the list.
	 * 
	 */
	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {

			if (super.getHead().getNext().isNIL()) {
				setHead(new DoublyLinkedListNode<T>()); // The list is now a single NIL.
				setLast((DoublyLinkedListNode<T>) super.getHead());
			}

			else {
				DoublyLinkedListNode<T> newNIL = new DoublyLinkedListNode<T>();
				newNIL.setNext(super.getHead().getNext());

				setHead(super.getHead().getNext());
				((DoublyLinkedListNode<T>) super.getHead()).setPrevious(newNIL);
			}
		}
	}

	/**
	 * Removes the last element of the list.
	 * 
	 */
	@Override
	public void removeLast() {
		if (!super.isEmpty()) {

			if (this.getLast().getPrevious().isNIL()) {
				setHead(new DoublyLinkedListNode<T>()); // The list is now a single NIL.
				setLast((DoublyLinkedListNode<T>) super.getHead());
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
