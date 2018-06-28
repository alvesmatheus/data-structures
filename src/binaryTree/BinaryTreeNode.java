package binaryTree;

/**
 * A binary tree is a tree data structure in which each node has at most two
 * children. A BinaryTreeNode must contain references to its parent, its left
 * child and its right child. Also, the nodes are responsible to store the
 * binary tree elements.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class BinaryTreeNode<T> {

	protected BinaryTreeNode<T> parent;
	protected BinaryTreeNode<T> right;
	protected BinaryTreeNode<T> left;
	protected T data;

	/**
	 * Constructs an empty BinaryTreeNode (data, parent, left and right will be
	 * null), known as NIL.
	 * 
	 */
	public BinaryTreeNode() {
	}

	public BinaryTreeNode<T> getParent() {
		return this.parent;
	}

	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	public BinaryTreeNode<T> getRight() {
		return this.right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Returns true if the node executing this method is a NIL. Otherwise, returns
	 * false. To be a NIL, a node must have null data attribute.
	 * 
	 * @return The boolean that indicates if the node is a NIL.
	 * 
	 */
	public boolean isEmpty() {
		return (this.data == null);
	}

	/**
	 * Returns true if the node executing this method is a leaf. Otherwise, returns
	 * false. To be a leaf, a node must have null data attribute and NIL nodes as
	 * children.
	 * 
	 * @return The boolean that indicates if the node is a leaf.
	 * 
	 */
	public boolean isLeaf() {
		return ((this.data != null) && (this.left.isEmpty()) && (this.right.isEmpty()));
	}

	/**
	 * Compares the node executing this method with the Object given as parameter to
	 * determine if they are equals. To be equals, the given Object must be a
	 * BinaryTreeNode containing the same data that the node executing this method
	 * contains.
	 * 
	 * @return The boolean that indicates the equality between the node and the
	 *         object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		boolean answer = false;

		if (object instanceof BinaryTreeNode) {
			if ((!this.isEmpty()) && (!((BinaryTreeNode<T>) object).isEmpty())) {
				answer = this.data.equals(((BinaryTreeNode<T>) object).data);
			} else {
				answer = (this.isEmpty() && ((BinaryTreeNode<T>) object).isEmpty());
			}
		}

		return answer;
	}

	/**
	 * Returns a textual representation of the node using this method. For NIL nodes
	 * it will be "NIL", for regular nodes the representation will be the toString()
	 * of the stored data.
	 * 
	 * @return The textual representation of the node.
	 * 
	 */
	@Override
	public String toString() {
		String toString = "NIL";

		if (!this.isEmpty()) {
			toString = data.toString();
		}

		return toString;
	}

}
