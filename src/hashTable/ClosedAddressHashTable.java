package hashTable;

import java.util.LinkedList;

import abstractStructures.HashFunction;
import hashFunction.ClosedAddressMethod;
import hashFunction.HashFunctionDivisionMethod;
import hashFunction.HashFunctionMultiplicationMethod;

/**
 * A hash table is a data structure that implements an associative array
 * abstract data type, a structure that can map keys to values. A hash table
 * uses a hash function to compute an index into an array from which the desired
 * value can be found.
 * 
 * A closed address hash table works using a hash function with closed address.
 * Such a function can follow methods like DIVISION and MULTIPLICATION. In the
 * DIVISION method, it is useful to change the size of the table to an integer
 * that is prime. This can be achieved by producing such a prime number that is
 * bigger and close to the desired size.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class ClosedAddressHashTable<T> extends AbstractHashTable<T> {

	/**
	 * Constructs a new ClosedAddressHashTable based on a desired size of its
	 * internal array and on the hashing method that must be used by the table.
	 * 
	 * @param desiredSize
	 *            The desired size for the hash table.
	 * @param method
	 *            The hashing method that must be used by the hash table.
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public ClosedAddressHashTable(int desiredSize, ClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == ClosedAddressMethod.DIVISION) {
			realSize = Util.getPrimeAbove(desiredSize);
		}

		this.hashFunction = this.createHashFunction(method, realSize);
		this.table = new LinkedList[realSize];
	}

	/**
	 * Based on the internal array length and on the desired method of hashing, this
	 * method creates the appropriate type of HashFunction and returns it.
	 * 
	 * @param method
	 *            The method that must be used by the hash function.
	 * @param tableSize
	 *            The hash table's internal array length.
	 * 
	 * @return an appropriate hash function to the hash table.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private HashFunction createHashFunction(ClosedAddressMethod method, int tableSize) {
		HashFunction function = null;

		switch (method) {
		case DIVISION:
			function = new HashFunctionDivisionMethod(tableSize);
			break;

		case MULTIPLICATION:
			function = new HashFunctionMultiplicationMethod(tableSize);
			break;
		}

		return function;
	}

	/**
	 * This method validates a element received by the hash table. The element must
	 * not be null to the hash table operations work properly.
	 * 
	 * @param element
	 *            The element that must be used in a hash table operation.
	 * 
	 * @return the boolean that represents the element validity.
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
	 * @param element
	 *            the object that must be inserted into the hash table.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {
		if ((this.isValidInput(element)) && (this.search(element) == null)) {

			int hash = this.getHashFunction().hash(element);

			if (this.table[hash] == null) {
				this.table[hash] = new LinkedList<T>();
			}

			else if (!(((LinkedList<T>) this.table[hash]).isEmpty())) {
				this.collisions++;
			}

			((LinkedList<T>) this.table[hash]).add(element);
			this.elements++;
		}
	}

	/**
	 * Removes an element from the hash table.
	 * 
	 * @param element
	 *            the object that must be removed from the hash table.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void remove(T element) {
		if (this.isValidInput(element)) {

			int hash = this.getHashFunction().hash(element);

			if (this.table[hash] != null) {

				if (((LinkedList<T>) this.table[hash]).remove(element)) {
					this.elements--;

					if (!(((LinkedList<T>) this.table[hash]).isEmpty())) {
						this.collisions--;
					}
				}
			}
		}
	}

	/**
	 * Searches for a given element in the hash table. If the table contains it, the
	 * element will be returned. Otherwise, this method must return a null.
	 * 
	 * @param element
	 *            the object that must be searched.
	 * 
	 * @return the searched element, if the table contains it. Null, otherwise.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T target = null;

		if (this.isValidInput(element)) {

			int hash = this.getHashFunction().hash(element);

			if (this.table[hash] != null) {
				int indexAtList = ((LinkedList<T>) this.table[hash]).indexOf(element);

				if (indexAtList != -1) {
					target = ((LinkedList<T>) this.table[hash]).get(indexAtList);
				}
			}
		}

		return target;
	}

	/**
	 * Determines the index of an element in the hash table. It returns -1 if the
	 * table does not contain the element.
	 * 
	 * @param element
	 *            the object which index is being looked for.
	 * 
	 * @return the index of the internal array that contains the element or -1 if
	 *         the element is not in the table.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T element) {
		int index = -1;

		if (this.isValidInput(element)) {

			int hash = this.getHashFunction().hash(element);

			if (this.table[hash] != null) {
				if (((LinkedList<T>) this.table[hash]).contains(element)) {
					index = hash;
				}
			}
		}

		return index;
	}

}