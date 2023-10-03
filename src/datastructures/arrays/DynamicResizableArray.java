package datastructures.arrays;

public class DynamicResizableArray {
    private int[] arr;
    private int length;
    private int capacity;

    public DynamicResizableArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    // Insert n in the last position of the array
    public void insert(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    // Remove the last element in the array
    public int popback() {
        if (length > 0) {
            // soft delete the last element
            length--;
        }
        return arr[length];
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];
        if (length >= 0) System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("] \n");
    }
}
