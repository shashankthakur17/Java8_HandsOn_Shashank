package datastructures.basics;

public class BasicLinkedList<X> {

	private Node first;
	private Node last;
	int nodeCount;

	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public int size() {
		return this.nodeCount;
	}

	public void add(X newItem) {
		// if the LList is empty and we are adding a node for the first time
		if (last == null) {
			last = new Node(newItem);
			first = last;
		}
		// add the node at the last/end of the list
		else {
			Node newLastNode = new Node(newItem);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	public void insert(X newItem, int position) {
		// if insert is called on empty LList then simply add
		// if position > size() then simply call add method, this will add item to last
		if (first == null || position > size()) {
			add(newItem);
		}

		// else insert in a regular way
		Node currentNode = first;
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode(); // jump to next node
		}

		// Using for loop, we have reached position asked to insert (Except First)
		Node nextNode = currentNode.getNextNode(); // Create temp Node to refer nextNode of current
		Node newNode = new Node(newItem); // Create a new Node
		newNode.setNextNode(nextNode); // Point newNode's nextNode to Currents' NextNode
		currentNode.setNextNode(newNode); // Point Currents' nextNode to NewNode

		nodeCount++;
	}

	public X remove() {
		// the list is already null then raise eception while remove attempt
		if (first == null) {
			throw new IllegalStateException("The List is already empty! No items to retrieve.");
		}
		// remove the node from the start/head of the list, update the first of the list
		Node tempNode = first;
		first = first.getNextNode();
		nodeCount--;
		return tempNode.item;
	}

	public X removeAt(int position) {
		// the list is already null then raise exception while remove attempt
		if (first == null) {
			throw new IllegalStateException("The List is already empty! No items to retrieve.");
		}
		if (position > size()) {
			throw new IllegalStateException("The List size is less than the position given !");
		}

		// else remove in a regular way
		Node currentNode = first;
		Node previousNode = first;
		for (int i = 1; i < position && currentNode != null; i++) { // Start at 1, because we are at 1 already
			previousNode = currentNode; // Point to previous Node
			currentNode = currentNode.getNextNode(); // jump to next node
		}

		X item = currentNode.getItem();
		previousNode.setNextNode(currentNode.getNextNode()); //unlink
		nodeCount--;

		return item;
	}

	public boolean find(X item) {
		if (first == null) {
			throw new IllegalStateException("The List is already empty! No items to retrieve.");
		}

		boolean flag = false;
		Node currentNode = first;
		for (int i = 1; i <= size() && currentNode != null; i++) { // Start at 1, because we are at 1 already
			if(currentNode.getItem().equals(item)) {
				flag = true; // Item exists
			}
			currentNode = currentNode.getNextNode(); // jump to next node
		}

		return flag;
	}

	public X get(int position) {
		if (first == null) {
			throw new IllegalStateException("The List is already empty! No items to retrieve.");
		}
		if (position > size()) {
			throw new IllegalStateException("The List size is less than the position given !");
		}

		Node currentNode = first;
		for (int i = 1; i <= size() && currentNode != null; i++) { // Start at 1, because we are at 1 already
			if (i == position) {
				return currentNode.getItem();
			}
			currentNode = currentNode.getNextNode(); // jump to next node
		}

		return null;
	}
	
	public String toString() {
		StringBuffer contents = new StringBuffer();
		
		Node currentNode = first;
		while(currentNode != null) {
			contents.append(currentNode.getItem()).append(", ");
			currentNode = currentNode.getNextNode();
		}
		return contents.toString();
	}

	private class Node {
		private X item;
		private Node nextNode;

		public Node(X item) {
			this.item = item;
			this.nextNode = null;
		}

		public X getItem() {
			return item;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	}
}
