package com.carlosrobertofreire.whiteboard.datastructure;

public class LinkedList {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			Node oldTail = tail;
			oldTail.next = newNode;
			tail = newNode;
		}
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public boolean contains(int value) {
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.data == value) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public int get(int index) {
		if (index >= 0 && head != null) {
			Node currentNode = head;
			int position = 0;
			while (currentNode != null) {
				if (index == position) {
					return currentNode.data;
				}
				position++;
				currentNode = currentNode.next;
			}
		}
		throw new IllegalArgumentException("Invalid index!");
	}

	public void insert(int index, int value) {
		if (head != null && index >= 0) {
			Node newNode = new Node(value);
			if (index == 0) {
				newNode.next = head;
				head = newNode;
				return;
			} else {
				Node currentNode = head;
				int position = 0;
				while (currentNode.next != null) {
					if (position + 1 == index) {
						newNode.next = currentNode.next;
						currentNode.next = newNode;
						return;
					}
					position++;
					currentNode = currentNode.next;
				}
			}
		}
		throw new IllegalArgumentException("Invalid index");
	}

	public void delete(int index) {
		if (head != null && index >= 0) {
			if (index == 0) {
				head = head.next;
				if (head == null) {
					tail = null;
				}
				return;
			} else {
				Node currentNode = head;
				int position = 0;
				while (currentNode.next != null) {
					if (position + 1 == index) {
						currentNode.next = currentNode.next.next;
						if (currentNode.next == null) {
							tail = currentNode;
						}
						return;
					}
					position++;
					currentNode = currentNode.next;
				}
			}
		}
		throw new IllegalArgumentException("Invalid index!");
	}

	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
}