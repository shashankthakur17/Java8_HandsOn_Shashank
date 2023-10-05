package datastructures.stack.test.classes;

import datastructures.stack.CustomStack;

public class TestCustomStack {
    public static void main(String[] args) {
        CustomStack myStack = new CustomStack();

        System.out.println("Check if the queue is empty now = " + myStack.isEmpty());
        myStack.push(44);
        myStack.push(55);
        myStack.push(77);
        myStack.push(22);
        myStack.push(99);

        System.out.println("Element first in myQueue, to be served = " + myStack.peek());
        System.out.println("Check if the queue is empty now = " + myStack.isEmpty());

        System.out.println("Element removed from the queue = " + myStack.pop());
        System.out.println("Does the queue contains 44 = "+myStack.contains(44));
        System.out.println("Does the queue contains 77 = "+myStack.contains(77));
        System.out.println("Does the queue contains 77 = "+myStack.contains(99));
    }

}
