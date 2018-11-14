package com.carlosrobertofreire.whiteboard.datastructure;

/**
 * @author carlosrobertofreire
 *
 */
public class Trie {

	private static int ALPHABET_SIZE = 26;

	class TrieNode {

		TrieNode[] children;
		boolean isCompleteWord;

		public TrieNode() {
			children = new TrieNode[ALPHABET_SIZE];
			isCompleteWord = false;
		}

	}

	private TrieNode root;

	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Invalid word!");
		}
		if (root == null) {
			root = new TrieNode();
		}
		TrieNode current = root;
		int index = 0;
		for (int level = 0; level < word.length(); level++) {
			char letter = word.charAt(level);
			index = letter - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.children[index].isCompleteWord = true;
	}

}
