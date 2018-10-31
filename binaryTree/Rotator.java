package binaryTree;

/**
 * This class contains useful methods for performing rotations on binary trees.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class Rotator {

	/**
	 * Rotates the tree (whose root is the given node) to the left.
	 * 
	 * @param node the root of the binary tree to be rotated.
	 * 
	 * @return the new root of the binary tree.
	 * 
	 */
	public static <T extends Comparable<T>> BinaryTreeNode<T> leftRotation(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> nodeChild = node.getRight();
		BinaryTreeNode<T> nodeParent = node.getParent();
		BinaryTreeNode<T> auxNode = nodeChild.getLeft();

		nodeChild.setParent(nodeParent);

		if (nodeParent.getLeft() != null) {
			if (nodeParent.getLeft().equals(node)) {
				nodeParent.setLeft(nodeChild);
			} else {
				nodeParent.setRight(nodeChild);
			}
		}

		node.setParent(nodeChild);
		nodeChild.setLeft(node);
		node.setRight(auxNode);

		return nodeChild;
	}

	/**
	 * Rotates the tree (whose root is the given node) to the right.
	 * 
	 * @param node the root of the binary tree to be rotated.
	 * 
	 * @return the new root of the binary tree.
	 * 
	 */
	public static <T extends Comparable<T>> BinaryTreeNode<T> rightRotation(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> nodeChild = node.getLeft();
		BinaryTreeNode<T> nodeParent = node.getParent();
		BinaryTreeNode<T> auxNode = nodeChild.getRight();

		nodeChild.setParent(nodeParent);

		if (nodeParent.getLeft() != null) {
			if (nodeParent.getLeft().equals(node)) {
				nodeParent.setLeft(nodeChild);
			} else {
				nodeParent.setRight(nodeChild);
			}
		}

		node.setParent(nodeChild);
		nodeChild.setRight(node);
		node.setLeft(auxNode);

		return nodeChild;
	}

}
