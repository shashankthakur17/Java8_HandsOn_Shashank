package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

import datastructures.contracts.Stack;

public class ListStack<X> implements Stack<X> {
	
	List<X> data;
	int stackPointer;
	
	public ListStack() {
		data = new ArrayList<>();
		stackPointer = 0;
	}

	@Override
	public void push(X newItem) {
		data.add(stackPointer++, newItem);
	}

	@Override
	public X pop() {
		if (stackPointer == 0)
			throw new IllegalStateException("No more items on the Stack");
		return data.get(--stackPointer);
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (data.get(i).equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
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

	@Override
	public int size() {
		return stackPointer;
	}

}
