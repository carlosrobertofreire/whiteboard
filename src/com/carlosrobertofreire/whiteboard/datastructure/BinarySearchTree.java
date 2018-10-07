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

	private void insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		if (value > root.data) {
			insert(root.right, value);
		} else {
			insert(root.left, value);
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public void insert(int value) {
		insert(root, value);
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
		return find(value) != null;
	}

	private void delete(Node root, int value) {
		if (root == null) {
			throw new IllegalArgumentException("Value not found in the Tree!");
		}
		if (root.data == value) {
			// Leaf Node
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}

			// Two Child
			if (root.left != null && root.right != null) {
				int inOrderSuccessorValue = getInOrderSuccessorValue(root);
				delete(inOrderSuccessorValue);
				root.data = inOrderSuccessorValue;
				return;
			}

			// One Child
			if (root.left != null) {
				root = root.left;
				root.left = null;
			} else {
				root = root.right;
				root.right = null;
			}
			return;
		}
		if (value > root.data) {
			delete(root.right, value);
		} else {
			delete(root.left, value);
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public void delete(int value) {
		delete(root, value);
	}

	private int getInOrderSuccessorValue(Node root) {
		if (root == null) {
			throw new IllegalArgumentException("Node cannot be null!");
		}
		return getMinValue(root.right);
	}

	private int getMinValue(Node root) {
		if (root == null) {
			throw new IllegalArgumentException("Node cannot be null!");
		}
		if (root.left == null) {
			return root.data;
		} else {
			return getMinValue(root.left);
		}
	}

	private void printInOrder(Node root) {
		if (root != null) {
			if (root.left != null) {
				printInOrder(root.left);
			}
			System.out.print(root.data + " ");
			if (root.right != null) {
				printInOrder(root.right);
			}
		}
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			if (root.left != null) {
				printPreOrder(root.left);
			}
			if (root.right != null) {
				printPreOrder(root.right);
			}
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPostOrder(Node root) {
		if (root != null) {
			if (root.left != null) {
				printPostOrder(root.left);
			}
			if (root.right != null) {
				printPostOrder(root.right);
			}
			System.out.print(root.data + " ");
		}
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

}