package com.carlosrobertofreire.whiteboard.datastructure;

public class Stack {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node top;

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty!");
		}
		int result = top.data;
		top = top.next;
		return result;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(int value) {
		Node newTop = new Node(value);
		newTop.next = top;
		top = newTop;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty!");
		}
		return top.data;
	}

}
