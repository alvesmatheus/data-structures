package singlyLinkedList.iterative;

import abstractions.LinkedList;

/**
 * A singly linked list is a linear collection of data elements, whose order is
 * not given by their physical placement in memory. Instead, each element points
 * to the next one. It is a data structure consisting of a collection of nodes
 * which together represent a sequence. Each node contains: data and a link to
 * the next node in the sequence.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

	protected SinglyLinkedListNode<T> head;

	/**
	 * Constructs a new SinglyLinkedList which head attribute will start as a NIL
	 * node.
	 * 
	 */
	public SinglyLinkedList() {
		this.head = new SinglyLinkedListNode<T>();
	}

	public SinglyLinkedListNode<T> getHead() {
		return this.head;
	}

	protected void setHead(SinglyLinkedListNode<T> head) {
		this.head = head;
	}

	/**
	 * This method validates a element received by the list. The element must not be
	 * null to be validated.
	 * 
	 * @param element The element to be validated.
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
		return this.getHead().isNIL();
	}

	/**
	 * Returns the number of elements contained in the list.
	 * 
	 * @return the size of the list.
	 * 
	 */
	@Override
	public int size() {
		SinglyLinkedListNode<T> node = this.getHead();
		int size = 0;

		while (!node.isNIL()) {
			size++;
			node = node.getNext();
		}

		return size;
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
		if (this.isValidInput(element)) {
			if (this.isEmpty()) {
				SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(element, this.getHead());
				this.setHead(newNode);
			}

			else {
				SinglyLinkedListNode<T> auxNode = this.getHead();

				while (!auxNode.getNext().isNIL()) {
					auxNode = auxNode.getNext();
				}

				SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(element, auxNode.getNext());
				auxNode.setNext(newNode);
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
		if (this.isValidInput(element)) {
			if (this.getHead().getData().equals(element)) {
				this.setHead(this.getHead().getNext());
			}

			else {
				SinglyLinkedListNode<T> auxNode = this.getHead();

				while ((!auxNode.isNIL()) && (!auxNode.getNext().getData().equals(element))) {
					auxNode = auxNode.getNext();
				}

				if (!auxNode.getNext().isNIL()) {
					auxNode.setNext(auxNode.getNext().getNext());
				}
			}
		}
	}

	/**
	 * Searches for a given element in the list. It will return the element if the
	 * list contains it. Otherwise, it will return null.
	 * 
	 * @param element the element being searched for.
	 * 
	 * @return the searched element, if it is in the list, or null, otherwise.
	 * 
	 */
	@Override
	public T search(T element) {
		SinglyLinkedListNode<T> auxNode = this.getHead();
		T target = null;

		while ((!auxNode.isNIL())) {
			if (auxNode.getData().equals(element)) {
				target = auxNode.getData();
			}

			auxNode = auxNode.getNext();
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

		SinglyLinkedListNode<T> auxNode = this.getHead();

		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];

		int i = 0;
		if (!this.isEmpty()) {
			while (!auxNode.isNIL()) {
				array[i] = auxNode.getData();
				auxNode = auxNode.getNext();
				i++;
			}
		}

		return array;
	}

}