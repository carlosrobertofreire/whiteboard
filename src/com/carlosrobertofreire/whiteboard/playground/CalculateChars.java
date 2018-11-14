package com.carlosrobertofreire.whiteboard.playground;

public class CalculateChars {

	public static void main(String[] args) {
		String word = "Abcdefg";
		char[] letters = word.toLowerCase().toCharArray();
		for (char letter : letters) {
			int index = letter - 'a';			
			System.out.println("Result for letter " + letter + ": " + index); 
		}
	}
	
}
