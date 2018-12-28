package com.carlosrobertofreire.whiteboard.datastructure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	BinarySearchTree target = null;

	private PrintStream sysOut;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		sysOut = System.out;
		System.setOut(new PrintStream(outContent));
	}

	@Before
	public void setUp() throws Exception {
		target = new BinarySearchTree();
	}

	@After
	public void revertStreams() {
		System.setOut(sysOut);
	}

	@Test
	public void test_insert_success() {
		target.insert(50);
		Assert.assertEquals(true, target.contains(50));
		target.insert(40);
		Assert.assertEquals(true, target.contains(40));
		Assert.assertEquals(false, target.contains(10));
	}

	@Test
	public void test_find_success() {
		target.insert(50);
		target.insert(20);
		target.insert(30);
		target.insert(10);
		Assert.assertEquals(30, target.find(30).data);
		Assert.assertEquals(10, target.find(10).data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_find_inputDoesNotExist() {
		target.insert(55);
		target.insert(60);
		target.find(30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_find_targetIsEmpty() {
		target.find(30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputDoesNotExist() {
		target.delete(30);
	}

	@Test
	public void test_delete_leafNode_success() {
		createTargetWithSixteenItems();
		int nodeToDelete = 28;
		Assert.assertEquals(true, target.contains(nodeToDelete));
		target.delete(nodeToDelete);
		Assert.assertEquals(false, target.contains(nodeToDelete));
	}

	@Test
	public void test_delete_twoChildNode_inOrderSuccessorRight_success() {
		createTargetWithSixteenItems();
		int nodeToDelete = 16;
		int leftChild = 15;
		int rightChild = 23;
		Assert.assertEquals(true, target.contains(nodeToDelete));
		target.delete(nodeToDelete);
		Assert.assertEquals(false, target.contains(nodeToDelete));
		Assert.assertEquals(true, target.contains(leftChild));
		Assert.assertEquals(true, target.contains(rightChild));
	}
	
	@Test
	public void test_delete_twoChildNode_inOrderSuccessorLeft_success() {
		createTargetWithSixteenItems();
		int nodeToDelete = 40;
		int leftChild = 38;
		int rightChild = 43;
		Assert.assertEquals(true, target.contains(nodeToDelete));
		target.delete(nodeToDelete);
		Assert.assertEquals(false, target.contains(nodeToDelete));
		Assert.assertEquals(true, target.contains(leftChild));
		Assert.assertEquals(true, target.contains(rightChild));
	}

	@Test
	public void test_delete_oneChildRightNode_success() {
		createTargetWithSixteenItems();
		int nodeToDelete = 60;
		int child = 92;
		Assert.assertEquals(true, target.contains(nodeToDelete));
		target.delete(nodeToDelete);
		Assert.assertEquals(false, target.contains(nodeToDelete));
		Assert.assertEquals(true, target.contains(child));
	}

	@Test
	public void test_delete_oneChildLeftNode_success() {
		createTargetWithSixteenItems();
		int nodeToDelete = 8;
		int child = 6;
		Assert.assertEquals(true, target.contains(nodeToDelete));
		target.delete(nodeToDelete);
		Assert.assertEquals(false, target.contains(nodeToDelete));
		Assert.assertEquals(true, target.contains(child));
	}

	@Test
	public void test_contains_inputDoesNotExist() {
		target.insert(45);
		Assert.assertEquals(false, target.contains(10));
	}

	@Test
	public void test_contains_targetIsEmpty() {
		Assert.assertEquals(false, target.contains(10));
	}

	@Test
	public void test_contains_success() {
		target.insert(12);
		target.insert(22);
		target.insert(35);
		Assert.assertEquals(true, target.contains(12));
		Assert.assertEquals(false, target.contains(10));
	}

	@Test
	public void test_printInOrder_success() {
		target.insert(30);
		target.insert(20);
		target.insert(18);
		target.insert(40);
		target.printInOrder();
		Assert.assertEquals("18 20 30 40 ", outContent.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void test_printInOrder_targetIsEmpty() {
		target.printInOrder();
	}

	@Test
	public void test_printPreOrder_success() {
		target.insert(30);
		target.insert(20);
		target.insert(18);
		target.insert(40);
		target.printPreOrder();
		Assert.assertEquals("30 20 18 40 ", outContent.toString());

	}

	@Test(expected = IllegalStateException.class)
	public void test_printPreOrder_targetIsEmpty() {
		target.printPreOrder();
	}

	@Test
	public void test_printPostOrder_success() {
		target.insert(30);
		target.insert(20);
		target.insert(18);
		target.insert(40);
		target.printPostOrder();
		Assert.assertEquals("18 20 40 30 ", outContent.toString());

	}

	@Test(expected = IllegalStateException.class)
	public void test_printPostOrder_targetIsEmpty() {
		target.printPostOrder();
	}

	private void createTargetWithSixteenItems() {
		target.insert(30);
		target.insert(10);
		target.insert(45);
		target.insert(60);
		target.insert(8);
		target.insert(16);
		target.insert(40);
		target.insert(92);
		target.insert(23);
		target.insert(15);
		target.insert(6);
		target.insert(28);
		target.insert(12);
		target.insert(43);
		target.insert(38);
		target.insert(42);
	}

}
