package collection.arraylist;

import java.util.Arrays;

public class ArrayListCustomImpl<X> {

	private static final int INITIAL_CAPACITY = 10;
	private int sizeOfList;
	private Object data[];

	public ArrayListCustomImpl() {
		this.data = new Object[INITIAL_CAPACITY];
		sizeOfList = 0;
	}

	public ArrayListCustomImpl(int customCapacity) {
		this.data = new Object[customCapacity];
		sizeOfList = 0;
	}

	// size
	private int size() {
		return this.sizeOfList;
	}

	// Add
	public void add(X item) {
		if ((size() != 0) && size() == data.length) {
			ensurecapacity();
		}
		data[sizeOfList] = item;
		sizeOfList++;
	}

	// ensure capacity
	private void ensurecapacity() {
		int newCapacity = data.length * 2;
		data = Arrays.copyOf(data, newCapacity);
	}

	// get At
	public X get(int index) {
		if (index < 0 || index >= sizeOfList) {
			throw new IndexOutOfBoundsException("index: " + index + ", Size " + index);
		}

		return (X) data[index];
	}

	// remove
	public X remove(int index) {
		if (index < 0 || index >= sizeOfList) {
			throw new IndexOutOfBoundsException("index: " + index + ", Size " + index);
		}

		X removedItem = (X) data[index];
		// perform item shifting
		for (int i = index; i < sizeOfList - 1; i++) {
			data[i] = data[i + 1];
		}
		sizeOfList--; // reduce the size
		return removedItem;
	}

	// Set
	// returns Old value
	public X set(int index, X item) {
		if (index < 0 || index >= sizeOfList) {
			throw new IndexOutOfBoundsException("index: " + index + ", Size " + index);
		}
		Object oldValue = data[index];
		data[index] = item;
		return (X) oldValue;
	}

	// print
	public void display() {
		System.out.print("Displaying list : ");
		for (int i = 0; i < sizeOfList; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
