package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class MinHeap {

	private int[] data;
	private int capacity;
	private int size;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		data = new int[capacity];
	}

	private int getParentIndex(int currentIndex) {
		return (currentIndex - 1) / 2;
	}

	private int getLeftChildIndex(int currentIndex) {
		return (2 * currentIndex) + 1;
	}

	private int getRightChildIndex(int currentIndex) {
		return (2 * currentIndex) + 2;
	}

	private boolean hasParent(int currentIndex) {
		int parentIndex = getParentIndex(currentIndex);
		return parentIndex >= 0 && parentIndex < size;
	}

	private boolean hasLeftChild(int currentIndex) {
		return getLeftChildIndex(currentIndex) < size;
	}

	private boolean hasRightChild(int currentIndex) {
		return getRightChildIndex(currentIndex) < size;
	}

	private int leftChild(int currentIndex) {
		if (hasLeftChild(currentIndex)) {
			return data[getLeftChildIndex(currentIndex)];
		} else {
			throw new IllegalArgumentException("There is no left child for given index!");
		}
	}

	private int rightChild(int currentIndex) {
		if (hasRightChild(currentIndex)) {
			return data[getRightChildIndex(currentIndex)];
		} else {
			throw new IllegalArgumentException("There is no right child for given index!");
		}
	}

	private int parent(int currentIndex) {
		if (hasParent(currentIndex)) {
			return data[getParentIndex(currentIndex)];
		} else {
			throw new IllegalArgumentException("There is no parent for given index!");
		}
	}

	private void swap(int indexA, int indexB) {
		validateIndexes(indexA, indexB);
		int value = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = value;
	}

	private void validateIndexes(int indexA, int indexB) {
		if (!isValidIndex(indexA) || !isValidIndex(indexB)) {
			throw new IllegalArgumentException("Invalid index!");
		}
	}

	private boolean isValidIndex(int index) {
		return index >= 0 && index < size;
	}

}
