package datastructures.stack;

public class CustomStack {

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    // We just need head for Stack implementation
    private Node head;

    // isEmpty
    // peek
    // push
    // pop
    // contains

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            // 1st element of the stack
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public int pop(){
        if (head == null){
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public boolean contains(int data){
        if (head == null){
            return false;
        }
        Node tempNode = head;
        while(tempNode != null) {
            if (tempNode.data == data){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
}
