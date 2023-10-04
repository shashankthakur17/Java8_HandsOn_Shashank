package datastructures.queue.test.classes;

import datastructures.contracts.Queue;
import datastructures.queue.BasicQueue;

public class TestBasicQueue {
    public static void main(String[] args) {
        Queue<String> myQueue = new BasicQueue<>();

        myQueue.enQueue("Employee 1001");
        System.out.println("My Queue size = " + myQueue.size());
        myQueue.enQueue("Employee 2002");
        myQueue.enQueue("Employee 3003");
        myQueue.enQueue("Employee 4004");
        myQueue.enQueue("Employee 5005");

        System.out.println("My Queue size = " + myQueue.size());

        if (myQueue.contains("Employee 3003"))
            System.out.println("Yay! Employee Found");
        else System.out.println("Unable to find Employee !!!");

        System.out.println(myQueue.access(4));

        String frontElement = myQueue.deQueue();
        System.out.println("This Element just got deQueued = " + frontElement);
        System.out.println("My Queue size = " + myQueue.size());

        while (myQueue.size() > 0) {
            System.out.println("This Element just got deQueued = " + myQueue.deQueue());
        }

        // If I deQueue now, it will throw me an Error
        try {
            myQueue.deQueue();
        } catch (IllegalStateException e) {
            System.out.println("message from Exception: " + e.getMessage());
        }
    }

}
