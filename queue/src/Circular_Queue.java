/**
 Circular Queue

 Time Complexity:
 - enqueue() : O(1)
 - dequeue() : O(1)
 - peek()    : O(1)
 - size()    : O(1)
 - isEmpty() : O(1)

 Space Complexity: O(n)
 */

import java.util.*;

public class Circular_Queue {
    private final int[] arr;
    private int front, rear, size;

    public Circular_Queue(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public int size() {
        return size;
    }

    // Insert element
    public void enqueue(int val) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow!");
        }

        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = val;
        size++;
    }

    // Remove front element
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        int data = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }
        size--;
        return data;
    }

    // Get front element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }
        return arr[front];
    }

    // Print
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");

            if (i == rear) break;
            i = (i + 1) % arr.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Circular_Queue cq = new Circular_Queue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        System.out.println("Circular Queue: ");
        cq.display();

        System.out.println("Size: " + cq.size());
        System.out.println("Front: " + cq.peek());
        System.out.println("Dequeued: " + cq.dequeue());
        System.out.println("Dequeued: " + cq.dequeue());
        cq.display();

        System.out.println("Is Empty: " + cq.isEmpty());
        System.out.println("Is Full: " + cq.isFull());
    }
}

