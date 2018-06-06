package recursiveLinkedList;

import abstractStructures.BidirectionalLinkedList;

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
	 * Constructs a new DoublyLinkedList which data and next attributes will be
	 * equals to the given parameters.
	 * 
	 * @param data
	 *            The data to be stored at the new node.
	 * @param next
	 *            The DoublyLinkedList that comes after the one being created.
	 * @param previous
	 *            The DoublyLinkedList that comes before the one being created.
	 * 
	 */
	public DoublyLinkedList(T data, DoublyLinkedList<T> next, DoublyLinkedList<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public DoublyLinkedList<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(DoublyLinkedList<T> previous) {
		this.previous = previous;
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
	 * 
	 */
	@Override
	public void insert(T element) {
		if (this.isValidInput(element)) {

			if (this.isEmpty()) {
				DoublyLinkedList<T> newNIL = new DoublyLinkedList<T>(null, null, this);

				this.setData(element);
				this.setNext(newNIL);

				if (this.getPrevious() == null) {
					this.setPrevious(new DoublyLinkedList<T>(null, this, null));
				}
			}

			else {
				this.getNext().insert(element);
			}
		}
	}

	/**
	 * Inserts a new element in the first position (head) of the list.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insertFirst(T element) {
		if (this.isValidInput(element)) {

			if (this.isEmpty()) {
				DoublyLinkedList<T> newNIL1 = new DoublyLinkedList<T>(null, null, this);
				DoublyLinkedList<T> newNIL2 = new DoublyLinkedList<T>(null, this, null);

				this.setData(element);
				this.setNext(newNIL1);
				this.setPrevious(newNIL2);
			}

			else if (this.getPrevious().isEmpty()) {
				DoublyLinkedList<T> newNode = new DoublyLinkedList<T>(this.getData(),
						(DoublyLinkedList<T>) this.getNext(), this);

				this.setData(element);
				this.setNext(newNode);

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
	 * Removes an element from the list. If the element is not contained in the
	 * list, the list must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (this.isValidInput(element)) {
			if (!this.isEmpty()) {

				if (this.getData().equals(element)) {

					if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
						this.setData(null);
						this.setNext(null);
						this.setPrevious(null);
					}

					else {
						setData(this.getNext().getData());
						setNext(this.getNext().getNext());

						if (this.getNext() != null) {
							if (this.getNext() instanceof DoublyLinkedList<?>) {
								((DoublyLinkedList<T>) this.getNext()).setPrevious(this);
							}
						}
					}
				}

				else {
					this.getNext().remove(element);
				}
			}
		}
	}

	/**
	 * Removes the first element (head) of the list.
	 * 
	 */
	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {

			if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				this.setPrevious(null);
			}

			else if (this.getPrevious().isEmpty()) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());

				if (this.getNext() instanceof DoublyLinkedList<?>) {
					((DoublyLinkedList<T>) this.getNext()).setPrevious(this);
				}
			}

			else {
				this.getPrevious().removeFirst();
			}
		}
	}

	/**
	 * Removes the last element (last) of the list.
	 * 
	 */
	@Override
	public void removeLast() {
		if (!this.isEmpty()) {

			if (this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
				this.setPrevious(null);
			}

			else if (this.getNext().isEmpty()) {
				this.setData(this.getPrevious().getData());
				this.setPrevious(this.getPrevious().getPrevious());

				this.getPrevious().setNext(this);
			}

			else {
				if (this.getNext() instanceof DoublyLinkedList<?>) {
					((DoublyLinkedList<T>) this.getNext()).removeLast();
				}
			}
		}
	}

}
