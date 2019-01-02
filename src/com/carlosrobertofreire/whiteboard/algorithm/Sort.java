package com.carlosrobertofreire.whiteboard.algorithm;

import java.util.Arrays;

public class Sort {

	/**
	 * O(n log n) - Linearithmic
	 */
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array must have values!");
		}
		if (array.length == 1) {
			return array;
		}
		int middleIndex = (array.length - 1) / 2;
		int[] leftArray = Arrays.copyOfRange(array, 0, middleIndex + 1);
		int[] rightArray = Arrays.copyOfRange(array, middleIndex + 1, array.length);
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
		return array;
	}

	private void merge(int[] leftArray, int[] rightArray, int[] array) {
		int arrayIndex = 0;
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
			if (leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
				array[arrayIndex++] = rightArray[rightArrayIndex++];
			} else {
				array[arrayIndex++] = leftArray[leftArrayIndex++];
			}
		}
		while (leftArrayIndex < leftArray.length) {
			array[arrayIndex++] = leftArray[leftArrayIndex++];
		}
		while (rightArrayIndex < rightArray.length) {
			array[arrayIndex++] = rightArray[rightArrayIndex++];
		}
	}

}
