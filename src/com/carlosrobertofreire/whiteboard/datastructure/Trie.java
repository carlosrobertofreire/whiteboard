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
		if (!isValid(word)) {
			throw new IllegalArgumentException("Invalid word!");
		}
		if (root == null) {
			root = new TrieNode();
		}
		TrieNode currentTrieNode = root;
		int index = 0;
		for (int level = 0; level < word.length(); level++) {
			char letter = word.charAt(level);
			index = letter - 'a';
			if (currentTrieNode.children[index] == null) {
				currentTrieNode.children[index] = new TrieNode();
			}
			currentTrieNode = currentTrieNode.children[index];
		}
		currentTrieNode.children[index].isCompleteWord = true;
	}

	public boolean contains(String word) {
		if (isEmpty() || !isValid(word)) {
			return false;
		}
		TrieNode currentTrieNode = root;
		for (int level = 0; level < word.length(); level++) {
			char letter = word.charAt(level);
			int index = letter - 'a';
			if (currentTrieNode.children[index] == null) {
				return false;
			}
			currentTrieNode = currentTrieNode.children[index];
		}
		return currentTrieNode.isCompleteWord;
	}

	private boolean isValid(String word) {
		return word != null && !word.isEmpty();
	}

	private boolean isEmpty() {
		return root == null;
	}

	public void delete(String word) {
		if (isEmpty()) {
			throw new IllegalStateException("Trie is empty!");
		}
		if (!isValid(word)) {
			throw new IllegalArgumentException("Word is invalid!");
		}
		delete(root, word, 0);
	}

	private void delete(TrieNode current, String word, int position) {
		if (position >= word.length()) {
			return;
		}
		int index = word.charAt(position) - 'a';
		if (current.children[index] == null) {
			throw new IllegalArgumentException("Word does not exist in the Trie!");
		} else {
			delete(current.children[index], word, position++);
		}
		if (position == (word.length() - 1)) {
			if (isLeaf(current)) {
				current = null;
			} else {
				current.isCompleteWord = false;
			}
		} else {
			if (current.isCompleteWord) {
				return;
			}
			if (isLeaf(current)) {
				current = null;
			}
		}
	}

	private boolean isLeaf(TrieNode node) {
		if (node == null)
			throw new IllegalArgumentException("Node is null!");
		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				return false;
			}
		}
		return true;
	}

}
