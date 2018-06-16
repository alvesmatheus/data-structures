package abstractStructures;

/**
 * It represents a generic hash function that will be used by a hash table to
 * calculate indexes of its internal array.
 * 
 */
public interface HashFunction<T> {

	/**
	 * Based on the properties of the hash table containing this hash function,
	 * calculates a hash for the given element.
	 * 
	 * @param element
	 *            the object which hash must be calculated.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	public int hash(T element);

}
