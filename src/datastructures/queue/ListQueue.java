package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

import datastructures.contracts.Queue;

public class ListQueue<X> implements Queue<X> {

	private List<X> data;
	private int front;
	private int end;

	public ListQueue() {
		data = new ArrayList<>();
		front = -1;
		end = -1;
	}

	@Override
	public void enQueue(X item) {
		if (size() == 0) { //first element to be inserted 
			front++;
			end++;
			data.add(end, item);
		} else {			// add a element in regular way at end of queue
			end++;
			data.add(end, item);
		}

	}

	@Override
	public X deQueue() {
		X tempItem;
		if(size()==0) {
			throw new IllegalStateException("The queue has no elements to Dequeue !");
		}
		else if(front == end) {			// Last element in the queue to be deQueued' 
			tempItem = data.get(front);
			data.set(front, null);
			front = -1;
			end = -1;
		}
		else {							// Regular way to deQueue
			tempItem = data.get(front);
			data.set(front, null);
			front++;
		}
		return tempItem;
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		
		if (size() == 0) {
			throw new IllegalStateException("The queue is already empty !");
		}
		for (int i = front; i <= end; i++) {
			if (data.get(i).equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
	public X access(int position) {
		if (size() == 0) {
			throw new IllegalStateException("The queue is already empty !");
		}
		int trueIndex = 1;
		for (int i = front; i <= end; i++) {
			if (trueIndex == position) {
				return data.get(i);
			}
			trueIndex++;
		}
		throw new IllegalArgumentException("Could not find any item in position: " + position);
	}

	@Override
	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}

}
