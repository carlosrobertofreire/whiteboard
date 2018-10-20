package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

	MinHeap target = null;

	@Before
	public void setUp() throws Exception {
		target = new MinHeap(10);
	}

	@Test
	public void test_insert_success() {
		Assert.assertEquals(0, target.getSize());
		target.insert(40);
		Assert.assertEquals(1, target.getSize());
		target.insert(86);
		Assert.assertEquals(2, target.getSize());
		target.insert(10);
		target.insert(5);
		Assert.assertEquals(4, target.getSize());
	}

	@Test
	public void test_getMin_success() {
		target.insert(25);
		Assert.assertEquals(25, target.getMin());
		target.insert(54);
		Assert.assertEquals(25, target.getMin());
		target.insert(15);
		Assert.assertEquals(15, target.getMin());
		target.insert(5);
		target.insert(3);
		Assert.assertEquals(3, target.getMin());
		Assert.assertEquals(3, target.getMin());
	}

	@Test(expected = IllegalStateException.class)
	public void test_getMin_error() {
		target.getMin();
	}

	@Test
	public void test_extractMin_success() {
		target.insert(87);
		target.insert(53);
		target.insert(150);
		Assert.assertEquals(53, target.extractMin());
		Assert.assertEquals(87, target.extractMin());
		Assert.assertEquals(150, target.extractMin());

		target.insert(15);
		target.insert(42);
		Assert.assertEquals(15, target.extractMin());
		Assert.assertEquals(42, target.extractMin());

		target.insert(410);
		target.insert(21);
		target.insert(30);
		target.insert(13);
		target.insert(240);
		target.insert(90);
		Assert.assertEquals(13, target.extractMin());
	}

	@Test(expected = IllegalStateException.class)
	public void test_extractMin_error() {
		target.extractMin();
	}

}
