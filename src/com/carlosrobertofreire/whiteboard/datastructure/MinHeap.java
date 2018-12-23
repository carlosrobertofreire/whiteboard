package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class MinHeap {

	private int[] data;
	private int size;

	private static int INITIAL_CAPACITY = 10;

	public MinHeap() {
		data = new int[INITIAL_CAPACITY];
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

	private boolean hasLeftChild(int currentIndex) {
		return getLeftChildIndex(currentIndex) < size;
	}

	private boolean hasRightChild(int currentIndex) {
		return getRightChildIndex(currentIndex) < size;
	}

	private int leftChild(int currentIndex) {
		return data[getLeftChildIndex(currentIndex)];
	}

	private int rightChild(int currentIndex) {
		return data[getRightChildIndex(currentIndex)];
	}

	private int parent(int currentIndex) {
		return data[getParentIndex(currentIndex)];
	}

	private void swap(int indexA, int indexB) {
		int value = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = value;
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public void insert(int value) {
		ensureExtraCapacity();
		int lastIndex = size;
		data[lastIndex] = value;
		size++;
		heapifyUp(lastIndex);
	}

	private void heapifyUp(int currentIndex) {
		if (data[currentIndex] < parent(currentIndex)) {
			swap(currentIndex, getParentIndex(currentIndex));
			heapifyUp(getParentIndex(currentIndex));
		}
	}

	private void ensureExtraCapacity() {
		if (size == data.length) {
			int[] newData = new int[data.length * 2];
			for (int i = 0; i < size; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public int extractMin() {
		if (isEmpty()) {
			throw new IllegalStateException("Heap is empty!");
		}
		int rootIndex = 0;
		int minValue = data[rootIndex];
		data[rootIndex] = 0;
		swap(rootIndex, size - 1);
		size--;
		heapifyDown(rootIndex);
		return minValue;
	}

	private boolean isEmpty() {
		return data == null || size == 0;
	}

	private void heapifyDown(int currentIndex) {
		if (hasLeftChild(currentIndex)) {
			int lowerIndex = getLeftChildIndex(currentIndex);
			if (hasRightChild(currentIndex)) {
				if (rightChild(currentIndex) < leftChild(currentIndex)) {
					lowerIndex = getRightChildIndex(currentIndex);
				}
			}
			if (data[lowerIndex] < data[currentIndex]) {
				swap(lowerIndex, currentIndex);
				heapifyDown(lowerIndex);
			}
		}
	}

	/**
	 * O(1) - Constant
	 */
	public int getMin() {
		if (isEmpty()) {
			throw new IllegalStateException("Heap is empty!");
		}
		return data[0];
	}

	public int getSize() {
		return size;
	}
}
