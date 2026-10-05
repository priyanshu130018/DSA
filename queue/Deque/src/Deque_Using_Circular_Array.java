/**
 Approach: Deque Using Circular Array

 Time Complexity:
 - insertFront() : O(1)
 - insertRear()  : O(1)
 - deleteFront() : O(1)
 - deleteRear()  : O(1)
 - getFront()    : O(1)
 - getRear()     : O(1)
 - size()        : O(1)
 - isEmpty()     : O(1)
 - isFull()      : O(1)
 - display()     : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Deque_Using_Circular_Array {

    private final int[] arr;
    private int front, rear, size;

    public Deque_Using_Circular_Array(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Insert from rear
    public void insertRear(int val) {

        if (isFull()) {
            throw new IllegalStateException("Stack Overflow!");
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }

        arr[rear] = val;
        size++;
    }

    // Insert from front
    public void insertFront(int val) {

        if (isFull()) {
            throw new IllegalStateException("Stack Overflow!");
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + arr.length) % arr.length;
        }

        arr[front] = val;
        size++;
    }

    // Delete from front
    public int deleteFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        int data = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }

        size--;
        return data;
    }

    // Delete from rear
    public int deleteRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        int data = arr[rear];
        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + arr.length) % arr.length;
        }

        size--;
        return data;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        return arr[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        return arr[rear];
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

    // Display deque
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % arr.length;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Deque_Using_Circular_Array dq = new Deque_Using_Circular_Array(5);

        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertRear(30);
        System.out.print("Deque Using Circular Array: ");
        dq.display();

        System.out.println("Size:"+ dq.size());
        System.out.println("Front Element: " + dq.getFront());
        System.out.println("Rear Element: " + dq.getRear());
        System.out.println("Deleted Front: " + dq.deleteFront());
        dq.display();

        System.out.println("Deleted Rear: " + dq.deleteRear());
        dq.display();

        System.out.println("Is Empty: " + dq.isEmpty());
        System.out.println("Is Full: " + dq.isFull());
    }
}




