package com.carlosrobertofreire.whiteboard.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

	MergeSort target = null;

	@Before
	public void setUp() throws Exception {
		target = new MergeSort();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_sort_inputIsNull() {
		target.sort(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_sort_inputIsEmpty() {
		target.sort(new int[0]);
	}

	@Test
	public void test_sort_inputWithOneItem_success() {
		int[] arrayWithOneItem = new int[] { 5 };
		Assert.assertEquals(arrayWithOneItem, target.sort(arrayWithOneItem));
	}

	@Test
	public void test_sort_unsortedInputWithFiveItems_success() {
		int[] unsortedArray = new int[] { 7, 4, 10, 3, 16 };
		int[] expectedSortedArray = new int[] { 3, 4, 7, 10, 16 };
		int[] sortedArrayByTarget = target.sort(unsortedArray);
		for (int i = 0; i < sortedArrayByTarget.length; i++) {
			Assert.assertEquals(expectedSortedArray[i], sortedArrayByTarget[i]);
		}
	}

	@Test
	public void test_sort_unsortedInputWithThirtyItems_success() {
		testSort(createRandomArrayWithoutDuplicates(30));
	}

	@Test
	public void test_sort_unsortedInputWithNinetyItems_success() {
		testSort(createRandomArrayWithoutDuplicates(90));
	}

	@Test
	public void test_sort_unsortedInputWithDuplicatedItems_success() {
		testSort(createUnsortedArrayWithDuplicatedItems());
	}

	@Test
	public void test_sort_sortedInputWithFiveItems_success() {
		testSort(createSortedFiveItemsArray());
	}

	@Test
	public void test_sort_sortedInputWithDuplicatedItems_success() {
		testSort(createSortedArrayWithDuplicatedItems());
	}

	private void testSort(int[] array) {
		int[] expectedSortedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(expectedSortedArray);
		int[] sortedArrayByTarget = target.sort(array);
		for (int i = 0; i < sortedArrayByTarget.length; i++) {
			Assert.assertEquals(expectedSortedArray[i], sortedArrayByTarget[i]);
		}
	}

	private int[] createUnsortedArrayWithDuplicatedItems() {
		return new int[] { 3, 1, 52, 3, 1, 2, 21, 11, 10, 9 };
	}

	private int[] createSortedFiveItemsArray() {
		return new int[] { 2, 17, 31, 46, 50 };
	}

	private int[] createSortedArrayWithDuplicatedItems() {
		return new int[] { 2, 2, 4, 8, 21, 30 };
	}

	private int[] createRandomArrayWithoutDuplicates(int expectedSize) {
		if (expectedSize > 300) {
			throw new IllegalArgumentException("Max size is 300!");
		}
		Random random = new Random();
		HashSet<Integer> numbers = new HashSet<>();
		while (numbers.size() <= expectedSize) {
			numbers.add(random.nextInt(300 - 1) + 1);
		}
		int[] array = new int[numbers.size()];
		int arrayIndex = 0;
		for (int number : numbers) {
			array[arrayIndex++] = number;
		}
		return array;
	}

}
