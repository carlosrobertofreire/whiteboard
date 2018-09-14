package com.carlosrobertofreire.whiteboard.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author carlosrobertofreire
 *
 */
public class Hashtable {

	private LinkedList<HashEntry>[] data;

	private class HashEntry {
		private String key;
		private int value;

		public HashEntry(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	@SuppressWarnings("unchecked")
	public Hashtable(int capacity) {
		data = new LinkedList[capacity];
	}

	/**
	 * O(1) - Constant
	 */
	public void put(String key, int value) {
		if (containsKey(key)) {
			throw new IllegalArgumentException("Key already exists!");
		}
		validateKey(key);
		int hashcode = convertKey2Hashcode(key);
		int index = convertHashcode2Index(hashcode);
		LinkedList<HashEntry> target = data[index];
		if (target == null) {
			target = new LinkedList<HashEntry>();
		}
		HashEntry hashEntry = new HashEntry(key, value);
		target.add(hashEntry);
		data[index] = target;
	}

	/**
	 * O(1) - Constant
	 */
	public int get(String key) {
		validateKey(key);
		int hashcode = convertKey2Hashcode(key);
		int index = convertHashcode2Index(hashcode);
		LinkedList<HashEntry> target = data[index];
		if (target == null) {
			throw new IllegalArgumentException("Key not found!");
		}
		Iterator<HashEntry> iterator = target.iterator();
		while (iterator.hasNext()) {
			HashEntry current = iterator.next();
			if (current.key.equals(key)) {
				return current.value;
			}
		}
		throw new IllegalArgumentException("Key not found!");
	}

	/**
	 * O(1) - Constant
	 */
	public boolean containsKey(String key) {
		validateKey(key);
		int hashcode = convertKey2Hashcode(key);
		int index = convertHashcode2Index(hashcode);
		LinkedList<HashEntry> target = data[index];
		if (target == null) {
			return false;
		}
		Iterator<HashEntry> iterator = target.iterator();
		while (iterator.hasNext()) {
			HashEntry current = iterator.next();
			if (current.key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * O(1) - Constant
	 */
	public void delete(String key) {
		validateKey(key);
		int hashcode = convertKey2Hashcode(key);
		int index = convertHashcode2Index(hashcode);
		LinkedList<HashEntry> target = data[index];
		if (target == null) {
			throw new IllegalArgumentException("Key not found!");
		}
		Iterator<HashEntry> iterator = target.iterator();
		int position = 0;
		while (iterator.hasNext()) {
			HashEntry current = iterator.next();
			if (current.key.equals(key)) {
				target.remove(position);
				return;
			}
			position++;
		}
		throw new IllegalArgumentException("Key not found!");
	}

	private void validateKey(String key) {
		if (key == null || key.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid key!");
		}
	}

	private int convertKey2Hashcode(String key) {
		return Math.abs(key.hashCode());
	}

	private int convertHashcode2Index(int hashcode) {
		return hashcode % data.length;
	}

}