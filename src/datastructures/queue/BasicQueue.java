package datastructures.queue;

import datastructures.contracts.Queue;

public class BasicQueue<X> implements Queue<X> {

	private X data[];
	private int front;
	private int end;

	public BasicQueue() {
		this(30);
	}

	@SuppressWarnings("unchecked")
	public BasicQueue(int size) {
		data = (X[]) new Object[size];
		front = -1;
		end = -1;
	}

	public int size() {
		// if the queue is empty then return size = 0
		if (front == -1 && end == -1)
			return 0;
		else
			// else queue isn't empty. calc the diff in front and end, add one to make it
			// inclusive
			return end - front + 1;
	}

// enqueue or insert method
	public void enQueue(X item) {

		//
		if (((end + 1) % data.length) == front) {
			throw new IllegalStateException("The Queue is full !");
		}
		// if size is zero, means we are inserting 1st element to the queue
		else if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		}
		// normal case, where an element is added to the end of the queue
		else {
			end++;
			data[end] = item;
		}
	}

// dequeue or delete method
	public X deQueue() {
		X tempItem;
		// if size is 0, means there is no item in the queue for dequeue
		if (size() == 0) {
			throw new IllegalStateException("The queue is already empty !");
		}
		// if front == end, means we have last element in the queue, after deququeing it
		// queue will be initialized
		else if (end == front) {
			tempItem = data[front];
			data[front] = null; // to free up some space in the array for GC
			front = -1;
			end = -1;
		}
		// normal case, grab the element at front and increment front to next element
		else {
			tempItem = data[front];
			data[front] = null; // to free up some space in the array for GC
			front++;
		}
		return tempItem;
	}

// Contains method
	public boolean contains(X item) {
		boolean found = false;

		if (size() == 0) {
			throw new IllegalStateException("The queue is already empty !");
		}

		// else normal scenario
		for (int i = front; i <= end; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public X access(int position) {
		if (size() == 0 || position > size()) {
			throw new IllegalArgumentException(
					"No items in the queue or the position is grater than the elements in queue");
		}

		int trueIndex = 1;
		for (int i = front; i <= end; i++) {
			if (trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}

		throw new IllegalArgumentException("Could not find any item in position: " + position);
	}

}