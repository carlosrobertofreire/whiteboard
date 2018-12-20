package com.carlosrobertofreire.whiteboard.datastructure;

public class Graph {

	private static int INITIAL_CAPACITY = 10;

	class Node {
		int value;
		Node[] children;
		private int childrenSize;

		public Node(int value) {
			this.value = value;
			this.children = new Node[INITIAL_CAPACITY];
		}

		public void addChild(Node newChild) {
			if (isAdjacency(newChild.value)) {
				return;
			}
			children = ensureDynamicCapacity(children, childrenSize);
			children[childrenSize] = newChild;
			childrenSize++;
		}

		public boolean isAdjacency(int value) {
			for (int i = 0; i < childrenSize; i++) {
				if (children[i].value == value) {
					return true;
				}
			}
			return false;
		}

		public void removeAdjacency(int value) {
			int index = getIndex(children, value);
			if (index != childrenSize - 1) {
				for (int i = index; i < childrenSize - 1; i++) {
					children[i] = children[i + 1];
				}
			}
			children[childrenSize - 1] = null;
			childrenSize--;
			children = ensureDynamicCapacity(children, childrenSize);
		}

	}

	private Node[] nodes;

	private int size;

	private boolean isDirected;

	public Graph() {
		this.nodes = new Node[INITIAL_CAPACITY];
		this.isDirected = false;
	}

	public Graph(boolean isDirected) {
		super();
		this.isDirected = isDirected;
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	public void addNode(int value) {
		if (contains(value)) {
			throw new IllegalArgumentException("Node already exists!");
		}
		nodes = ensureDynamicCapacity(nodes, size);
		nodes[size] = new Node(value);
		size++;
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	public void addEdge(int source, int destination) {
		Node sourceNode = find(source);
		Node destinationNode = find(destination);
		if (sourceNode == null || destinationNode == null) {
			throw new IllegalArgumentException("Source or destination not exist in the Graph");
		}
		sourceNode.addChild(destinationNode);
		if (!isDirected) {
			destinationNode.addChild(sourceNode);
		}
	}

	/*
	 * O(V + E), where V = Number of Vertices (Nodes) and E = Number of Edges
	 */
	public void removeNode(int value) {
		if (!contains(value)) {
			throw new IllegalArgumentException("Node does not exist in the Graph!");
		}
		int index = getIndex(nodes, value);
		if (index != size - 1) {
			for (int i = index; i < size - 1; i++) {
				nodes[i] = nodes[i + 1];
			}
		}
		nodes[size - 1] = null;
		size--;
		nodes = ensureDynamicCapacity(nodes, size);
		for (int i = 0; i < size; i++) {
			removeEdge(nodes[i].value, value);
		}
	}

	/*
	 * O(V + D), where V = Number of Vertices (Nodes) and D = Degree
	 */
	public void removeEdge(int source, int destination) {
		Node sourceNode = find(source);
		if (sourceNode.isAdjacency(destination)) {
			sourceNode.removeAdjacency(destination);
		}
		if (!isDirected) {
			if (contains(destination)) {
				Node destinationNode = find(destination);
				if (destinationNode.isAdjacency(source)) {
					destinationNode.removeAdjacency(source);
				}
			}
		}
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	public boolean contains(int value) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null && nodes[i].value == value) {
				return true;
			}
		}
		return false;
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	private Node find(int value) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null && nodes[i].value == value) {
				return nodes[i];
			}
		}
		throw new IllegalArgumentException("Node does not exist in the Graph");
	}

	/*
	 * O(V + E), where V = Number of Vertices (Nodes) and E = Number of Edges
	 */
	public boolean hasEdge(int source, int destination) {
		Node nodeSource = find(source);
		if (nodeSource.isAdjacency(destination)) {
			return true;
		}
		if (isDirected) {
			return false;
		} else {
			Node nodeDestination = find(destination);
			return nodeDestination.isAdjacency(source);
		}
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	private static int getIndex(Node[] nodes, int value) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].value == value) {
				return i;
			}
		}
		throw new IllegalArgumentException("Value does not exist in the Graph!");
	}

	/*
	 * O(V), where V = Number of Vertices (Nodes)
	 */
	private static Node[] ensureDynamicCapacity(Node[] nodes, int currentSize) {
		if (currentSize == nodes.length) {
			return resizeArray(nodes, currentSize, nodes.length * 2);
		} else if (currentSize <= nodes.length / 4) {
			return resizeArray(nodes, currentSize, nodes.length / 2);
		}
		return nodes;
	}

	private static Node[] resizeArray(Node[] nodes, int currentSize, int newCapacity) {
		Node[] newArray = new Node[newCapacity];
		for (int i = 0; i < currentSize; i++) {
			newArray[i] = nodes[i];
		}
		return newArray;

	}

}