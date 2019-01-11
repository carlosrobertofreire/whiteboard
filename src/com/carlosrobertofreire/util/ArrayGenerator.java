package com.carlosrobertofreire.util;

import java.util.HashSet;
import java.util.Random;

/**
 * @author carlosrobertofreire
 *
 */
public class ArrayGenerator {

	public static int[] createUnsortedArrayWithDuplicatedItems() {
		return new int[] { 3, 1, 52, 3, 1, 2, 21, 11, 10, 9 };
	}

	public static int[] createSortedFiveItemsArray() {
		return new int[] { 2, 17, 31, 46, 50 };
	}

	public static int[] createSortedArrayWithDuplicatedItems() {
		return new int[] { 2, 2, 4, 8, 21, 30 };
	}

	public static int[] createRandomArrayWithoutDuplicates(int expectedSize, int maxValue) {
		if (expectedSize > maxValue) {
			throw new IllegalArgumentException("Expected size cannot be greater than max value!");
		}		
		HashSet<Integer> numbersHashSet = generateRandomNumbersHashSet(expectedSize, maxValue);
		int[] numbersArray = convertHashSetToArray(numbersHashSet);
		return numbersArray;
	}
	
	private static HashSet<Integer> generateRandomNumbersHashSet(int expectedSize, int maxValue) {
		HashSet<Integer> numbersHashSet = new HashSet<>();
		Random random = new Random();
		while (numbersHashSet.size() <= expectedSize) {
			numbersHashSet.add(random.nextInt(maxValue - 1) + 1);
		}
		return numbersHashSet;
	}
	
	private static int[] convertHashSetToArray(HashSet<Integer> numberHashSet) {
		int[] numberArray = new int[numberHashSet.size()];
		int arrayIndex = 0;
		for (int number : numberHashSet) {
			numberArray[arrayIndex++] = number;
		}
		return numberArray;
	}

}
