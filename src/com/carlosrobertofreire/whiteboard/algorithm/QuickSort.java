package com.carlosrobertofreire.whiteboard.algorithm;

/**
 * @author carlosrobertofreire
 *
 */
public class QuickSort {

	/**
	 * O(n log n) - Linearithmic
	 */
	public int[] sort(int[] array) {
		validate(array);
		if (array.length == 1) {
			return array;
		}
		return sort(array, 0, array.length - 1);
	}

	private void validate(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array must have values!");
		}
	}

	private int[] sort(int[] array, int leftIndex, int rightIndex) {
		int index = partition(array, leftIndex, rightIndex);
		if (leftIndex < index - 1) {
			sort(array, leftIndex, index - 1);
		}
		if (index < rightIndex) {
			sort(array, index, rightIndex);
		}
		return array;
	}

	private int partition(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[(leftIndex + rightIndex) / 2];
		while (leftIndex <= rightIndex) {
			while (array[leftIndex] < pivot) {
				leftIndex++;
			}
			while (array[rightIndex] > pivot) {
				rightIndex--;
			}
			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}

	private void swap(int[] array, int leftIndex, int rightIndex) {
		int temp = array[leftIndex];
		array[leftIndex] = array[rightIndex];
		array[rightIndex] = temp;
	}

}
