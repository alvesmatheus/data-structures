package balancedTree;

import binaryTree.BinaryTreeNode;
import binaryTree.Rotator;
import searchTree.SortedBinaryTree;

/**
 * A AVL tree (named after inventors Adelson-Velsky and Landis) is a self
 * balancing binary search tree. In an AVL tree, the heights of the two child
 * subtrees of any node differ by at most one. If at any time they differ by
 * more than one, the tree is rebalanced (using rotations) to restore this
 * property. Lookup, insertion, and deletion all take O(log n) time in the
 * average and worst cases. Insertions and deletions may require the tree to be
 * rebalanced. Each node of the tree contains a comparable T-typed element.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class AVLTree<T extends Comparable<T>> extends SortedBinaryTree<T> {

	/**
	 * Inserts a new element at the AVL tree. Null elements are not allowed. If
	 * the given element is null, the tree will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	public void insert(T element) {
		this.insert(element, super.getRoot(), new BinaryTreeNode<T>());
	}

	// RECURSIVE AUXILIAR METHOD TO: insert(T element).
	private void insert(T element, BinaryTreeNode<T> currentNode, BinaryTreeNode<T> nodeParent) {
		if ((super.isValidInput(element)) && (currentNode.isEmpty())) {
			currentNode.setData(element);
			currentNode.setLeft(new BinaryTreeNode<T>());
			currentNode.setRight(new BinaryTreeNode<T>());
			currentNode.setParent(nodeParent);

			currentNode.getLeft().setParent(currentNode);
			currentNode.getRight().setParent(currentNode);
		}

		else {
			if (element.compareTo(currentNode.getData()) < 0) {
				this.insert(element, currentNode.getLeft(), currentNode);
			} else {
				this.insert(element, currentNode.getRight(), currentNode);
			}
		}

		this.rebalance(currentNode);
	}

	/**
	 * Removes an element from the AVL tree. If the tree does not contain the
	 * element, the tree must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	@Override
	public void remove(T element) {
		if (super.isValidInput(element)) {
			BinaryTreeNode<T> node = super.search(element);

			if (!node.isEmpty()) {
				this.remove(node);
			}
		}
	}

	// RECURSIVE AUXILIAR METHOD TO: remove(T element).
	private void remove(BinaryTreeNode<T> currentNode) {
		if (currentNode.isLeaf()) {
			if (currentNode.equals(this.root)) {
				super.setRoot(new BinaryTreeNode<T>());
			} else {
				if (currentNode.getParent().getLeft().equals(currentNode)) {
					currentNode.getParent().setLeft(new BinaryTreeNode<T>());
				} else {
					currentNode.getParent().setRight(new BinaryTreeNode<T>());
				}
			}

			this.rebalanceUp(currentNode);
		}

		else if (currentNode.getLeft().isEmpty() || currentNode.getRight().isEmpty()) {
			if (currentNode.equals(super.getRoot())) {
				if (currentNode.getLeft().isEmpty()) {
					super.setRoot(currentNode.getRight());
				} else {
					super.setRoot(currentNode.getLeft());
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

			this.rebalanceUp(currentNode);
		}

		else {
			BinaryTreeNode<T> successor = super.successor(currentNode.getData());
			T sucessorData = successor.getData();
			this.remove(successor);

			currentNode.setData(sucessorData);
		}
	}

	/**
	 * Calculates the balance of the given node. If the result is positive, the node
	 * is weighing right. If the result is negative, the node is weighing left. If
	 * the result is 0, the node is balanced.
	 * 
	 * @param node
	 *            The node whose balance must be calculated.
	 * 
	 * @return the balance of the given node.
	 * 
	 */
	protected int calculateBalance(BinaryTreeNode<T> node) {
		return super.height(node.getLeft()) - super.height(node.getRight());
	}

	/**
	 * If the absolute value of the balance of the given node is greater than 1,
	 * this method performs the needed operations to make it balanced again.
	 * 
	 * @param node
	 *            The node that must be rebalanced.
	 * 
	 */
	protected void rebalance(BinaryTreeNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance > 1) {
			if (calculateBalance(node.getLeft()) < 0) {
				this.leftRotation(node.getLeft());
			}

			this.rightRotation(node);
		}

		else if (balance < -1) {
			if (calculateBalance(node.getRight()) > 0) {
				this.rightRotation(node.getRight());
			}

			this.leftRotation(node);
		}
	}

	/**
	 * If the absolute value of the balance of the given node (or any of the nodes
	 * above it) is greater than 1, this method performs the needed operations to
	 * make them balanced again.
	 * 
	 * @param currentNode
	 *            The node that must be rebalanced.
	 * 
	 */
	protected void rebalanceUp(BinaryTreeNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			this.rebalance(currentNode);
			this.rebalanceUp(currentNode.getParent());
		}
	}

	/**
	 * Rotates the subtree (whose root is the given node) to the left.
	 * 
	 * @param node
	 *            the node that is root of the subtree to be rotated.
	 * 
	 * @return the new root of the subtree.
	 * 
	 */
	private void leftRotation(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> newRoot = Rotator.leftRotation(node);

		if (this.getRoot().equals(node)) {
			this.setRoot(newRoot);
		}

	}

	/**
	 * Rotates the subtree (whose root is the given node) to the right.
	 * 
	 * @param node
	 *            the node that is root of the subtree to be rotated.
	 * 
	 * @return the new root of the subtree.
	 * 
	 */
	private void rightRotation(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> newRoot = Rotator.rightRotation(node);

		if (this.getRoot().equals(node)) {
			this.setRoot(newRoot);
		}
	}

}
