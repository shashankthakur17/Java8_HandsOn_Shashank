package datastructures.queue;

/*
 * CustomQueue class with inner Class Node backing our CustomQueue
 * */
public class CustomQueue {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; // we will remove from the head, it's a queue
    private Node tail; // we will add to the tail, again Queue

    // isEmpty()
    public boolean isEmpty() {
        return head == null;
    }

    // peek(){}
    // it will just return the data in head
    public  int peek(){
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    // add data
    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            //if Queue has data and its tail isn't null
            tail.next = node;
        }
        // update the tail
        tail = node;
        if (head == null){
            // If the queue is completely empty, its head will be null too
            // In this case
            head = node;
        }
    }
    // remove
    public int remove() {
        // we will remove from the head, it's a queue
        if (head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            // if head became null after above step
            // it means we removed the last element from queue, Hence tail should be null too
            tail = null;
        }
        return data;
    }

    public boolean contains(int data){
        if (head == null) {
            return false;
        }
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == data){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
}
