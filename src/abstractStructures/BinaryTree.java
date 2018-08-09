package abstractStructures;

import binaryTree.BinaryTreeNode;

/**
 * A binary tree is a tree data structure in which each node has at most two
 * children, which are referred to as the left child and the right child. The
 * tree is made by nodes which data are the elements inserted in the tree.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public interface BinaryTree<T> {

	/**
	 * Returns true, if the binary tree is empty, or false, otherwise.
	 * 
	 * @return the boolean that indicates if the tree is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements contained in the binary tree.
	 * 
	 * @return the size of the tree.
	 * 
	 */
	public int size();

	/**
	 * As an empty binary tree has no root element, its height is -1. For a
	 * non-empty binary tree, the height is given by (1 + (the greatest height of
	 * its sub-trees)).
	 * 
	 * @return the binary tree height.
	 * 
	 */
	public int height();

	/**
	 * Inserts a new element at the binary tree. Null elements are not allowed. If
	 * the given element is null, the tree will remain unchanged.
	 * 
	 * @param element
	 *            the element to be inserted.
	 * 
	 */
	public void insert(T element);

	/**
	 * Removes an element from the binary tree. If the tree does not contain the
	 * element, the tree must remain unchanged.
	 * 
	 * @param element
	 *            the element to be removed.
	 * 
	 */
	public void remove(T element);

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
	public BinaryTreeNode<T> search(T element);

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree order.
	 * 
	 * @return a ordered array containing the binary tree elements.
	 * 
	 */
	public T[] order();

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree pre-order.
	 * 
	 * @return a pre-ordered array containing the binary tree elements.
	 * 
	 */
	public T[] preOrder();

	/**
	 * Creates an array containing the binary tree elements. This array is filled
	 * according to the binary tree post-order.
	 * 
	 * @return a post-ordered array containing the binary tree elements.
	 * 
	 */
	public T[] postOrder();

}