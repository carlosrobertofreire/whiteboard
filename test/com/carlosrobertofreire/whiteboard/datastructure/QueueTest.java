package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	Queue target = null;

	@Before
	public void setUp() throws Exception {
		target = new Queue();
	}

	@Test
	public void test_enqueue_success() {
		target.enqueue(3);
		Assert.assertEquals(3, target.peek());
		target.enqueue(7);
		target.enqueue(10);
		Assert.assertEquals(3, target.peek());
	}

	@Test
	public void test_isEmpty_success() {
		Assert.assertEquals(true, target.isEmpty());
		target.enqueue(10);
		Assert.assertEquals(false, target.isEmpty());
	}

	@Test
	public void test_peek_success() {
		target.enqueue(30);
		target.enqueue(50);
		Assert.assertEquals(30, target.peek());
		target.dequeue();
		Assert.assertEquals(50, target.peek());
	}

	@Test(expected = IllegalStateException.class)
	public void test_peek_targetIsEmpty() {
		target.peek();
	}

	@Test
	public void test_dequeue_success() {
		target.enqueue(21);
		target.dequeue();
		target.enqueue(10);
		target.enqueue(23);
		Assert.assertEquals(10, target.peek());
		target.dequeue();
		target.dequeue();
		Assert.assertEquals(true, target.isEmpty());
		target.enqueue(23);
		Assert.assertEquals(23, target.peek());
	}

	@Test(expected = IllegalStateException.class)
	public void test_dequeue_targetIsEmpty() {
		target.dequeue();
	}

}
