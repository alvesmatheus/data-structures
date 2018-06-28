package iterativeLinkedList;

/**
 * A singly linked list is a linear collection of data elements, whose order is
 * not given by their physical placement in memory. Instead, each element points
 * to the next one. It is a data structure consisting of a collection of nodes
 * which together represent a sequence. Each node contains: data and a link to
 * the next node in the sequence.
 * 
 * This variation of a singly linked list contains some extra methods, allowing
 * unexpected features. It was created as a way to improve the knowledge about
 * linked lists.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SpecialSinglyLinkedList<T> extends SinglyLinkedList<T> {

	/**
	 * This method validates two element received by the list. The elements must not
	 * be null to be validated.
	 * 
	 * @param element1
	 *            The first element to be validated.
	 * @param element2
	 *            The second element to be validated.
	 * 
	 * @return the boolean that indicates if the elements are valid.
	 * 
	 */
	private boolean isValidInput(T element1, T element2) {
		return ((element1 != null) && (element2 != null));
	}

	/**
	 * Swaps two elements of the list. If the list does not contain at least one of
	 * them, the list remains unchanged.
	 * 
	 * @param element1
	 *            The first element to be swapped.
	 * @param element2
	 *            The second element to be swapped.
	 * 
	 */
	public void swap(T element1, T element2) {
		if (this.isValidInput(element1, element2)) {
			SinglyLinkedListNode<T> firstNode = null;
			SinglyLinkedListNode<T> secondNode = null;

			SinglyLinkedListNode<T> currentNode = this.getHead();

			while (!currentNode.isNIL()) {
				if (currentNode.getData().equals(element1)) {
					firstNode = currentNode;
				} else if (currentNode.getData().equals(element2)) {
					secondNode = currentNode;
				}

				currentNode = currentNode.getNext();
			}

			if ((firstNode != null) && (secondNode != null)) {
				T keepData = secondNode.getData();

				secondNode.setData(firstNode.getData());
				firstNode.setData(keepData);
			}
		}
	}

	/**
	 * Returns the k-th element before the end of the list. For example, if
	 * backwardIndex = 1 this method will return the last element.
	 * 
	 * @param backwardIndex
	 *            the index of the target element starting from the end of the list.
	 *
	 * @return the k-th element before the end of the list or null, if the list has
	 *         less than k elements.
	 * 
	 */
	public T elementFromTheEnd(int backwardIndex) {
		T target = null;

		if (backwardIndex > 0) {
			SinglyLinkedListNode<T> targetNode = this.getHead();
			SinglyLinkedListNode<T> scoutNode = this.getHead();

			boolean listTooShort = false;

			for (int i = 0; i < (backwardIndex - 1); i++) {
				if (scoutNode.getNext().isNIL()) {
					listTooShort = true;
				}

				else {
					scoutNode = scoutNode.getNext();
				}
			}

			if (!listTooShort) {
				while (!scoutNode.getNext().isNIL()) {
					targetNode = targetNode.getNext();
					scoutNode = scoutNode.getNext();
				}

				target = targetNode.getData();
			}
		}

		return target;
	}

}
