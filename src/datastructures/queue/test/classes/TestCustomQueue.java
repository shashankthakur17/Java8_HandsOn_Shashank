package datastructures.queue.test.classes;

import datastructures.queue.CustomQueue;

public class TestCustomQueue {
    public static void main(String[] args) {
        CustomQueue myQueue = new CustomQueue();

        System.out.println("Check if the queue is empty now = " + myQueue.isEmpty());
        myQueue.add(44);
        myQueue.add(55);
        myQueue.add(77);
        myQueue.add(22);
        myQueue.add(99);

        System.out.println("Element first in myQueue, to be served = " + myQueue.peek());
        System.out.println("Check if the queue is empty now = " + myQueue.isEmpty());

        System.out.println("Element removed from the queue = " + myQueue.remove());
        System.out.println("Does the queue contains 44 = "+myQueue.contains(44));
        System.out.println("Does the queue contains 77 = "+myQueue.contains(77));
    }
}
