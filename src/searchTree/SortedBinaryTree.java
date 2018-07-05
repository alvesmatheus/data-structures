package searchTree;

import abstractStructures.BinarySearchTree;
import binaryTree.BinaryTreeNode;

/**
 * A binary search tree, sometimes called ordered or sorted binary tree, is a
 * particular type of container based on a binary tree. It allows fast lookup,
 * addition and removal of elements. Binary search trees keep their elements in
 * sorted order, so its operations can use the principle of binary search. Each
 * node of the tree contains a comparable T-typed element.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SortedBinaryTree<T extends Comparable<T>> implements BinarySearchTree<T> {

	protected BinaryTreeNode<T> root;

	/**
	 * Constructs an empty SortedBinaryTree whose root will be a NIL BinaryTreeNode.
	 * 
	 */
	public SortedBinaryTree() {
		this.root = new BinaryTreeNode<T>();
	}

	protected BinaryTreeNode<T> getRoot() {
		return root;
	}

	protected void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Returns the data contained in the root node of the SortedBinaryTree.
	 * 
	 * @return the element contained in the root node.
	 * 
	 */
	public T getRootElement() {
		return this.getRoot().getData();
	}

	/**
	 * This method validates a element received by the tree. The element must not be
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
	 * Returns true, if the binary tree is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the tree is empty.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return this.getRoot().isEmpty();
	}

	/**
	 * Returns the number of elements contained in the binary tree.
	 * 
	 * @return the size of the tree.
	 * 
	 */
	@Override
	public int size() {
		return this.size(this.getRoot());
	}

	// RECURSIVE AUXILIAR METHOD TO: size().
	private int size(BinaryTreeNode<T> node) {
		int size = 0;

		if (!node.isEmpty()) {
			size = 1 + size(node.getLeft()) + size(node.getRight());
		}

		return size;
	}

	/**
	 * As an empty binary tree has no root element, its height is -1. For a
	 * non-empty binary tree, the height is given by (1 + (the greatest height of
	 * its sub-trees)).
	 * 
	 * @return the binary tree height.
	 * 
	 */
	@Override
	public int height() {
		return this.height(this.getRoot(), -1);
	}

	// RECURSIVE AUXILIAR METHOD TO: height().
	private int height(BinaryTreeNode<T> node, int currentHeight) {
		if (!node.isEmpty()) {
			int leftHeight = this.height(node.getLeft(), currentHeight + 1);
			int rightHeight = this.height(node.getRight(), currentHeight + 1);

			currentHeight = Math.max(leftHeight, rightHeight);
		}

		return currentHeight;
	}

	/**
	 * Inserts a new element at the binary tree. Null elements are not allowed. If
	 * the given element is null, the tree will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {
		if (this.isValidInput(element)) {
			this.insert(element, this.getRoot());
		}
	}

	// RECURSIVE AUXILIAR METHOD TO: insert(T element).
	private void insert(T element, BinaryTreeNode<T> currentNode) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setLeft(new BinaryTreeNode<T>());
			currentNode.setRight(new BinaryTreeNode<T>());

			currentNode.getLeft().setParent(currentNode);
			currentNode.getRight().setParent(currentNode);
		}

		else {
			if (element.compareTo(currentNode.getData()) < 0) {
				this.insert(element, currentNode.getLeft());
			}

			else {
				this.insert(element, currentNode.getRight());
			}
		}
	}

	/**
	 * Removes an element from the binary tree. If the tree does not contain the
	 * element, the tree must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (this.isValidInput(element)) {
			BinaryTreeNode<T> targetNode = search(element, this.root);

			if (!targetNode.isEmpty()) {
				this.remove(targetNode);
			}
		}
	}

	// RECURSIVE AUXILIAR METHOD TO: remove(T element).
	private void remove(BinaryTreeNode<T> node) {
		if (node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		}

		else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
			if (node.equals(this.getRoot())) {
				if (!node.getRight().isEmpty()) {
					this.root = node.getRight();
				} else {
					this.root = node.getLeft();
				}
			}

			else {
				if (node.equals(node.getParent().getLeft())) {
					if (node.getRight().isEmpty()) {
						node.getParent().setLeft(node.getLeft());
						node.getLeft().setParent(node.getParent());
					} else {
						node.getParent().setLeft(node.getRight());
						node.getRight().setParent(node.getParent());
					}

				} else {
					if (node.getRight().isEmpty()) {
						node.getParent().setRight(node.getLeft());
						node.getLeft().setParent(node.getParent());
					} else {
						node.getParent().setRight(node.getRight());
						node.getRight().setParent(node.getParent());
					}
				}
			}
		}

		else {
			T successor = this.successor(node.getData());
			remove(successor);

			node.setData(successor);
		}
	}

	/**
	 * Searches for a given element in the tree. It will return the element if the
	 * tree contains it. Otherwise, it will return null.
	 * 
	 * @param element
	 *            the element being searched for.
	 * 
	 * @return the searched element, if it is in the tree, or null, otherwise.
	 * 
	 */
	@Override
	public T search(T element) {
		BinaryTreeNode<T> targetNode = new BinaryTreeNode<T>();

		if (this.isValidInput(element)) {
			targetNode = this.search(element, this.getRoot());
		}

		return targetNode.getData();
	}

	// RECURSIVE AUXILIAR METHOD TO: search(T element).
	private BinaryTreeNode<T> search(T element, BinaryTreeNode<T> currentNode) {
		BinaryTreeNode<T> targetNode;

		if (currentNode.isEmpty()) {
			targetNode = new BinaryTreeNode<T>();
		}

		else if (element.compareTo(currentNode.getData()) < 0) {
			targetNode = search(element, currentNode.getLeft());
		}

		else if (element.compareTo(currentNode.getData()) > 0) {
			targetNode = search(element, currentNode.getRight());
		}

		else {
			targetNode = currentNode;
		}

		return targetNode;
	}

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree order.
	 * 
	 * @return a ordered array containing the binary tree elements.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		int index = 0;
		T[] ordered = (T[]) new Comparable[this.size()];
		this.order(ordered, this.getRoot(), index);

		return ordered;
	}

	// RECURSIVE AUXILIAR METHOD TO: order().
	private int order(T[] array, BinaryTreeNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.order(array, node.getLeft(), index);
			array[index++] = node.getData();
			index = this.order(array, node.getRight(), index);
		}

		return index;
	}

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree pre-order.
	 * 
	 * @return a pre-ordered array containing the binary tree elements.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		int index = 0;
		T[] preOrdered = (T[]) new Comparable[this.size()];
		this.preOrder(preOrdered, this.getRoot(), index);

		return preOrdered;
	}

	// RECURSIVE AUXILIAR METHOD TO: preOrder().
	private int preOrder(T[] array, BinaryTreeNode<T> node, int index) {
		if (!node.isEmpty()) {
			array[index++] = node.getData();
			index = this.preOrder(array, node.getLeft(), index);
			index = this.preOrder(array, node.getRight(), index);
		}

		return index;
	}

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree post-order.
	 * 
	 * @return a post-ordered array containing the binary tree elements.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		int index = 0;
		T[] postOrdered = (T[]) new Comparable[this.size()];
		this.postOrder(postOrdered, this.getRoot(), index);

		return postOrdered;
	}

	// RECURSIVE AUXILIAR METHOD TO: postOrder().
	private int postOrder(T[] array, BinaryTreeNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.postOrder(array, node.getLeft(), index);
			index = this.postOrder(array, node.getRight(), index);
			array[index++] = node.getData();
		}

		return index;
	}

	/**
	 * Returns the node containing the smallest element in the binary search tree.
	 * If the tree is empty, it returns null.
	 * 
	 * @return the smallest element in the tree.
	 * 
	 */
	@Override
	public T minimum() {
		BinaryTreeNode<T> minimumNode = null;

		if (!this.isEmpty()) {
			minimumNode = this.minimum(this.getRoot());
		}

		return minimumNode.getData();
	}

	// RECURSIVE AUXILIAR METHOD TO: minimum().
	protected BinaryTreeNode<T> minimum(BinaryTreeNode<T> currentNode) {
		BinaryTreeNode<T> minimumElement;

		if (!currentNode.getLeft().isEmpty()) {
			minimumElement = minimum(currentNode.getLeft());
		} else {
			minimumElement = currentNode;
		}

		return minimumElement;
	}

	/**
	 * Returns the node containing the greatest element in the binary search tree.
	 * If the tree is empty, it returns null.
	 * 
	 * @return the greatest element in the tree.
	 * 
	 */
	@Override
	public T maximum() {
		BinaryTreeNode<T> maximumNode = null;

		if (!this.isEmpty()) {
			maximumNode = this.maximum(this.getRoot());
		}

		return maximumNode.getData();
	}

	// RECURSIVE AUXILIAR METHOD TO: maximum().
	private BinaryTreeNode<T> maximum(BinaryTreeNode<T> currentNode) {
		BinaryTreeNode<T> maximumNode;

		if (!currentNode.getRight().isEmpty()) {
			maximumNode = maximum(currentNode.getRight());
		} else {
			maximumNode = currentNode;
		}

		return maximumNode;
	}

	/**
	 * Returns the element that is immediately smaller than the given element. If
	 * the given element is not in the tree or if it has no predecessor in the tree,
	 * this method returns null.
	 * 
	 * @param element
	 *            the element whose predecessor is being looked for.
	 * 
	 * @return the predecessor of the given element.
	 * 
	 */
	@Override
	public T predecessor(T element) {
		BinaryTreeNode<T> targetNode = this.search(element, this.getRoot());
		BinaryTreeNode<T> predecessorNode = new BinaryTreeNode<T>();

		if (this.isValidInput(element) && (!targetNode.isEmpty())) {

			if (!targetNode.getLeft().isEmpty()) {
				predecessorNode = this.maximum(targetNode.getLeft());
			}

			else {
				BinaryTreeNode<T> ancestralNode = targetNode.getParent();

				while ((ancestralNode.getData().compareTo(targetNode.getData()) > 0) && (ancestralNode != null)) {
					ancestralNode = ancestralNode.getParent();
				}

				predecessorNode = ancestralNode;
			}
		}

		return predecessorNode.getData();
	}

	/**
	 * Returns the element that is immediately greater than the given element. If
	 * the given element is not in the tree or if it has no successor in the tree,
	 * this method returns null.
	 * 
	 * @param element
	 *            the element whose successor is being looked for.
	 * 
	 * @return the successor of the given element.
	 * 
	 */
	@Override
	public T successor(T element) {
		BinaryTreeNode<T> targetNode = this.search(element, this.getRoot());
		BinaryTreeNode<T> successorNode = new BinaryTreeNode<T>();

		if (this.isValidInput(element) && (!targetNode.isEmpty())) {

			if (!targetNode.getRight().isEmpty()) {
				successorNode = this.minimum(targetNode.getRight());
			}

			else {
				BinaryTreeNode<T> ancestralNode = targetNode.getParent();

				while ((ancestralNode.getData().compareTo(targetNode.getData()) < 0) && (ancestralNode != null)) {
					ancestralNode = ancestralNode.getParent();
				}

				successorNode = ancestralNode;
			}
		}

		return successorNode.getData();
	}

}
