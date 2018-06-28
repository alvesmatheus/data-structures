package abstractStructures;

/**
 * A hash function is a function that can be used to map data of arbitrary size
 * to data of a fixed size. The values returned by a hash function are called
 * hash values, hash codes or simply hashes. Hash functions are often used in
 * combination with a hash table.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface HashFunction<T> {

	/**
	 * Based on the properties of the hash table containing this hash function,
	 * calculates a hash for the given element.
	 * 
	 * @param element
	 *            the object whose hash must be calculated.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	public int hash(T element);

}
