package com.carlosrobertofreire.whiteboard.concept;

import java.util.HashMap;

/**
 * @author carlosrobertofreire
 *
 */
public class DynamicProgramming {

	public int fibonacci(int number) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		return fibonacci(number, memo);
	}

	private int fibonacci(int number, HashMap<Integer, Integer> memo) {
		if (number == 1) {
			return 1;
		}
		if (number <= 0) {
			return 0;
		}
		if (memo.containsKey(number)) {
			return memo.get(number);
		}
		int result = fibonacci(number - 1, memo) + fibonacci(number - 2, memo);
		memo.put(number, result);
		return result;
	}

}
