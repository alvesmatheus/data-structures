package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import abstractStructures.Heap;

/**
 * A heap is a specialized tree-based data structure that satisfies the heap
 * property. In a max heap, a node is greater than or equal to its children. In
 * a min heap, a node is smaller than or equal to its children. The heap is one
 * maximally efficient implementation of a priority queue.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

	private T[] heap;
	private int index;
	private Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Constructs an empty BinaryHeap that works based on the given comparator. Its
	 * internal array initial size is defined by the constant INITIAL_SIZE above
	 * (originally 20).
	 * 
	 * @param comparator
	 *            The comparator used by the BinaryHeap to build its structure.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
		this.index = -1;
	}

	public Comparator<T> getComparator() {
		return this.comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Returns the index of the parent of the element stored in the given index. The
	 * index returned will be negative if the element does not have a parent.
	 * 
	 * @param index
	 *            the index of the element whose parent is being looked for.
	 * 
	 * @return the index of the parent of the element stored in the given one.
	 * 
	 */
	private int parent(int index) {
		return ((index - 1) / 2);
	}

	/**
	 * Returns the index of the left child of the element stored in the given index.
	 * The element stored in the returned index will be null if the element does not
	 * have a left child.
	 * 
	 * @param index
	 *            the index of the element whose left child is being looked for.
	 * 
	 * @return the index of the left child of the element stored in the given one.
	 * 
	 */
	private int leftChild(int index) {
		return ((index * 2) + 1);
	}

	/**
	 * Returns the index of the right child of the element stored in the given
	 * index. The element stored in the returned index will be null if the element
	 * does not have a right child.
	 * 
	 * @param index
	 *            the index of the element whose right child is being looked for.
	 * 
	 * @return the index of the right child of the element stored in the given one.
	 * 
	 */
	private int rightChild(int index) {
		return this.leftChild(index) + 1;
	}

	/**
	 * This method validates if the element stored in the first given index of the
	 * heap is greater than the one stored in the second given index.
	 * 
	 * @param i
	 *            the index of the first element.
	 * @param j
	 *            the index of the second element.
	 * 
	 * @return the boolean that indicates if the first element is greater than the
	 *         second one.
	 * 
	 */
	private boolean greaterThan(int i, int j) {
		return (this.getComparator().compare(this.heap[i], this.heap[j]) > 0);
	}

	/**
	 * Swaps the elements stored in two given indexes of the heap.
	 * 
	 * @param i
	 *            the index of the first element to be swapped.
	 * @param j
	 *            the index of the second element to be swapped.
	 * 
	 */
	private void swap(int i, int j) {
		T element = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = element;
	}

	/**
	 * This method guarantees the heap property to the heap whose root element is
	 * the one stored in the given index. Any violations (to the heap property)
	 * found will be corrected.
	 * 
	 * @param position
	 *            the index of the root element in the original internal array.
	 * 
	 */
	private void heapify(int position) {
		if (this.isValidIndex(position)) {
			int largest = position;
			int leftChild = this.leftChild(position);
			int rightChild = this.rightChild(position);

			if ((leftChild <= this.index) && this.greaterThan(leftChild, largest)) {
				largest = leftChild;
			}

			if ((rightChild <= this.index) && this.greaterThan(rightChild, largest)) {
				largest = rightChild;
			}

			if (largest != position) {
				this.swap(position, largest);
				this.heapify(largest);
			}
		}
	}

	/**
	 * This method validates a element received by the heap. The element must not be
	 * null to be validated.
	 * 
	 * @param element
	 *            The element to be validated.
	 * 
	 * @return the boolean that indicates if the element is valid.
	 * 
	 */
	private boolean isValidInput(T element) {
		return (element != null);
	}

	/**
	 * This method validates a index received by the heap. The index must not be
	 * negative neither bigger than the number of elements stored in the heap to be
	 * validated.
	 * 
	 * @param index
	 *            The index to be validated.
	 * 
	 * @return the boolean that indicates if the index is valid.
	 * 
	 */
	private boolean isValidIndex(int index) {
		return ((index >= 0) && (index < this.size()));
	}

	/**
	 * Returns true, if the heap is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the heap is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return (this.index == -1);
	}

	/**
	 * Returns the number of elements contained in the heap.
	 * 
	 * @return the size of the heap.
	 * 
	 */
	public int size() {
		return (this.index + 1);
	}

	/**
	 * Returns (without removing) the root element of the heap or null if the heap
	 * is empty. When using a min heap, the root element will be the smallest one,
	 * while in a max heap, it will be the greatest one.
	 * 
	 * @return the root element of the heap (or null if the heap is empty).
	 * 
	 */
	@Override
	public T root() {
		T root = null;

		if (!this.isEmpty()) {
			root = this.heap[0];
		}

		return root;
	}

	/**
	 * Inserts a new element in the heap. Null elements are not allowed. If the
	 * given element is null, the heap will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {
		if (this.index == (this.heap.length - 1)) {
			this.heap = Arrays.copyOf(this.heap, this.heap.length + INCREASING_FACTOR);
		}

		if (this.isValidInput(element)) {
			this.index++;
			int position = this.index;
			this.heap[position] = element;

			while ((position > 0) && this.greaterThan(position, this.parent(position))) {
				this.swap(position, parent(position));
				position = parent(position);
			}
		}
	}

	/**
	 * Removes and returns the root element of the heap. If the heap is empty, this
	 * method returns null.
	 * 
	 * @return the root element (or null, if the heap is empty).
	 * 
	 */
	@Override
	public T extract() {
		T root = this.root();

		if (this.isValidInput(root)) {
			this.swap(0, this.index);
			this.heap[this.index--] = null;
			this.heapify(0);
		}

		return root;
	}

	/**
	 * Builds the heap based on the elements of a given array. If the heap is not
	 * empty when this method is executed, the original elements are lost.
	 * 
	 * @param array
	 *            the array containing the elements to build the heap.
	 * 
	 */
	@Override
	public void build(T[] array) {
		if (array != null) {
			this.heap = array;
			this.index = array.length - 1;

			for (int i = this.index; i >= 0; i--) {
				this.heapify(i);
			}
		}

	}

	/**
	 * Returns an array containing all the elements in the heap. The array does not
	 * contain empty spaces (or null elements).
	 * 
	 * @return an array with all non-null elements of the heap.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		for (T element : this.heap) {
			if (element != null) {
				array.add(element);
			}
		}

		return (T[]) array.toArray(new Comparable[0]);
	}

	/**
	 * Sorts the elements of an array using the heap concept. The method returns a
	 * copy of the given array containing only the not null elements. After this
	 * method is executed, the internal array must be empty.
	 * 
	 * @param array
	 *            an array of T-typed elements.
	 * 
	 * @return a sorted copy of the given array.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] heapsort(T[] array) {
		T[] sortedArray = null;

		if (array != null) {
			Comparator<T> originalComparator = this.getComparator();
			this.comparator = ((o1, o2) -> o2.compareTo(o1));
			this.index = -1;

			this.build(array);

			sortedArray = (T[]) new Comparable[this.size()];
			for (int i = 0; i < sortedArray.length; i++) {
				sortedArray[i] = this.extract();
			}

			this.comparator = originalComparator;
		}

		return sortedArray;
	}

}
