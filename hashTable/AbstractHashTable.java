package hashTable;

import abstractions.HashTable;

/**
 * It represents an abstract implementation of a hashtable. An AbstractHashtable
 * is only a resource for unifying both kinds of hashtables (closed and open
 * addressing). The real hashtables must inherit this class.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public abstract class AbstractHashTable<T> implements HashTable<T> {

	protected int elements;
	protected int collisions;
	protected Object[] table;

	/**
	 * Constructs a new AbstractHashTable. It will start with no elements or
	 * collisions.
	 * 
	 */
	public AbstractHashTable() {
		this.elements = 0;
		this.collisions = 0;
	}

	public int getElements() {
		return this.elements;
	}

	public int getCollisions() {
		return this.collisions;
	}

	public Object[] getTable() {
		return this.table;
	}

	/**
	 * Returns true, if the hash table is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the table is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.getElements() == 0);
	}

	/**
	 * It returns the length of the internal array of the hash table.
	 * 
	 * @return the length of the internal array of the hash table.
	 * 
	 */
	@Override
	public int capacity() {
		return this.getTable().length;
	}

	/**
	 * Returns how many objects have been inserted into the hash table until the
	 * moment.
	 * 
	 * @return the number of elements contained in the table.
	 * 
	 */
	@Override
	public int size() {
		return this.getElements();
	}

}
