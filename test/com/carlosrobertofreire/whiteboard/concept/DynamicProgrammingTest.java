package com.carlosrobertofreire.whiteboard.concept;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicProgrammingTest {
	
	DynamicProgramming target = null;

	@Before
	public void setUp() throws Exception {
		target = new DynamicProgramming();		
	}

	@Test
	public void test_fibonacci_inputIsZero() {
		int input = 0;
		int expectedResult = 0;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}

	@Test
	public void test_fibonacci_inputIsGreaterThanZero() {
		int input = 3;
		int expectedResult = 2;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
		
		input = 4;
		expectedResult = 3;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
		
		input = 10;
		expectedResult = 55;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}

	@Test
	public void test_fibonacci_inputIsLowerThanZero() {
		int input = -3;
		int expectedResult = 0;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}
	
	@Test
	public void test_fibonacci_inputIsTheHugeNumber() {
		int input = 40;
		int expectedResult = 102334155;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}
}
