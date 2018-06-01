package abstractStructures;

/**
 * The interface of a generic linked list.
 * 
 */
public interface LinkedList<T> {

	/**
	 * Returns true, if the list is empty, or false, otherwise.
	 * 
	 * @return the boolean meaning if the list is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements contained in the list.
	 * 
	 * @return the size of the list
	 */
	public int size();

	/**
	 * Searches for a given element in the list. It will return the element if the
	 * list contains it. Otherwise, it will return null.
	 * 
	 * @param element
	 *            the element being searched for.
	 * 
	 * @return the element if it is in the list or null, otherwise.
	 */
	public T search(T element);

	/**
	 * Inserts a new element at the end of the list. Null elements are not allowed
	 * (the list remains unchanged).
	 * 
	 * @param element
	 *            the element to be inserted.
	 */
	public void insert(T element);

	/**
	 * Removes an element from the list. If the element is not contained in the
	 * list, the list must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 */
	public void remove(T element);

	/**
	 * Returns an array containing all the elements in the structure. The array does
	 * not contain empty spaces (or null elements). The elements are put into the
	 * array from the beginning to the end of the list.
	 * 
	 * @return an array containing all the elements contained in the structure in
	 *         the same order they appear.
	 */
	public T[] toArray();

}