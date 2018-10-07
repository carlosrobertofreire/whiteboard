package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree target = null;

	@Before
	public void setUp() throws Exception {
		target = new BinarySearchTree();
	}

	@Test
	public void test_insert_success() {
		target.insert(50);
		Assert.assertEquals(true, target.contains(50));
		target.insert(40);
		Assert.assertEquals(true, target.contains(40));
		Assert.assertEquals(false, target.contains(10));		
	}
	
	@Test
	public void test_find_success() {
		target.insert(50);
		target.insert(20);
		target.insert(30);
		target.insert(10);
		target.printInOrder();
		Assert.assertEquals(30, target.find(30).data);
		Assert.assertEquals(10, target.find(10).data);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_find_inputDoesNotExist() {
		target.insert(55);
		target.insert(60);
		target.find(30);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_find_targetIsEmpty() {
		target.find(30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputDoesNotExist() {
		target.delete(30);
	}
	
	@Test
	public void test_delete_success() {
		target.insert(30);
		target.insert(10);
		target.insert(45);
		target.insert(60);
		Assert.assertEquals(true, target.contains(30));
		target.delete(30);
		Assert.assertEquals(false, target.contains(30));
		Assert.assertEquals(true, target.contains(10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_contains_inputDoesNotExist() {
		target.insert(45);
		target.contains(10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_contains_targetIsEmpty() {
		target.contains(10);
	}
	
	@Test
	public void test_contains_success() {
		target.insert(12);
		target.insert(22);
		target.insert(35);
		Assert.assertEquals(true, target.contains(12));
		Assert.assertEquals(false, target.contains(10));
	}

}
