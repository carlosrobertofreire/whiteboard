package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
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

	/**
	 * O(1) - Constant
	 */
	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	/**
	 * O(1) - Constant
	 */
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

	/**
	 * O(n) - Linear
	 */
	public boolean contains(int value) {
		Node current = head;
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * O(n) - Linear
	 */
	public int get(int index) {
		if (index >= 0 && head != null) {
			Node current = head;
			int position = 0;
			while (current != null) {
				if (index == position) {
					return current.data;
				}
				position++;
				current = current.next;
			}
		}
		throw new IllegalArgumentException("Invalid index!");
	}

	/**
	 * O(n) - Linear
	 */
	public void insert(int index, int value) {
		if (head != null && index >= 0) {
			Node newNode = new Node(value);
			if (index == 0) {
				newNode.next = head;
				head = newNode;
				return;
			} else {
				Node current = head;
				int position = 0;
				while (current.next != null) {
					if (position + 1 == index) {
						newNode.next = current.next;
						current.next = newNode;
						return;
					}
					position++;
					current = current.next;
				}
			}
		}
		throw new IllegalArgumentException("Invalid index!");
	}

	/**
	 * O(n) - Linear
	 */
	public void delete(int index) {
		if (head != null && index >= 0) {
			if (index == 0) {
				head = head.next;
				if (head == null) {
					tail = null;
				}
				return;
			} else {
				Node current = head;
				int position = 0;
				while (current.next != null) {
					if (position + 1 == index) {
						current.next = current.next.next;
						if (current.next == null) {
							tail = current;
						}
						return;
					}
					position++;
					current = current.next;
				}
			}
		}
		throw new IllegalArgumentException("Invalid index!");
	}

	/**
	 * O(n) - Linear
	 */
	public void deleteByData(int data){
		if (head != null){
			if (head.data == data) {
				head = head.next;
				if (head == null) {
					tail = null;
				}
				return;
			}
			Node current = head;			
			while (current.next != null){
				if (current.next.data == data){
					if (tail.data == data){				
						tail = current;
					}
					current.next = current.next.next;
					return;	
				}
				current = current.next;
			}
		}
		throw new IllegalArgumentException("Value nout found!");
	}
		
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
}