package com.carlosrobertofreire.whiteboard.algorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carlosrobertofreire.util.ArrayGenerator;

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
		testSort(ArrayGenerator.createRandomArrayWithoutDuplicates(30, 300));
	}

	@Test
	public void test_sort_unsortedInputWithNinetyItems_success() {
		testSort(ArrayGenerator.createRandomArrayWithoutDuplicates(90, 300));
	}

	@Test
	public void test_sort_unsortedInputWithDuplicatedItems_success() {
		testSort(ArrayGenerator.createUnsortedArrayWithDuplicatedItems());
	}

	@Test
	public void test_sort_sortedInputWithFiveItems_success() {
		testSort(ArrayGenerator.createSortedFiveItemsArray());
	}

	@Test
	public void test_sort_sortedInputWithDuplicatedItems_success() {
		testSort(ArrayGenerator.createSortedArrayWithDuplicatedItems());
	}

	private void testSort(int[] array) {
		int[] expectedSortedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(expectedSortedArray);
		int[] sortedArrayByTarget = target.sort(array);
		for (int i = 0; i < sortedArrayByTarget.length; i++) {
			Assert.assertEquals(expectedSortedArray[i], sortedArrayByTarget[i]);
		}
	}

}
