package datastructures.stack.problems;


// https://leetcode.com/problems/min-stack/description/
public class MinStack {

    private static class Node {
        private int data;
        private int minVal;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.minVal = data;
        }
    }

    private Node head;


    //initializes the stack object.
    public MinStack() {
        this.head = null;
    }

    // pushes the element val onto the stack
    public void push(int val) {

        if (head == null) {
            // 1st element of the stack
            head = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.minVal = Math.min(head.minVal, newNode.minVal);
        newNode.next = head;
        head = newNode;
    }

    // removes the element on the top of the stack.
    public void pop() {
        head = head.next;
    }

    // gets the top element of the stack.
    public int top() {
        return head.data;
    }

    // retrieves the minimum element in the stack.
    public int getMin() {
        return head.minVal;
    }
}