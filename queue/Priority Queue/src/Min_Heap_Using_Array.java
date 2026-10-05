/**
 Approach: Min Heap Using Array

 Time Complexity:
 - insert()    : O(log n)
 - remove()    : O(log n)
 - peek()      : O(1)
 - size()      : O(1)
 - isEmpty()   : O(1)
 - display()   : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Min_Heap_Using_Array {

    private final int[] heap;
    private int size;

    public Min_Heap_Using_Array(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    // Current size
    public int size() {
        return size;
    }

    // Insert element
    public void insert(int value) {

        if (isFull()) {
            throw new IllegalStateException("Heap is full!");
        }

        heap[size] = value;

        int current = size;

        while (current > 0) {

            int parent = (current - 1) / 2;

            if (heap[parent] <= heap[current]) {
                break;
            }

            swap(parent, current);
            current = parent;
        }

        size++;
    }

    // Get minimum element
    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty!");
        }

        return heap[0];
    }

    // Remove minimum element
    public int remove() {

        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty!");
        }

        int min = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return min;
    }

    // Heapify Down
    private void heapifyDown(int current) {

        while (true) {

            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int smallest = current;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == current) {
                break;
            }

            swap(current, smallest);
            current = smallest;
        }
    }

    // Swap two elements
    private void swap(int i, int j) {

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Display heap
    public void display() {

        if (isEmpty()) {
            System.out.println("Heap is empty!");
            return;
        }

        System.out.print("Heap: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Min_Heap_Using_Array heap = new Min_Heap_Using_Array(10);

        heap.insert(40);
        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(50);
        heap.insert(5);

        heap.display();

        System.out.println("Minimum: " + heap.peek());

        System.out.println("Removed: " + heap.remove());

        heap.display();

        System.out.println("Size: " + heap.size());

        System.out.println("Is Empty: " + heap.isEmpty());
    }
}
