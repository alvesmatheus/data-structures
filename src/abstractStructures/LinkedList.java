package abstractStructures;

/**
 * A linked list is a linear collection of data elements, whose order is not
 * given by their physical placement in memory. Instead, each element points to
 * the next one. It is a data structure consisting of a collection of nodes
 * which together represent a sequence.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface LinkedList<T> {

	/**
	 * Returns true, if the list is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the list is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements contained in the list.
	 * 
	 * @return the size of the list.
	 * 
	 */
	public int size();

	/**
	 * Inserts a new element at the end of the list. Null elements are not allowed.
	 * If the given element is null, the list will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	public void insert(T element);

	/**
	 * Removes an element from the list. If the list does not contain the element,
	 * the list must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	public void remove(T element);

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
	public T search(T element);

	/**
	 * Returns an array containing all the elements in the list. The array does not
	 * contain empty spaces (or null elements). The elements are put into the array
	 * from the beginning to the end of the list.
	 * 
	 * @return an array containing all the elements contained in the list in the
	 *         same order they appear.
	 *         
	 */
	public T[] toArray();

}