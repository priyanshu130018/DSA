/**
 Approach: Queue Using Array (Linear Queue)

 Time Complexity:
 - enqueue() : O(1)
 - dequeue() : O(1)
 - peek()    : O(1)
 - size()    : O(1)
 - isEmpty() : O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Queue_Using_Array {

    private final int[] arr;
    private int front, rear, size;

    public Queue_Using_Array(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert element
    public void enqueue(int data) {
        if (size == arr.length) {
            throw new IllegalStateException("Queue Overflow!");
        }

        arr[++rear] = data;
        size++;
    }

    // Remove front element
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        int value = arr[front++];
        size--;

        return value;
    }

    // Get front element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        return arr[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Print
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Queue_Using_Array queue = new Queue_Using_Array(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.print("Queue Using Array: ");
        queue.display();

        System.out.println("Size: " + queue.size());
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Dequeue Element: " + queue.dequeue());
        System.out.print("After Dequeue: ");
        queue.display();
        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}