package abstractStructures;

/**
 * The interface of a generic hash table. It keeps values of type T. The table
 * can work in two modes: closed address (with chaining) and open address (with
 * probing).
 * 
 */
public interface HashTable<T> {

	/**
	 * Determines whether the hash table is empty or not.
	 * 
	 * @return true if the table is empty. False, otherwise.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * It returns the length of the internal array of the hash table.
	 * 
	 * @return the length of the internal array of the hash table.
	 * 
	 */
	public int capacity();

	/**
	 * Returns how many objects have been inserted into the hash table until the
	 * moment.
	 * 
	 * @return the number of elements contained in the table.
	 * 
	 */
	public int size();

	/**
	 * Inserts a non-null object into the hash table. A hash table does not work
	 * with duplicated elements. When the insert is called and there is a collision,
	 * the "collisions" attribute is incremented.
	 * 
	 * @param element
	 *            the object that must be inserted into the hash table.
	 * 
	 */
	public void insert(T element);

	/**
	 * Removes an element from the hash table.
	 * 
	 * @param element
	 *            the object that must be removed from the hash table.
	 * 
	 */
	public void remove(T element);

	/**
	 * Searches for a given element in the hash table. If the table contains it, the
	 * element will be returned. Otherwise, this method must return a null.
	 * 
	 * @param element
	 *            the object that must be searched.
	 * 
	 * @return the searched element, if the table contains it. Null, otherwise.
	 * 
	 */
	public T search(T element);

	/**
	 * Determines the index of an element in the hash table. It returns -1 if the
	 * table does not contain the element.
	 * 
	 * @param element
	 *            the object which index is being looked for.
	 * 
	 * @return the index of the internal array that contains the element or -1 if
	 *         the element is not in the table.
	 * 
	 */
	public int indexOf(T element);

}