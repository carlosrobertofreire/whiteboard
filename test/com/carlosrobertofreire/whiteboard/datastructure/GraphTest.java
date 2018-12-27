package com.carlosrobertofreire.whiteboard.datastructure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	Graph target = null;

	private PrintStream sysOut;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		sysOut = System.out;
		System.setOut(new PrintStream(outContent));
	}

	@Before
	public void setUp() throws Exception {
		target = new Graph();
	}

	@After
	public void revertStreams() {
		System.setOut(sysOut);
	}

	@Test
	public void test_addNode_success() {
		int firstValue = 7;
		target.addNode(firstValue);
		Assert.assertEquals(true, target.contains(firstValue));

		for (int i = 1; i < 20; i++) {
			target.addNode(firstValue + i);
		}

		Assert.assertEquals(true, target.contains(firstValue + 19));
		Assert.assertEquals(false, target.contains(firstValue + 21));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addNode_duplicatedValue() {
		int firstValue = 7;
		target.addNode(firstValue);
		target.addNode(firstValue);
	}

	@Test
	public void test_addEdge_success() {
		for (int i = 1; i < 600; i++) {
			target.addNode(i);
		}
		for (int i = 2; i < 300; i++) {
			target.addEdge(2, i + 1);
		}
		Assert.assertEquals(true, target.hasEdge(2, 182));
		Assert.assertEquals(false, target.hasEdge(3, 100));
	}

	@Test
	public void test_addEdge_duplicatedValues_success() {
		int[] newNodes = new int[] { 30, 110, 218 };
		for (int i = 0; i < newNodes.length; i++) {
			target.addNode(newNodes[i]);
		}
		target.addEdge(newNodes[1], newNodes[2]);
		target.addEdge(newNodes[1], newNodes[2]);
		target.addEdge(newNodes[0], newNodes[2]);
		Assert.assertEquals(true, target.hasEdge(newNodes[1], newNodes[2]));
		Assert.assertEquals(false, target.hasEdge(newNodes[2], newNodes[2]));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addEdge_targetIsEmpty() {
		target.addEdge(5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addEdge_inputsAreInvalid() {
		target.addNode(2);
		target.addNode(10);
		target.addEdge(2, 23);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addEdge_inputsDoesNotExist() {
		target.addEdge(100, 2);
	}

	@Test
	public void test_removeNode_success() {
		for (int i = 1; i < 1000; i++) {
			target.addNode(i);
		}
		target.addEdge(3, 151);
		target.addEdge(5, 10);
		target.addEdge(950, 882);
		for (int i = 1; i < 800; i++) {
			target.removeNode(i);
		}
		Assert.assertEquals(false, target.contains(5));
		Assert.assertEquals(true, target.contains(950));
		Assert.assertEquals(true, target.hasEdge(950, 882));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_removeNode_targetIsEmpty() {
		target.removeNode(10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_removeNode_inputIsInvalid() {
		target.addNode(20);
		target.addNode(12);
		target.removeNode(30);
	}

	@Test
	public void test_removeEdge_success() {
		int[] newNodes = new int[] { 2, 7, 118, 1, 3 };
		for (int i = 0; i < newNodes.length; i++) {
			target.addNode(newNodes[i]);
		}
		target.addEdge(newNodes[1], newNodes[4]);
		target.addEdge(newNodes[0], newNodes[2]);
		Assert.assertEquals(true, target.hasEdge(newNodes[1], newNodes[4]));
		target.removeEdge(newNodes[1], newNodes[4]);
		Assert.assertEquals(false, target.hasEdge(newNodes[1], newNodes[4]));
		Assert.assertEquals(true, target.hasEdge(newNodes[0], newNodes[2]));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_removeEdge_targetIsEmpty() {
		target.removeEdge(2, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_removeEdge_inputsAreInvalid() {
		target.addNode(2);
		target.addNode(30);
		target.addNode(15);
		target.addEdge(2, 30);
		target.removeEdge(2, 15);
		target.removeEdge(1, 15);
	}

	@Test
	public void test_contains_success() {
		target.addNode(21);
		target.addNode(11);
		Assert.assertEquals(false, target.contains(23));
		Assert.assertEquals(true, target.contains(11));
		target.removeNode(11);
		Assert.assertEquals(false, target.contains(11));
	}

	@Test
	public void test_hasEdge_success() {
		for (int i = 1; i < 100; i++) {
			target.addNode(i);
		}

		for (int i = 1; i < 100; i++) {
			for (int k = i + 1; k < 99; k++) {
				target.addEdge(i, k + 1);
			}
		}
		Assert.assertEquals(true, target.hasEdge(5, 7));
		Assert.assertEquals(true, target.hasEdge(15, 19));
		Assert.assertEquals(false, target.hasEdge(5, 6));
		Assert.assertEquals(false, target.hasEdge(5, 5));

		for (int i = 1; i < 100; i++) {
			for (int k = i + 1; k < 99; k++) {
				target.removeEdge(i, k + 1);
			}
		}

		Assert.assertEquals(false, target.hasEdge(5, 7));
		Assert.assertEquals(false, target.hasEdge(15, 19));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasEdge_inputsAreInvalid() {
		target.hasEdge(5, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_printDFS_inputDoesNotExist() {
		target.addNode(10);
		target.printDFS(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_printDFS_targetIsEmpty() {
		target.printDFS(3);
	}

	@Test
	public void test_printDFS_connectedTarget_success() {
		createConnectedGraph();
		target.printDFS(1);
		Assert.assertEquals("1 2 4 5 6 3 ", outContent.toString());
	}

	@Test
	public void test_printDFS_notConnectedTarget_success() {
		createNotConnectedGraph();
		target.printDFS(10);
		Assert.assertEquals("10 1 3 2 ", outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_printBFS_inputDoesNotExist() {
		target.addNode(10);
		target.printBFS(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_printBFS_targetIsEmpty() {
		target.printDFS(3);
	}

	@Test
	public void test_printBFS_connectedTarget_success() {
		createConnectedGraph();
		target.printBFS(1);
		Assert.assertEquals("1 2 3 4 5 6 ", outContent.toString());
	}

	@Test
	public void test_printBFS_notConnectedTarget_success() {
		createNotConnectedGraph();
		target.printBFS(10);
		Assert.assertEquals("10 1 2 3 ", outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathDFS_inputsAreInvalid() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathDFS(5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathDFS_targetIsEmpty() {
		target.hasPathDFS(5, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathDFS_sourceDoesNotExist() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathDFS(5, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathDFS_destinationDoesNotExist() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathDFS(2, 8);
	}

	@Test
	public void test_hasPathDFS_connectedTarget_success() {
		createConnectedGraph();
		Assert.assertEquals(true, target.hasPathDFS(1, 3));
		Assert.assertEquals("Visited: 1 2 4 5 6 3 ", outContent.toString());
	}

	@Test
	public void test_hasPathDFS_notConnectedTarget_success() {
		createNotConnectedGraph();
		Assert.assertEquals(true, target.hasPathDFS(1, 3));
		Assert.assertEquals("Visited: 1 10 2 3 ", outContent.toString());
		Assert.assertEquals(false, target.hasPathDFS(1, 6));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathBFS_inputsAreInvalid() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathBFS(5, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathBFS_targetIsEmpty() {
		target.hasPathBFS(5, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathBFS_sourceDoesNotExist() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathBFS(5, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasPathBFS_destinationDoesNotExist() {
		target.addNode(2);
		target.addNode(7);
		target.hasPathBFS(2, 8);
	}

	@Test
	public void test_hasPathBFS_connectedTarget_success() {
		createConnectedGraph();
		Assert.assertEquals(true, target.hasPathBFS(1, 3));
		Assert.assertEquals("Visited: 1 2 3 ", outContent.toString());
	}

	@Test
	public void test_hasPathBFS_notConnectedTarget_success() {
		createNotConnectedGraph();
		Assert.assertEquals(true, target.hasPathBFS(1, 3));
		Assert.assertEquals("Visited: 1 10 3 ", outContent.toString());
		Assert.assertEquals(false, target.hasPathBFS(1, 6));
	}

	private void createNotConnectedGraph() {
		target.addNode(10);
		target.addNode(1);
		target.addNode(2);
		target.addNode(3);
		target.addNode(4);
		target.addNode(5);
		target.addNode(6);

		target.addEdge(10, 1);
		target.addEdge(10, 2);
		target.addEdge(1, 3);
		target.addEdge(1, 2);
		target.addEdge(4, 5);
		target.addEdge(4, 6);
		target.addEdge(5, 6);
	}

	private void createConnectedGraph() {
		target.addNode(1);
		target.addNode(2);
		target.addNode(3);
		target.addNode(4);
		target.addNode(5);
		target.addNode(6);

		target.addEdge(1, 2);
		target.addEdge(1, 3);
		target.addEdge(2, 4);
		target.addEdge(2, 5);
		target.addEdge(4, 5);
		target.addEdge(4, 6);
		target.addEdge(5, 6);
		target.addEdge(5, 3);
	}

}
