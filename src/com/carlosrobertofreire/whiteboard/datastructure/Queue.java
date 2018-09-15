package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class Queue {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node first;
	private Node last;

	/**
	 * O(1) - Constant
	 */
	public void enqueue(int value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			first = newNode;
			last = first;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	/**
	 * O(1) - Constant
	 */
	public boolean isEmpty() {
		return first == null && last == null;
	}

	/**
	 * O(1) - Constant
	 */
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty!");
		}
		return first.data;
	}

	/**
	 * O(1) - Constant
	 */
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty!");
		}
		int result = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return result;
	}

}
