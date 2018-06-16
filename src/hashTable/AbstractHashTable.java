package hashTable;

import abstractStructures.HashFunction;
import abstractStructures.HashTable;

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
	protected HashFunction<T> hashFunction;

	/**
	 * Constructs a new AbstractHashTable. It will start with no elements or
	 * collisions.
	 * 
	 */
	public AbstractHashTable() {
		elements = 0;
		collisions = 0;
	}

	public int getCollisions() {
		return this.collisions;
	}

	public HashFunction<T> getHashFunction() {
		return this.hashFunction;
	}

	public void setHashFunction(HashFunction<T> hashFunction) {
		this.hashFunction = hashFunction;
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
		return this.elements;
	}

	/**
	 * It returns the length of the internal array of the hash table.
	 * 
	 * @return the length of the internal array of the hash table.
	 * 
	 */
	@Override
	public int capacity() {
		return this.table.length;
	}

	/**
	 * Determines whether the hash table is empty or not.
	 * 
	 * @return true if the table is empty. False, otherwise.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.elements == 0);
	}

}
