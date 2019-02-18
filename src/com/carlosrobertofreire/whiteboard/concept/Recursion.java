package com.carlosrobertofreire.whiteboard.concept;

/**
 * @author carlosrobertofreire
 *
 */
public class Recursion {

	/**
	 * O(n) - Linear
	 */
	public int factorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number cannot be lower than 0!");
		}
		if (number == 0) {
			return 1;
		}
		return number * factorial(number - 1);
	}

	/**
	 * O(2^n) - Exponential
	 */
	public int fibonacci(int number) {
		if (number == 1) {
			return 1;
		}
		if (number <= 0) {
			return 0;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
