package recursiveLinkedList;

import abstractStructures.LinkedList;

/**
 * A singly linked list is a linear collection of data elements, whose order is
 * not given by their physical placement in memory. Instead, each element points
 * to the next one. It is a data structure consisting of a collection of nodes
 * which together represent a sequence. Each node contains: data and a link to
 * the next node in the sequence. In this recursive implementation, each node is
 * a singly linked list itself.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

	protected T data;
	protected SinglyLinkedList<T> next;

	/**
	 * Constructs a new SinglyLinkedList whose data and next attributes will start
	 * as null. It can be called NIL node or empty list.
	 * 
	 */
	public SinglyLinkedList() {
	}

	/**
	 * Constructs a new SinglyLinkedList which data and next attributes will be
	 * equals to the given parameters.
	 * 
	 * @param data
	 *            The data to be stored in the new node.
	 * @param next
	 *            The SinglyLinkedList that comes after the one being created.
	 * 
	 */
	public SinglyLinkedList(T data, SinglyLinkedList<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyLinkedList<T> getNext() {
		return this.next;
	}

	public void setNext(SinglyLinkedList<T> next) {
		this.next = next;
	}

	/**
	 * This method validates a element received by the list. The element must not be
	 * null to be validated.
	 * 
	 * @param element
	 *            The element to be validated.
	 * 
	 * @return the boolean that indicates if the element is valid.
	 * 
	 */
	protected boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * Returns true, if the list is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the list is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.getData() == null);
	}

	/**
	 * Returns the number of elements contained in the list.
	 * 
	 * @return the size of the list.
	 * 
	 */
	@Override
	public int size() {
		int size = 0;

		if (!this.isEmpty()) {
			size = 1 + this.getNext().size();
		}

		return size;
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
		if (this.isValidInput(element)) {

			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new SinglyLinkedList<T>());
			}

			else {
				this.getNext().insert(element);
			}
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
		if (this.isValidInput(element)) {
			if (!this.isEmpty()) {

				if (this.getData().equals(element)) {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
				}

				else {
					this.getNext().remove(element);
				}
			}
		}
	}

	/**
	 * Searches for a given element in the list. It will return the element if the
	 * list contains it. Otherwise, it will return null.
	 * 
	 * @param element
	 *            the element being searched for.
	 * 
	 * @return the searched element, if it is in the list, or null, otherwise.
	 * 
	 */
	@Override
	public T search(T element) {
		T target = null;

		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				target = this.getData();
			}

			else {
				target = this.getNext().search(element);
			}
		}

		return target;
	}

	/**
	 * Returns an array containing all the elements in the list. The array does not
	 * contain empty spaces (or null elements). The elements are put into the array
	 * from the beginning to the end of the list.
	 * 
	 * @return an array containing all the elements contained in the list in the
	 *         same order they appear.
	 * 
	 */
	@Override
	public T[] toArray() {

		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];

		this.recursiveToArray(array, this, 0);

		return array;
	}

	// RECURSIVE AUXILIAR METHOD TO: toArray().
	private void recursiveToArray(T[] array, SinglyLinkedList<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			this.recursiveToArray(array, node.getNext(), ++index);
		}
	}

}