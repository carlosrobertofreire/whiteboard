package com.carlosrobertofreire.whiteboard.playground;

public class ManipulateSimpleArray {

	public static void main(String[] args) {
		String[] words = new String[3];
		words[0] = "Abô";
		words[1] = "loves";
		words[2] = "Abô";
		for (int i = 0; i < words.length; i++) {
			print(words[i]);
			if (i + 1 < words.length)
				print(" ");
		}
	}

	private static void print(String value) {
		if (value == null)
			return;
		System.out.print(value);
	}

}
