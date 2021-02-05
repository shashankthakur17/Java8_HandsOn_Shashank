package datastructures.basics;

public class BasicBinaryTree<X extends Comparable<X>> {

	Node root;
	int size;

	public BasicBinaryTree() {
		this.root = null;
		size = 0;
	}

	public int size() {
		return this.size;
	}

	// ADD Node
	public void add(X newItem) {
		Node newNode = new Node(newItem);
		Node parent = this.root;

		if (parent == null) {
			this.root = newNode;
			size++;
		} else {
			// insert this new Node to the B tree using below Insert Algo
			insert(parent, newNode);
		}
	}

	private void insert(Node parent, Node child) {
		// first check for left from root, then check for right from root to insert Node
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			// if child is smaller to parent then find a place on Left-subtree & insert
			if (parent.getLeft() == null) { // we found a place to insert child Node
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			} else {
				// else we have encountered an existing node, make this node Parent and repeat
				insert(parent.getLeft(), child);
			}
		} else if (child.getItem().compareTo(parent.getItem()) > 0) {
			// if child is greater to parent then find a place on Right-subtree
			if (parent.getRight() == null) { // we found a place to insert child Node
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			} else {
				// else we have encountered an existing node, make this node Parent and repeat
				insert(parent.getRight(), child);
			}

		} else {
			System.out.println("We found a duplicate Node/Element to be inserted");
		}
	}

	public boolean contains(X item) {
		boolean flag = false;

		if (this.root == null)
			return flag;
		else {
			flag = find(root, item);
		}

		return flag;
	}

	private boolean find(Node parent, X item) {
		boolean flag = false;
		if (parent == null) {	// while recursion if there is no Node left to compare
			return false;
		} else if (parent.getItem().compareTo(item) == 0) {
			return true;
		} else if (item.compareTo(parent.getItem()) < 0) {
			flag = find(parent.getLeft(), item);
		} else if (item.compareTo(parent.getItem()) > 0) {
			flag = find(parent.getRight(), item);
		}
		return flag;
	}

	public Node get(X item) {
		return getNode(item);
	}

	// Non-recursive way of B-Tree traversal
	private Node getNode(X item) {

		Node currentNode = this.root;
		while (currentNode != null) {
			int value = item.compareTo(currentNode.getItem());
			if (value == 0) { // if the item and currentNode item matched
				return currentNode;
			} else if (value < 0) { // if the value is lessThan 0 we have to traverse left of the tree
				currentNode = currentNode.getLeft();
			} else { // Else we have to traverse right of the Tree
				currentNode = currentNode.getRight();
			}
		}

		return null; // null, in case of item isn't present in the Tree or the Tree is empty
	}
	
	// This method mainly calls InorderRec()
    public void inorder() { inOrderTraverse(root); }
	
    // A utility function to do inOrder traversal of BST
	private void inOrderTraverse(Node root) {
		if(root != null) {
			inOrderTraverse(root.getLeft());
			System.out.print(root.getItem() + "\t" );
			inOrderTraverse(root.getRight());
		}
	}


	private class Node {
		private X item;
		private Node left;
		private Node right;
		private Node parent;

		public Node(X item) {
			super();
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
			;
		}

		public X getItem() {
			return item;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (item == null) {
				if (other.item != null)
					return false;
			} else if (!item.equals(other.item))
				return false;
			return true;
		}

		private BasicBinaryTree getEnclosingInstance() {
			return BasicBinaryTree.this;
		}

	}
}
