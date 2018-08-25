package com.carlosrobertofreire.whiteboard.datastructure;

public class DynamicArray {

	private int[] data = new int[1];
	private int size = 0;

	public int getCapacity() {
		return data.length;
	}

	public int getSize() {
		return size;
	}

	/*
	 * Average Case O(1) - Constant
	 * Worst Case O(n) - Linear
	 */
	public int add(int value) {
		ensureDynamicCapacity();
		int index = size;
		data[index] = value;
		size++;
		return index;
	}

	/*
	 * O(n) - Linear
	 */
	public boolean contains(int value) {
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				return true;
			}
		}
		return false;
	}

	/*
	 * O(1) - Constant
	 */
	public int get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("Invalid index!");
		}
		return data[index];
	}

	/*
	 * O(n) - Linear
	 */
	public void insert(int index, int value) {
		if (index < 0 || index >= data.length) {
			throw new ArrayIndexOutOfBoundsException("Invalid index!");
		}
		ensureDynamicCapacity();
		if (data[index] != 0) {
			for (int i = data.length - 1; i > index; i--) {
				data[i] = data[i - 1];
			}
		}
		data[index] = value;
		size++;
	}

	/*
	 * O(n) - Linear
	 */
	public void delete(int index) {
		if (size == 0 || index < 0 || index >= data.length) {
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		if (index != size - 1) {
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
		}
		data[size - 1] = 0;
		size--;
		ensureDynamicCapacity();
	}

	private void ensureDynamicCapacity() {
		if (size == data.length) {
			// Growth
			resizeArray(data.length * 2);
		} else if (size != 0 && size <= (data.length / 4)) {
			// Shrink
			resizeArray(data.length / 2);
		}
	}

	/*
	 * O(n) - Linear
	 */
	private void resizeArray(int newCapacity) {
		int[] newData = new int[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

}
