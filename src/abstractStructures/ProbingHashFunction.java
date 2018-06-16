package abstractStructures;

/**
 * It represents a generic hash function that uses probing and will be used by a
 * open address hash table to calculate indexes of its internal array.
 * 
 */
public interface ProbingHashFunction<T> {

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
	public int hash(T element, int probe);

}
