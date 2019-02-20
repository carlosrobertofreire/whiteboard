package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class BinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	private Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (value > root.data) {
			root.right = insert(root.right, value);
		} else {
			root.left = insert(root.left, value);
		}
		return root;
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public void insert(int value) {
		root = insert(root, value);
	}

	private Node find(Node root, int value) {
		if (root == null) {
			throw new IllegalArgumentException("Value not found in the Tree!");
		}
		if (root.data == value) {
			return root;
		}
		if (value > root.data) {
			return find(root.right, value);
		} else {
			return find(root.left, value);
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public Node find(int value) {
		return find(root, value);
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public boolean contains(int value) {
		try {
			return find(value) != null;
		} catch (IllegalArgumentException illegalArgumentException) {
			return false;
		}
	}

	private Node delete(Node root, int value) {
		if (root == null) {
			throw new IllegalArgumentException("Value not found in the Tree!");
		}
		if (root.data == value) {
			// Leaf Node
			if (root.left == null && root.right == null) {
				return null;
			}

			// Two Child
			if (root.left != null && root.right != null) {
				int inOrderSuccessorValue = getInOrderSuccessorValue(root);
				delete(inOrderSuccessorValue);
				root.data = inOrderSuccessorValue;
				return root;
			}

			// One Child
			if (root.left != null) {
				root = root.left;
				root.left = null;
			} else {
				root = root.right;
				root.right = null;
			}
			return root;
		}
		if (value > root.data) {
			return delete(root.right, value);
		} else {
			return delete(root.left, value);
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public void delete(int value) {
		root = delete(root, value);
	}

	private int getInOrderSuccessorValue(Node root) {
		return getMinValue(root.right);
	}

	private int getMinValue(Node root) {
		if (root.left == null) {
			return root.data;
		} else {
			return getMinValue(root.left);
		}
	}
	
	/**
	 * O(n) - Linear
	 */
	public void printInOrder() {
		validateIfIsEmpty();
		printInOrder(root);
	}

	private void printInOrder(Node root) {
		if (root.left != null) {
			printInOrder(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null) {
			printInOrder(root.right);
		}
	}	
	
	/**
	 * O(n) - Linear
	 */
	public void printPreOrder() {
		validateIfIsEmpty();
		printPreOrder(root);
	}

	private void printPreOrder(Node root) {
		System.out.print(root.data + " ");
		if (root.left != null) {
			printPreOrder(root.left);
		}
		if (root.right != null) {
			printPreOrder(root.right);
		}
	}	

	/**
	 * O(n) - Linear
	 */
	public void printPostOrder() {
		validateIfIsEmpty();
		printPostOrder(root);
	}
	
	private void printPostOrder(Node root) {
		if (root.left != null) {
			printPostOrder(root.left);
		}
		if (root.right != null) {
			printPostOrder(root.right);
		}
		System.out.print(root.data + " ");
	}
	
	private void validateIfIsEmpty() {
		if (root == null) {
			throw new IllegalStateException("Binary BinarySearch Tree is empty!");
		}
	}

}