package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	Stack target = null;

	@Before
	public void setUp() throws Exception {
		target = new Stack();
	}

	@Test
	public void test_pop_success() {
		target.push(3);
		Assert.assertEquals(3, target.pop());
		
		target.push(4);
		target.push(1);
		Assert.assertEquals(1, target.pop());		
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_pop_targetIsEmpty() {
		target.pop();
	}

	@Test
	public void test_isEmpty_success() {
		Assert.assertEquals(true, target.isEmpty());
		target.push(41);
		Assert.assertEquals(false, target.isEmpty());
		target.push(40);
		target.pop();
		target.pop();
		Assert.assertEquals(true, target.isEmpty());
	}

	@Test
	public void test_push_success() {
		target.push(23);
		Assert.assertEquals(23, target.peek());
		target.push(21);
		Assert.assertEquals(21, target.peek());
		target.push(11);
		target.push(17);
		target.push(19);
		Assert.assertEquals(19, target.peek());
	}

	@Test
	public void test_peek_success() {
		target.push(3);
		Assert.assertEquals(3, target.peek());
		target.push(5);
		Assert.assertEquals(5, target.peek());
		target.pop();
		target.push(1);
		Assert.assertEquals(1, target.peek());
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_peek_targetIsEmpty() {
		target.peek();
	}

}
