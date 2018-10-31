package hashTable;

import abstractions.ProbingHashFunction;
import exceptions.HashTableOverflowException;
import exceptions.UnsupportedProbingMethodException;
import hashFunction.OpenAddressMethod;
import hashFunction.ClosedAddressMethod;

import hashFunction.HashFunctionLinearProbing;
import hashFunction.HashFunctionQuadraticProbing;

/**
 * A hash table is a data structure that implements an associative array
 * abstract data type, a structure that can map keys to values. A hash table
 * uses a hash function to compute an index into an array from which the desired
 * value can be found.
 * 
 * A open address hash table works using a hash function with open address. Such
 * a function can use probing methods like LINEAR and QUADRATIC.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class OpenAddressHashTable<T> extends AbstractHashTable<T> {

	private ProbingHashFunction<T> hashFunction;
	private final Deleted deletedElement;

	/**
	 * Constructs a new OpenAddressHashTable based on the size of its internal
	 * array, on the probing method used and on the hashing method that must be used
	 * by the table.
	 * 
	 * @param tableSize     The hash table's internal array length.
	 * @param probingMethod The probing method that must be used by the hash
	 *                      function.
	 * @param method        The hashing method that must be used by the hash
	 *                      function.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public OpenAddressHashTable(int tableSize, OpenAddressMethod probingMethod, ClosedAddressMethod method) {
		this.hashFunction = this.createHashFunction(tableSize, probingMethod, method);
		this.deletedElement = new Deleted();
		this.table = new Object[tableSize];
	}

	/**
	 * Based on the internal array length and on the desired methods of hashing,
	 * this method creates the appropriate type of ProbingHashFunction and returns
	 * it.
	 * 
	 * @param tableSize     The hash table's internal array length.
	 * @param probingMethod The probing method that must be used by the hash
	 *                      function.
	 * @param method        The hashing method that must be used by the hash
	 *                      function.
	 * 
	 * @return an appropriate hash function to the hash table.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private ProbingHashFunction createHashFunction(int tableSize, OpenAddressMethod probingMethod,
			ClosedAddressMethod method) {
		ProbingHashFunction function = null;

		switch (probingMethod) {
		case LINEAR_PROBING:
			function = new HashFunctionLinearProbing(tableSize, method);
			break;

		case QUADRATIC_PROBING:
			function = new HashFunctionQuadraticProbing(tableSize, method);
			break;

		default:
			throw new UnsupportedProbingMethodException();
		}

		return function;
	}

	public ProbingHashFunction<T> getHashFunction() {
		return this.hashFunction;
	}

	protected void setHashFunction(ProbingHashFunction<T> hashFunction) {
		this.hashFunction = hashFunction;
	}

	/**
	 * This method validates a element received by the hash table. The element must
	 * not be null to be validated.
	 * 
	 * @param element The element to be validated.
	 * 
	 * @return the boolean that indicates if the element is valid.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * Inserts a non-null object into the hash table. A hash table does not work
	 * with duplicated elements. When the insert is called and there is a collision,
	 * the "collisions" attribute is incremented.
	 * 
	 * @param element the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {

		if (this.isFull()) {
			throw new HashTableOverflowException();
		}

		if (this.isValidInput(element)) {
			int probe = 0;
			int hash = -1;

			while (probe < this.capacity()) {
				hash = this.hashFunction.hash(element, probe);

				if ((this.table[hash] == null) || (table[hash].equals(this.deletedElement))) {
					this.table[hash] = element;
					this.elements++;
					break;
				}

				else {
					if (this.table[hash].equals(element)) {
						this.table[hash] = element;
					}

					else {
						this.collisions++;
						probe++;
					}
				}
			}
		}

	}

	/**
	 * Removes an element from the hash table.
	 * 
	 * @param element the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (this.isValidInput(element)) {
			int index = this.indexOf(element);

			if (index != -1) {
				this.table[index] = this.deletedElement;
				this.elements--;
			}
		}
	}

	/**
	 * Searches for a given element in the hash table. If the table contains it, the
	 * element will be returned. Otherwise, this method must return null.
	 * 
	 * @param element the element being searched for.
	 * 
	 * @return the searched element, if it is in the table, or null, otherwise.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T target = null;

		if (this.isValidInput(element)) {
			int probe = 0;
			int hash = this.getHashFunction().hash(element, probe);

			while (probe < this.capacity()) {
				if ((this.table[hash] != null) || (!this.deletedElement.equals(this.table[hash]))) {
					break;
				}

				if (table[hash].equals(element)) {
					target = (T) table[hash];
					break;
				}

				else {
					probe++;
					hash = getHashFunction().hash(element, probe);
				}
			}
		}

		return target;
	}

	/**
	 * Determines the index of an element in the hash table. It returns -1 if the
	 * table does not contain the element.
	 * 
	 * @param element the object which index is being looked for.
	 * 
	 * @return the index of the internal array that contains the element or -1 if
	 *         the element is not in the table.
	 * 
	 */
	@Override
	public int indexOf(T element) {
		int index = -1;

		if (this.isValidInput(element)) {
			int probe = 0;
			int hash = this.getHashFunction().hash(element, probe);

			while (probe < this.capacity()) {
				if ((this.table[hash] != null) || (!this.deletedElement.equals(this.table[hash]))) {
					break;
				}

				if (table[hash].equals(element)) {
					index = hash;
					break;
				}

				else {
					probe++;
					hash = this.getHashFunction().hash(element, probe);
				}
			}
		}

		return index;
	}

	/**
	 * Returns true, if the hash table is full, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the hash table is full.
	 * 
	 */
	public boolean isFull() {
		return (this.elements == this.table.length);
	}

}
