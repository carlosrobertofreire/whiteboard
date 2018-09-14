package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class Stack {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node top;

	/**
	 * O(1) - Constant
	 */
	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty!");
		}
		int result = top.data;
		top = top.next;
		return result;
	}

	/**
	 * O(1) - Constant
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * O(1) - Constant
	 */
	public void push(int value) {
		Node newTop = new Node(value);
		newTop.next = top;
		top = newTop;
	}

	/**
	 * O(1) - Constant
	 */
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty!");
		}
		return top.data;
	}

}
