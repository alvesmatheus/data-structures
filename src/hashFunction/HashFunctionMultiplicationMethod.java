package hashFunction;

import abstractStructures.HashFunction;

/**
 * A hash function is a function that can be used to map data of arbitrary size
 * to data of a fixed size. The values returned by a hash function are called
 * hash values, hash codes or simply hashes. Hash functions are often used in
 * combination with a hash table. This hash function method uses a factor A and
 * some multiplications to reduce the number of collisions between the generated
 * hashes.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class HashFunctionMultiplicationMethod<T> implements HashFunction<T> {

	protected int tableSize;
	private static final double A = (Math.sqrt(5) - 1) / 2;

	/**
	 * Constructs a new HashFunctionMultiplicationMethod based on the size of the
	 * hash table that will contain it.
	 * 
	 * @param tableSize
	 *            the size of the table that will contain the hash function.
	 * 
	 */
	public HashFunctionMultiplicationMethod(int tableSize) {
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
	 *            the object which hash must be calculated.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	@Override
	public int hash(T element) {
		int hash = -1;
		int key = element.hashCode();

		double fractionalPart = key * A - Math.floor(key * A);
		hash = (int) (tableSize * fractionalPart);

		return hash;
	}

}
