package hashFunction;

import abstractStructures.HashFunction;

/**
 * A hash function is a function that can be used to map data of arbitrary size
 * to data of a fixed size. The values returned by a hash function are called
 * hash values, hash codes or simply hashes. Hash functions are often used in
 * combination with a hash table. This hash function method uses modular
 * operations to reduce the number of collisions between the generated hashes.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class HashFunctionDivisionMethod<T> implements HashFunction<T> {

	private int tableSize;

	/**
	 * Constructs a new HashFunctionDivisionMethod based on the size of the hash
	 * table that will contain it.
	 * 
	 * @param tableSize
	 *            the size of the table that will contain the hash function.
	 * 
	 */
	public HashFunctionDivisionMethod(int tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 * The hash function might use the table size to calculate the hash of any
	 * object of type T. The key is obtained from hashCode method of type T
	 * (inherited from Object or overridden).
	 * 
	 * Based on the properties of the hash table containing this hash function,
	 * calculates a hash for the given element.
	 * 
	 * @param element
	 *            the object whose hash must be calculated.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	@Override
	public int hash(T element) {
		int hashKey = -1;
		int key = element.hashCode();

		hashKey = (int) key % tableSize;

		return hashKey;
	}

}
