package balancedTree;

import binaryTree.BinaryTreeNode;

/**
 * A red-black tree is a kind of self-balancing binary search tree which each
 * node has an extra attribute: the color. The color is used to ensure the tree
 * remains approximately balanced during insertions and deletions. All other
 * features are the same of the BinaryTreeNode.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class RedBlackTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

	private Color color;

	/**
	 * Constructs an empty RedBlackTreeNode (data, parent, left and right will be
	 * null), known as NIL. Also, every NIL Node will be BLACK.
	 * 
	 */
	public RedBlackTreeNode() {
		this.color = Color.BLACK;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		if (super.isEmpty() && (this.getColor() == Color.RED)) {
			throw new UnsupportedOperationException("NIL nodes must be BLACK.");
		}

		this.color = color;
	}

	/**
	 * Compares the node executing this method with the Object given as parameter to
	 * determine if they are equals. To be equals, the given Object must be a
	 * RedBlackTreeNode containing the same data and color that the node executing
	 * this method contains.
	 * 
	 * @return The boolean that indicates the equality between the node and the
	 *         object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return (super.equals(obj) && (this.getColor() == ((RedBlackTreeNode<T>) obj).getColor()));
	}

	/**
	 * Returns a textual representation of the node using this method.
	 * 
	 * @return The textual representation of the node.
	 * 
	 */
	@Override
	public String toString() {
		String toString = "NIL";

		if (!isEmpty()) {
			toString = "(" + super.getData().toString();

			if (this.getColor() == Color.RED) {
				toString = toString + ", R)";
			} else {
				toString = toString + ", B)";
			}
		}

		return toString;
	}

}
