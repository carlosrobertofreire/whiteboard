package com.carlosrobertofreire.whiteboard.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carlosrobertofreire.util.ArrayGenerator;

public class BinarySearchTest {

	private BinarySearch target;

	@Before
	public void setUp() throws Exception {
		target = new BinarySearch();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_searchRecursive_inputIsNull() {
		target.searchRecursive(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_searchRecursive_inputIsEmpty() {
		target.searchRecursive(new int[] {}, 1);
	}

	@Test
	public void test_searchRecursive_inputDoesNotExist() {
		Assert.assertEquals(false, target.searchRecursive(new int[] { 3, 5, 6 }, 2));
	}

	@Test
	public void test_searchRecursive_inputWithOneItem_success() {
		int[] oneItemArray = new int[] { 3 };
		Assert.assertEquals(true, target.searchRecursive(oneItemArray, 3));
		Assert.assertEquals(false, target.searchRecursive(oneItemArray, 5));
	}

	@Test
	public void test_searchRecursive_inputWithFiveItems_success() {
		int[] fiveItemsArray = ArrayGenerator.createSortedFiveItemsArray();
		Assert.assertEquals(true, target.searchRecursive(fiveItemsArray, 9));
		Assert.assertEquals(true, target.searchRecursive(fiveItemsArray, 5));
		Assert.assertEquals(true, target.searchRecursive(fiveItemsArray, 16));
		Assert.assertEquals(false, target.searchRecursive(fiveItemsArray, 1));
		Assert.assertEquals(false, target.searchRecursive(fiveItemsArray, -1));
	}

	@Test
	public void test_searchRecursive_inputWithFiftyItems_success() {
		int[] fiftyItemsArray = ArrayGenerator.createSequentialArray(50);
		Assert.assertEquals(true, target.searchRecursive(fiftyItemsArray, 2));
		Assert.assertEquals(true, target.searchRecursive(fiftyItemsArray, 38));
		Assert.assertEquals(true, target.searchRecursive(fiftyItemsArray, 49));
		Assert.assertEquals(true, target.searchRecursive(fiftyItemsArray, 50));
		Assert.assertEquals(false, target.searchRecursive(fiftyItemsArray, 100));
		Assert.assertEquals(false, target.searchRecursive(fiftyItemsArray, -1));
		Assert.assertEquals(false, target.searchRecursive(fiftyItemsArray, 51));
		Assert.assertEquals(false, target.searchRecursive(fiftyItemsArray, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_searchIterative_inputIsEmpty() {
		target.searchIterative(new int[] {}, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_searchIterative_inputIsNull() {
		target.searchIterative(null, 1);
	}

	@Test
	public void test_searchIterative_inputDoesNotExist() {
		Assert.assertEquals(false, target.searchIterative(new int[] { 3, 5, 6 }, 2));
	}

	@Test
	public void test_searchIterative_inputWithOneItem_success() {
		int[] oneItemArray = new int[] { 3 };
		Assert.assertEquals(true, target.searchIterative(oneItemArray, 3));
		Assert.assertEquals(false, target.searchIterative(oneItemArray, 5));
	}

	@Test
	public void test_searchIterative_inputWithFiveItems_success() {
		int[] fiveItemsArray = ArrayGenerator.createSortedFiveItemsArray();
		Assert.assertEquals(true, target.searchIterative(fiveItemsArray, 9));
		Assert.assertEquals(true, target.searchIterative(fiveItemsArray, 5));
		Assert.assertEquals(true, target.searchIterative(fiveItemsArray, 16));
		Assert.assertEquals(false, target.searchIterative(fiveItemsArray, 1));
		Assert.assertEquals(false, target.searchIterative(fiveItemsArray, -1));
	}

	@Test
	public void test_searchIterative_inputWithFiftyItems_success() {
		int[] fiftyItemsArray = ArrayGenerator.createSequentialArray(50);
		Assert.assertEquals(true, target.searchIterative(fiftyItemsArray, 2));
		Assert.assertEquals(true, target.searchIterative(fiftyItemsArray, 38));
		Assert.assertEquals(true, target.searchIterative(fiftyItemsArray, 49));
		Assert.assertEquals(true, target.searchIterative(fiftyItemsArray, 50));
		Assert.assertEquals(false, target.searchIterative(fiftyItemsArray, 100));
		Assert.assertEquals(false, target.searchIterative(fiftyItemsArray, -1));
		Assert.assertEquals(false, target.searchIterative(fiftyItemsArray, 51));
		Assert.assertEquals(false, target.searchIterative(fiftyItemsArray, 0));
	}

}
