package com.carlosrobertofreire.whiteboard.algorithm;

/**
 * @author carlosrobertofreire
 *
 */
public class BinarySearch {

	/**
	 * O(log n) - Logarithmic
	 */
	public boolean searchRecursive(int[] array, int key) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array must have values!");
		}
		return searchRecursive(array, key, 0, array.length - 1);
	}

	private boolean searchRecursive(int[] array, int key, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return false;
		}
		int middleIndex = (startIndex + endIndex) / 2;
		if (array[middleIndex] > key) {
			return searchRecursive(array, key, startIndex, middleIndex - 1);
		} else if (array[middleIndex] < key) {
			return searchRecursive(array, key, middleIndex + 1, endIndex);
		} else {
			return true;
		}
	}

	/**
	 * O(log n) - Logarithmic
	 */
	public boolean searchIterative(int[] array, int key) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array must have values!");
		}
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			int middleIndex = (startIndex + endIndex) / 2;
			if (array[middleIndex] > key) {
				endIndex = middleIndex - 1;
			} else if (array[middleIndex] < key) {
				startIndex = middleIndex + 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
