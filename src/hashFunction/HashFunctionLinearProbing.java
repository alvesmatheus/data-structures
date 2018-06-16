package hashFunction;

import abstractStructures.HashFunction;
import abstractStructures.ProbingHashFunction;
import exceptions.UnsupportedHashingMethodException;

/**
 * A hash function is a function that can be used to map data of arbitrary size
 * to data of a fixed size. The values returned by a hash function are called
 * hash values, hash codes or simply hashes. Hash functions are often used in
 * combination with a hash table. This hash function method calculates new
 * hashes for the element until it does not collide with another element in the
 * table.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class HashFunctionLinearProbing<T> implements ProbingHashFunction<T> {

	private HashFunction<T> basicHashFunction;
	private int tableSize;

	/**
	 * Constructs a new HashFunctionLinearProbing based on the size of the hash
	 * table that will contain it. Also, it uses the method used by the internal
	 * HashFunction on the construction.
	 * 
	 * @param tableSize
	 *            the size of the table that will contain the hash function.
	 * @param method
	 *            The hashing method that must be used by the linear probing.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public HashFunctionLinearProbing(int tableSize, ClosedAddressMethod method) {
		this.tableSize = tableSize;
		this.basicHashFunction = this.createHashFunction(tableSize, method);
	}

	/**
	 * Based on the hash table size and on the desired method of hashing, this
	 * method creates the appropriate type of HashFunction and returns it.
	 * 
	 * @param method
	 *            The method that must be used by the hash function.
	 * @param tableSize
	 *            The hash table's internal array length.
	 * 
	 * @return an appropriate hash function to the probing hash function.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private HashFunction createHashFunction(int tableSize, ClosedAddressMethod method) {
		HashFunction function = null;

		switch (method) {
		case DIVISION:
			function = new HashFunctionDivisionMethod(tableSize);
			break;

		case MULTIPLICATION:
			function = new HashFunctionMultiplicationMethod(tableSize);
			break;

		default:
			throw new UnsupportedHashingMethodException();
		}

		return function;
	}

	/**
	 * Based on the properties of the open address hash table containing this hash
	 * function, calculates a hash for the given element.
	 * 
	 * @param element
	 *            the object which hash must be calculated.
	 * @param probe
	 *            the actual probe value.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	@Override
	public int hash(T element, int probe) {
		int hashKey = -1;

		hashKey = (this.basicHashFunction.hash(element) + probe) % this.tableSize;

		return hashKey;
	}

}
