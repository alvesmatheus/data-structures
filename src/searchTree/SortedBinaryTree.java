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
		return this.root;
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
	protected boolean isValidInput(T element) {
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
	private int size(BinaryTreeNode<T> currentNode) {
		int size = 0;

		if (!currentNode.isEmpty()) {
			size = 1 + this.size(currentNode.getLeft()) + this.size(currentNode.getRight());
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
		return this.height(this.getRoot());
	}

	// RECURSIVE AUXILIAR METHOD TO: height().
	protected int height(BinaryTreeNode<T> currentNode) {
		int height = -1;

		if (!currentNode.isEmpty()) {
			int leftHeight = this.height(currentNode.getLeft());
			int rightHeight = this.height(currentNode.getRight());

			height = Math.max(leftHeight, rightHeight) + 1;
		}

		return height;
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
		this.insert(element, this.getRoot());
	}

	// RECURSIVE AUXILIAR METHOD TO: insert(T element).
	private void insert(T element, BinaryTreeNode<T> currentNode) {
		if (this.isValidInput(element)) {
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
				} else {
					this.insert(element, currentNode.getRight());
				}
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
			BinaryTreeNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				this.remove(node);
			}
		}
	}

	// RECURSIVE AUXILIAR METHOD TO: remove(T element).
	private void remove(BinaryTreeNode<T> currentNode) {
		if (currentNode.isLeaf()) {
			currentNode.setData(null);
			currentNode.setLeft(null);
			currentNode.setRight(null);
		}

		else if (currentNode.getLeft().isEmpty() || currentNode.getRight().isEmpty()) {
			if (currentNode.equals(this.getRoot())) {
				if (currentNode.getLeft().isEmpty()) {
					this.setRoot(currentNode.getRight());
				} else {
					this.setRoot(currentNode.getLeft());
				}
			}

			else {
				if (currentNode.equals(currentNode.getParent().getLeft())) {
					if (currentNode.getLeft().isEmpty()) {
						currentNode.getParent().setLeft(currentNode.getRight());
						currentNode.getRight().setParent(currentNode.getParent());
					} else {
						currentNode.getParent().setLeft(currentNode.getLeft());
						currentNode.getLeft().setParent(currentNode.getParent());
					}
				} else {
					if (currentNode.getLeft().isEmpty()) {
						currentNode.getParent().setRight(currentNode.getRight());
						currentNode.getRight().setParent(currentNode.getParent());
					} else {
						currentNode.getParent().setRight(currentNode.getLeft());
						currentNode.getLeft().setParent(currentNode.getParent());
					}
				}
			}
		}

		else {
			BinaryTreeNode<T> sucessor = this.successor(currentNode.getData());
			T sucessorData = sucessor.getData();
			this.remove(sucessor);

			currentNode.setData(sucessorData);
		}
	}

	/**
	 * Searches for a given element in the tree. It will return the element if the
	 * tree contains it. Otherwise, it will return a NIL node.
	 * 
	 * @param element
	 *            the element being searched for.
	 * 
	 * @return the node containing the searched element, if it is in the tree, or
	 *         NIL, otherwise.
	 * 
	 */
	@Override
	public BinaryTreeNode<T> search(T element) {
		return this.search(element, this.getRoot());
	}

	// RECURSIVE AUXILIAR METHOD TO: search(T element).
	private BinaryTreeNode<T> search(T element, BinaryTreeNode<T> currentNode) {
		BinaryTreeNode<T> target = new BinaryTreeNode<T>();

		if ((this.isValidInput(element)) && (!currentNode.isEmpty())) {
			if (element.compareTo(currentNode.getData()) < 0) {
				target = this.search(element, currentNode.getLeft());
			} else if (element.compareTo(currentNode.getData()) > 0) {
				target = this.search(element, currentNode.getRight());
			} else {
				target = currentNode;
			}
		}

		return target;
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
	private int order(T[] array, BinaryTreeNode<T> currentNode, int index) {
		if (!currentNode.isEmpty()) {
			index = this.order(array, currentNode.getLeft(), index);
			array[index++] = currentNode.getData();
			index = this.order(array, currentNode.getRight(), index);
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
	private int preOrder(T[] array, BinaryTreeNode<T> currentNode, int index) {
		if (!currentNode.isEmpty()) {
			array[index++] = currentNode.getData();
			index = this.preOrder(array, currentNode.getLeft(), index);
			index = this.preOrder(array, currentNode.getRight(), index);
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
	private int postOrder(T[] array, BinaryTreeNode<T> currentNode, int index) {
		if (!currentNode.isEmpty()) {
			index = this.postOrder(array, currentNode.getLeft(), index);
			index = this.postOrder(array, currentNode.getRight(), index);
			array[index++] = currentNode.getData();
		}

		return index;
	}

	/**
	 * Returns the node containing the smallest element in the binary search tree.
	 * If the tree is empty, it returns null.
	 * 
	 * @return the node containing the smallest element in the tree.
	 * 
	 */
	@Override
	public BinaryTreeNode<T> minimum() {
		BinaryTreeNode<T> minimum = null;

		if (!this.isEmpty()) {
			minimum = this.minimum(this.getRoot());
		}

		return minimum;
	}

	// RECURSIVE AUXILIAR METHOD TO: minimum().
	protected BinaryTreeNode<T> minimum(BinaryTreeNode<T> currentNode) {
		BinaryTreeNode<T> minimum = currentNode;

		if (!currentNode.getLeft().isEmpty()) {
			minimum = this.minimum(currentNode.getLeft());
		}

		return minimum;
	}

	/**
	 * Returns the node containing the greatest element in the binary search tree.
	 * If the tree is empty, it returns null.
	 * 
	 * @return the node containing the greatest element in the tree.
	 * 
	 */
	@Override
	public BinaryTreeNode<T> maximum() {
		BinaryTreeNode<T> maximum = null;

		if (!this.isEmpty()) {
			maximum = this.maximum(this.getRoot());
		}

		return maximum;
	}

	// RECURSIVE AUXILIAR METHOD TO: maximum().
	protected BinaryTreeNode<T> maximum(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> maximum = node;

		if (!node.getRight().isEmpty()) {
			maximum = this.maximum(node.getRight());
		}

		return maximum;
	}

	/**
	 * Returns the node containing the element that is immediately smaller than the
	 * given element. If the given element is not in the tree or if it has no
	 * predecessor in the tree, this method returns null.
	 * 
	 * @param element
	 *            the element whose predecessor is being looked for.
	 * 
	 * @return the node containing the predecessor of the given element.
	 * 
	 */
	@Override
	public BinaryTreeNode<T> predecessor(T element) {
		BinaryTreeNode<T> targetNode = this.search(element);
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

		return predecessorNode;
	}

	/**
	 * Returns the node containing the element that is immediately greater than the
	 * given element. If the given element is not in the tree or if it has no
	 * successor in the tree, this method returns null.
	 * 
	 * @param element
	 *            the element whose successor is being looked for.
	 * 
	 * @return the node containing the successor of the given element.
	 * 
	 */
	@Override
	public BinaryTreeNode<T> successor(T element) {
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

		return successorNode;
	}

}
