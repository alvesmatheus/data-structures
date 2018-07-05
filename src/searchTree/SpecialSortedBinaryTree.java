package searchTree;

import binaryTree.BinaryTreeNode;

/**
 * A binary search tree, sometimes called ordered or sorted binary tree, is a
 * particular type of container based on a binary tree. It allows fast lookup,
 * addition and removal of elements. Binary search trees keep their elements in
 * sorted order, so its operations can use the principle of binary search. Each
 * node of the tree contains a comparable T-typed element.
 * 
 * This variation of a binary search tree contains some extra methods, allowing
 * unexpected features. It was created as a way to improve the knowledge about
 * binary search trees.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SpecialSortedBinaryTree<T extends Comparable<T>> extends SortedBinaryTree<T> {

	/**
	 * Creates a sorted version of a given array. The SpecialSortedBinaryTree will
	 * be emptied and its operations will be used during the sorting process.
	 * 
	 * @param array
	 *            The target array of the sorting process.
	 * 
	 * @return a sorted version of the given array.
	 * 
	 */
	public T[] sort(T[] array) {
		T[] sorted = null;

		if (array != null) {
			super.setRoot(new BinaryTreeNode<T>());
			for (int i = 0; i < array.length; i++) {
				super.insert(array[i]);
			}

			sorted = super.order();
		}

		return sorted;
	}

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree reverse order.
	 * 
	 * @return a reverse ordered array containing the binary tree elements.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T[] reverseOrder() {
		int index = 0;
		T[] reverseOrdered = (T[]) new Comparable[super.size()];
		this.reverseOrder(reverseOrdered, super.getRoot(), index);

		return reverseOrdered;
	}

	// RECURSIVE AUXILIAR METHOD TO: reverseOrder().
	private int reverseOrder(T[] array, BinaryTreeNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.reverseOrder(array, node.getRight(), index);
			array[index++] = node.getData();
			index = this.reverseOrder(array, node.getLeft(), index);
		}

		return index;
	}

}
