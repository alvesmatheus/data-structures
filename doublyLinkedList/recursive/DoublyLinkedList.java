package doublyLinkedList.recursive;

import abstractions.BidirectionalLinkedList;
import singlyLinkedList.recursive.SinglyLinkedList;

/**
 * A doubly linked list is a linked data structure that consists of a set of
 * sequentially linked nodes. Each node contains two links that references the
 * previous and the next nodes in the list. The beginning and ending nodes point
 * to a sentinel node (NIL) to facilitate iterates over the list. While adding
 * or removing a node in a doubly linked list requires changing more links than
 * the same operations on a singly linked list, the operations are simpler and
 * potentially more efficient. In this recursive implementation, each node is a
 * doubly linked list itself.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T> implements BidirectionalLinkedList<T> {

	protected DoublyLinkedList<T> previous;

	/**
	 * Constructs a new DoublyLinkedList which data, next and previous attributes
	 * will start as null. It can be called NIL node or empty list.
	 * 
	 */
	public DoublyLinkedList() {
	}

	/**
	 * Constructs a new DoublyLinkedList whose data and next attributes will be
	 * equals to the given parameters.
	 * 
	 * @param data     The data to be stored at the new node.
	 * @param next     The DoublyLinkedList that comes after the one being created.
	 * @param previous The DoublyLinkedList that comes before the one being created.
	 * 
	 */
	public DoublyLinkedList(T data, DoublyLinkedList<T> next, DoublyLinkedList<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public DoublyLinkedList<T> getPrevious() {
		return this.previous;
	}

	protected void setPrevious(DoublyLinkedList<T> previous) {
		this.previous = previous;
	}

	/**
	 * Inserts a new element at the end of the list. Null elements are not allowed.
	 * If the given element is null, the list will remain unchanged.
	 * 
	 * @param element the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {
		if (super.isValidInput(element)) {

			if (super.isEmpty()) {
				DoublyLinkedList<T> newNIL = new DoublyLinkedList<T>(null, null, this);

				super.setData(element);
				super.setNext(newNIL);

				if (this.getPrevious() == null) {
					this.setPrevious(new DoublyLinkedList<T>(null, this, null));
				}
			}

			else {
				super.getNext().insert(element);
			}
		}
	}

	/**
	 * Inserts a new element at the beginning of the list. Null elements are not
	 * allowed. If the given element is null, the list will remain unchanged.
	 * 
	 * @param element the element to be inserted.
	 * 
	 */
	@Override
	public void insertFirst(T element) {
		if (super.isValidInput(element)) {

			if (super.isEmpty()) {
				DoublyLinkedList<T> newNIL1 = new DoublyLinkedList<T>(null, null, this);
				DoublyLinkedList<T> newNIL2 = new DoublyLinkedList<T>(null, this, null);

				super.setData(element);
				super.setNext(newNIL1);
				this.setPrevious(newNIL2);
			}

			else if (this.getPrevious().isEmpty()) {
				DoublyLinkedList<T> newNode = new DoublyLinkedList<T>(super.getData(),
						(DoublyLinkedList<T>) super.getNext(), this);

				super.setData(element);
				super.setNext(newNode);

				if (newNode.getNext() instanceof DoublyLinkedList<?>) {
					((DoublyLinkedList<T>) newNode.getNext()).setPrevious(newNode);
				}
			}

			else {
				this.getPrevious().insertFirst(element);
			}
		}
	}

	/**
	 * Removes an element from the list. If the list does not contain the element,
	 * the list must remain unchanged.
	 * 
	 * @param element the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (super.isValidInput(element)) {
			if (!super.isEmpty()) {

				if (super.getData().equals(element)) {

					if (this.getPrevious().isEmpty() && super.getNext().isEmpty()) {
						super.setData(null);
						super.setNext(null);
						this.setPrevious(null);
					}

					else {
						setData(super.getNext().getData());
						setNext(super.getNext().getNext());

						if (super.getNext() != null) {
							if (super.getNext() instanceof DoublyLinkedList<?>) {
								((DoublyLinkedList<T>) super.getNext()).setPrevious(this);
							}
						}
					}
				}

				else {
					super.getNext().remove(element);
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
		if (!super.isEmpty()) {

			if (this.getPrevious().isEmpty() && super.getNext().isEmpty()) {
				super.setData(null);
				super.setNext(null);
				this.setPrevious(null);
			}

			else if (this.getPrevious().isEmpty()) {
				super.setData(this.getNext().getData());
				super.setNext(this.getNext().getNext());

				if (super.getNext() instanceof DoublyLinkedList<?>) {
					((DoublyLinkedList<T>) this.getNext()).setPrevious(this);
				}
			}

			else {
				this.getPrevious().removeFirst();
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

			if (this.getPrevious().isEmpty() && super.getNext().isEmpty()) {
				super.setData(null);
				super.setNext(null);
				this.setPrevious(null);
			}

			else if (super.getNext().isEmpty()) {
				super.setData(this.getPrevious().getData());
				this.setPrevious(this.getPrevious().getPrevious());

				this.getPrevious().setNext(this);
			}

			else {
				if (super.getNext() instanceof DoublyLinkedList<?>) {
					((DoublyLinkedList<T>) super.getNext()).removeLast();
				}
			}
		}
	}

}
