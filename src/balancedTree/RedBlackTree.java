package balancedTree;

import binaryTree.Rotator;
import searchTree.SortedBinaryTree;

/**
 * A red-black tree is a kind of self-balancing binary search tree which each
 * node has an extra attribute: the color. The color is used to ensure the tree
 * remains approximately balanced during insertions and deletions. The balancing
 * of the tree allow it to guarantee insertion, deletion and searching in O(log
 * n) time.
 * 
 * There are five properties in the red-black trees: each node is either red or
 * black; the root is always black; all NIL nodes are black; if a node is red,
 * then both its children are black; every path from a given node to any of its
 * descendant NIL nodes contains the same number of black nodes.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class RedBlackTree<T extends Comparable<T>> extends SortedBinaryTree<T> {

	/**
	 * Constructs an empty RedBlackTree whose root will be a NIL RedBlackTreeNode.
	 * 
	 */
	public RedBlackTree() {
		super.setRoot(new RedBlackTreeNode<T>());
	}

	/**
	 * Inserts a new element at the red-black tree. Null elements are not allowed.
	 * If the given element is null, the tree will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	@Override
	public void insert(T element) {
		if (super.isValidInput(element)) {
			if (!super.isEmpty()) {
				this.insert(element, (RedBlackTreeNode<T>) super.getRoot(), null);
			}

			else {
				super.getRoot().setData(element);
				super.getRoot().setLeft(new RedBlackTreeNode<T>());
				super.getRoot().setRight(new RedBlackTreeNode<T>());
				((RedBlackTreeNode<T>) super.getRoot()).setColor(Color.BLACK);
			}
		}
	}

	// RECURSIVE AUXILIAR METHOD TO: insert(T element).
	private void insert(T element, RedBlackTreeNode<T> currentNode, RedBlackTreeNode<T> nodeParent) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setParent(nodeParent);
			currentNode.setLeft(new RedBlackTreeNode<T>());
			currentNode.setRight(new RedBlackTreeNode<T>());

			currentNode.setColor(Color.RED);
			this.fixUpCase1(currentNode);
		}

		else {
			if (currentNode.getData().compareTo(element) < 0) {
				this.insert(element, ((RedBlackTreeNode<T>) currentNode.getRight()), currentNode);
			} else {
				this.insert(element, ((RedBlackTreeNode<T>) currentNode.getLeft()), currentNode);
			}
		}
	}

	/**
	 * Calculates and returns the black height of the red-black tree. The black
	 * height is the number of black nodes between the root and the deepest of its
	 * descendants.
	 * 
	 * @return the black height of the tree.
	 * 
	 */
	public int blackHeight() {
		return this.blackHeight((RedBlackTreeNode<T>) super.getRoot());
	}

	// RECURSIVE AUXILIAR METHOD TO: blackHeight().
	private int blackHeight(RedBlackTreeNode<T> node) {
		int blackHeight = 0;

		if (!node.isEmpty()) {
			int leftBlackHeight = this.blackHeight((RedBlackTreeNode<T>) node.getLeft());
			int rightBlackHeight = this.blackHeight((RedBlackTreeNode<T>) node.getRight());

			blackHeight = Math.max(leftBlackHeight, rightBlackHeight);

			if (node.getColor() == Color.BLACK) {
				blackHeight++;
			}
		}

		return blackHeight;
	}

	// THE METHODS BELOW ARE AUXILIARIES USED TO GUARANTEE THE RED-BLACK TREE
	// PROPERTIES.

	private boolean isLeftChild(RedBlackTreeNode<T> node) {
		return ((node.getParent() != null) && (((RedBlackTreeNode<T>) node.getParent().getLeft()).equals(node)));
	}

	private boolean isRightChild(RedBlackTreeNode<T> node) {
		return ((node.getParent() != null) && (((RedBlackTreeNode<T>) node.getParent().getRight()).equals(node)));
	}

	private RedBlackTreeNode<T> getNodeUncle(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> uncle = new RedBlackTreeNode<T>();
		RedBlackTreeNode<T> parent = ((RedBlackTreeNode<T>) node.getParent());
		RedBlackTreeNode<T> grandParent = ((RedBlackTreeNode<T>) parent.getParent());

		if (this.isLeftChild(parent)) {
			uncle = ((RedBlackTreeNode<T>) grandParent.getRight());
		} else {
			uncle = ((RedBlackTreeNode<T>) grandParent.getLeft());
		}

		return uncle;
	}

	private void fixUpCase1(RedBlackTreeNode<T> node) {
		if (node.equals(super.getRoot())) {
			node.setColor(Color.BLACK);
		} else {
			this.fixUpCase2(node);
		}
	}

	private void fixUpCase2(RedBlackTreeNode<T> node) {
		if (((RedBlackTreeNode<T>) node.getParent()).getColor() == Color.RED) {
			this.fixUpCase3(node);
		}
	}

	private void fixUpCase3(RedBlackTreeNode<T> node) {
		if (this.getNodeUncle(node).getColor() == Color.RED) {
			((RedBlackTreeNode<T>) node.getParent()).setColor(Color.BLACK);
			this.getNodeUncle(node).setColor(Color.BLACK);
			((RedBlackTreeNode<T>) node.getParent().getParent()).setColor(Color.RED);

			this.fixUpCase1(((RedBlackTreeNode<T>) node.getParent().getParent()));
		}

		else {
			this.fixUpCase4(node);
		}
	}

	private void fixUpCase4(RedBlackTreeNode<T> node) {
		RedBlackTreeNode<T> parent = ((RedBlackTreeNode<T>) node.getParent());

		if (this.isRightChild(node) && this.isLeftChild(parent)) {
			Rotator.leftRotation(parent);
		} else if (this.isLeftChild(node) && this.isRightChild(parent)) {
			Rotator.rightRotation(parent);
		}

		this.fixUpCase5(node);
	}

	private void fixUpCase5(RedBlackTreeNode<T> node) {
		((RedBlackTreeNode<T>) node.getParent()).setColor(Color.BLACK);
		((RedBlackTreeNode<T>) node.getParent().getParent()).setColor(Color.RED);

		if (this.isLeftChild(node)) {
			Rotator.rightRotation(((RedBlackTreeNode<T>) node.getParent().getParent()));
		} else {
			Rotator.leftRotation(((RedBlackTreeNode<T>) node.getParent().getParent()));
		}
	}

}
