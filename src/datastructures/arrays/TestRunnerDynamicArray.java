package datastructures.arrays;

public class TestRunnerDynamicArray {

    public static void main(String[] args) {
        DynamicResizableArray dynamicArray = new DynamicResizableArray(10);
        dynamicArray.pushback(2);
        dynamicArray.pushback(1);
        dynamicArray.pushback(6);
        dynamicArray.pushback(14);

        dynamicArray.printArray();
        System.out.println("Array Capacity = " + dynamicArray.getCapacity());
        dynamicArray.insert(3, 42);
        dynamicArray.printArray();
        System.out.println("Popped last element = " + dynamicArray.popback());
    }
}
