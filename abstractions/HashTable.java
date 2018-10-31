package abstractions;

/**
 * A hash table is a data structure that implements an associative array
 * abstract data type, a structure that can map keys to values. A hash table
 * uses a hash function to compute an index into an array from which the desired
 * value can be found. It keeps values of type T. The table can work in two
 * modes: closed address (with chaining) and open address (with probing).
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface HashTable<T> {

	/**
	 * Returns true, if the hash table is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the table is empty.
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
	 * Returns the number of elements contained in the hash table.
	 * 
	 * @return the size of the tree.
	 * 
	 */
	public int size();

	/**
	 * Inserts a non-null object into the hash table. A hash table does not work
	 * with duplicated elements. When the insert is called and there is a collision,
	 * the "collisions" attribute is incremented.
	 * 
	 * @param element the element to be inserted.
	 * 
	 */
	public void insert(T element);

	/**
	 * Removes an element from the hash table.
	 * 
	 * @param element the element to be removed.
	 * 
	 */
	public void remove(T element);

	/**
	 * Searches for a given element in the hash table. If the table contains it, the
	 * element will be returned. Otherwise, this method must return null.
	 * 
	 * @param element the element being searched for.
	 * 
	 * @return the searched element, if it is in the table, or null, otherwise.
	 * 
	 */
	public T search(T element);

	/**
	 * Determines the index of an element in the hash table. It returns -1 if the
	 * table does not contain the element.
	 * 
	 * @param element the object which index is being looked for.
	 * 
	 * @return the index of the internal array that contains the element or -1 if
	 *         the element is not in the table.
	 * 
	 */
	public int indexOf(T element);

}