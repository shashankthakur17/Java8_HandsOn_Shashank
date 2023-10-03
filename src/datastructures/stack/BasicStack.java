package datastructures.stack;

import datastructures.contracts.Stack;

//Class BasicStack with generic type Data
public class BasicStack<X> implements Stack<X> {

	private X[] data;
	private int stackPointer;

	// Constructor initializing the data
	public BasicStack() {
		data = (X[]) new Object[100];
		stackPointer = 0;
	}

	public void push(X newItem) {
		data[stackPointer++] = newItem;
	}

	public X pop() {
		if (stackPointer == 0)
			throw new IllegalStateException("No more items on the Stack");
		return data[--stackPointer];
	}

	public boolean contains(X item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (data[i] == item) {
				found = true;
				break;
			}
		}
		return found;
	}

	// To access you have to pop the items above the required item
	public X access(X item) {
		while (stackPointer > 0) {
			X tempItem = pop();
			if (tempItem.equals(item)) {
				return item;
			}
		}

		// if we didn't find an item in the stack throw an exception
		throw new IllegalStateException("Could not find item on the Stack" + item);
	}
	
	public int size() {
		return stackPointer;
	}

}