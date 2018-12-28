package com.carlosrobertofreire.whiteboard.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	
	private Search target;
	
	@Before
	public void setUp() throws Exception {
		target = new Search();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_binarySearchRecursive_inputIsNull() {
		target.binarySearchRecursive(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_binarySearchRecursive_inputIsEmpty() {
		target.binarySearchRecursive(new int[] {}, 1);
	}

	@Test
	public void test_binarySearchRecursive_inputDoesNotExist() {
		Assert.assertEquals(false, target.binarySearchRecursive(new int[] { 3, 5, 6 }, 2));
	}

	@Test
	public void test_binarySearchRecursive_inputWithOneItem_success() {
		int[] oneItemArray = new int[] { 3 };
		Assert.assertEquals(true, target.binarySearchRecursive(oneItemArray, 3));
		Assert.assertEquals(false, target.binarySearchRecursive(oneItemArray, 5));
	}

	@Test
	public void test_binarySearchRecursive_inputWithFiveItems_success() {
		int[] fiveItemsArray = createFiveItemsArray();
		Assert.assertEquals(true, target.binarySearchRecursive(fiveItemsArray, 9));
		Assert.assertEquals(true, target.binarySearchRecursive(fiveItemsArray, 5));
		Assert.assertEquals(true, target.binarySearchRecursive(fiveItemsArray, 16));
		Assert.assertEquals(false, target.binarySearchRecursive(fiveItemsArray, 1));
		Assert.assertEquals(false, target.binarySearchRecursive(fiveItemsArray, -1));
	}

	@Test
	public void test_binarySearchRecursive_inputWithFiftyItems_success() {
		int[] fiftyItemsArray = createFiftyItemsArray();
		Assert.assertEquals(true, target.binarySearchRecursive(fiftyItemsArray, 2));
		Assert.assertEquals(true, target.binarySearchRecursive(fiftyItemsArray, 38));
		Assert.assertEquals(true, target.binarySearchRecursive(fiftyItemsArray, 49));
		Assert.assertEquals(true, target.binarySearchRecursive(fiftyItemsArray, 50));
		Assert.assertEquals(false, target.binarySearchRecursive(fiftyItemsArray, 100));
		Assert.assertEquals(false, target.binarySearchRecursive(fiftyItemsArray, -1));
		Assert.assertEquals(false, target.binarySearchRecursive(fiftyItemsArray, 51));
		Assert.assertEquals(false, target.binarySearchRecursive(fiftyItemsArray, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_binarySearchIterative_inputIsEmpty() {
		target.binarySearchIterative(new int[] {}, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_binarySearchIterative_inputIsNull() {
		target.binarySearchIterative(null, 1);
	}

	@Test
	public void test_binarySearchIterative_inputDoesNotExist() {
		Assert.assertEquals(false, target.binarySearchIterative(new int[] { 3, 5, 6 }, 2));
	}

	@Test
	public void test_binarySearchIterative_inputWithOneItem_success() {
		int[] oneItemArray = new int[] { 3 };
		Assert.assertEquals(true, target.binarySearchIterative(oneItemArray, 3));
		Assert.assertEquals(false, target.binarySearchIterative(oneItemArray, 5));
	}

	@Test
	public void test_binarySearchIterative_inputWithFiveItems_success() {
		int[] fiveItemsArray = createFiveItemsArray();
		Assert.assertEquals(true, target.binarySearchIterative(fiveItemsArray, 9));
		Assert.assertEquals(true, target.binarySearchIterative(fiveItemsArray, 5));
		Assert.assertEquals(true, target.binarySearchIterative(fiveItemsArray, 16));
		Assert.assertEquals(false, target.binarySearchIterative(fiveItemsArray, 1));
		Assert.assertEquals(false, target.binarySearchIterative(fiveItemsArray, -1));
	}

	@Test
	public void test_binarySearchIterative_inputWithFiftyItems_success() {
		int[] fiftyItemsArray = createFiftyItemsArray();
		Assert.assertEquals(true, target.binarySearchIterative(fiftyItemsArray, 2));
		Assert.assertEquals(true, target.binarySearchIterative(fiftyItemsArray, 38));
		Assert.assertEquals(true, target.binarySearchIterative(fiftyItemsArray, 49));
		Assert.assertEquals(true, target.binarySearchIterative(fiftyItemsArray, 50));
		Assert.assertEquals(false, target.binarySearchIterative(fiftyItemsArray, 100));
		Assert.assertEquals(false, target.binarySearchIterative(fiftyItemsArray, -1));
		Assert.assertEquals(false, target.binarySearchIterative(fiftyItemsArray, 51));
		Assert.assertEquals(false, target.binarySearchIterative(fiftyItemsArray, 0));
	}

	private int[] createFiveItemsArray() {
		return new int[] { 3, 5, 6, 9, 16 };
	}

	private int[] createFiftyItemsArray() {
		int[] array = new int[50];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		return array;
	}

}
