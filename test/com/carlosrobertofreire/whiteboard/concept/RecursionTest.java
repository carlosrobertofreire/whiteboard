package com.carlosrobertofreire.whiteboard.concept;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursionTest {

	Recursion target = null;

	@Before
	public void setUp() throws Exception {
		target = new Recursion();
	}

	@Test
	public void test_factorial_inputIsZero() {
		int input = 0;
		int expectedResult = 1;
		Assert.assertEquals(expectedResult, target.factorial(input));
	}

	@Test
	public void test_factorial_inputIsGreaterThanZero() {
		int input = 3;
		int expectedResult = 6;
		Assert.assertEquals(expectedResult, target.factorial(input));

		input = 9;
		expectedResult = 362880;
		Assert.assertEquals(expectedResult, target.factorial(input));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_inputIsLowerThanZero() {
		int input = -3;
		target.factorial(input);
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
		
		input = 10;
		expectedResult = 55;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
		
		input = 30;
		expectedResult = 832040;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}

	@Test
	public void test_fibonacci_inputIsLowerThanZero() {
		int input = -3;
		int expectedResult = 0;
		Assert.assertEquals(expectedResult, target.fibonacci(input));
	}

}
