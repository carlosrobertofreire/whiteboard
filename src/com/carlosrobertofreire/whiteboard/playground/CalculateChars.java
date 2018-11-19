package com.carlosrobertofreire.whiteboard.playground;

public class CalculateChars {

	public static void main(String[] args) {
		String word = "A ãé bcd efg wkyz";
		char[] letters = word.toCharArray();
		for (char letter : letters) {
			int index = letter - 'a';			
			System.out.println("Result for letter " + letter + ": " + index); 
		}
	}
	
}
