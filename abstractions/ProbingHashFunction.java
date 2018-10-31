package abstractions;

/**
 * A hash function is a function that can be used to map data of arbitrary size
 * to data of a fixed size. The values returned by a hash function are called
 * hash values, hash codes or simply hashes. Hash functions are often used in
 * combination with a hash table.
 * 
 * A probing hash function is used by a open address hash table to calculate
 * indexes of its internal array.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface ProbingHashFunction<T> {

	/**
	 * Based on the properties of the open address hash table containing this hash
	 * function, calculates a hash for the given element.
	 * 
	 * @param element the object whose hash must be calculated.
	 * @param probe   the current probe value.
	 * 
	 * @return the hash of the given object.
	 * 
	 */
	public int hash(T element, int probe);

}
