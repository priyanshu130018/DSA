/**
 Approach: Queue Using Linked List

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

public class Queue_Using_LinkedList {

    private Node front, rear;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert element
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove front element
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Get front element
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow!");
        }

        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Print
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Queue_Using_LinkedList queue = new Queue_Using_LinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.print("Queue Using Linked List: ");
        queue.display();

        System.out.println("Size: " + queue.size());
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
        System.out.println("Is Empty: " + queue.isEmpty());
    }
}