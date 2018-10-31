package hashTable;

/**
 * A "Deleted" object is used in an open address hash table as a flag to
 * indicates when a position of its internal array became empty again and now
 * can be used to store new elements.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class Deleted {

	/**
	 * Constructs a new Deleted. This type of Object has no attributes.
	 * 
	 */
	public Deleted() {
	}

	/**
	 * Compares the Deleted executing this method with the Object given as parameter
	 * to determine if they are equals. To be equals, the given Object must be a
	 * Deleted too.
	 * 
	 * @return The boolean that indicates the equality between the Deleted and the
	 *         object.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		boolean answer = false;

		if (object != null) {
			answer = (object instanceof Deleted);
		}

		return answer;
	}

	/**
	 * Returns a textual representation to the the Deleted using this method. The
	 * returned String is always "DELETED".
	 * 
	 * @return The Deleted textual representation.
	 * 
	 */
	@Override
	public String toString() {
		return "DELETED";
	}

}
