/**
 Approach: Priority Queue Using Linked List

 Time Complexity:
 - enqueue() : O(n)
 - dequeue() : O(1)
 - peek()    : O(1)
 - size()    : O(1)
 - isEmpty() : O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Priority_Queue_Using_Linked_List {

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public static class Node {
        int data;
        int priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    // Insert element based on priority
    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        // Empty queue
        if (isEmpty()) {
            front = rear = newNode;
            size++;
            return;
        }

        // Insert at front
        if (priority < front.priority) {
            newNode.next = front;
            front = newNode;
            size++;
            return;
        }

        // Find correct position
        Node temp = front;
        while (temp.next != null && temp.next.priority <= priority) {
            temp = temp.next;
        }

        // Insert node
        newNode.next = temp.next;
        temp.next = newNode;

        // Update rear if inserted at the end
        if (newNode.next == null) {
            rear = newNode;
        }

        size++;
    }

    // Remove highest priority element
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        int value = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    // Get highest priority element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        return front.data;
    }

    // Current size
    public int size() {
        return size;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data + " (priority: " + temp.priority + ")");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Priority_Queue_Using_Linked_List pq = new Priority_Queue_Using_Linked_List();

        pq.enqueue(10, 3);
        pq.enqueue(25, 1);
        pq.enqueue(17, 2);
        pq.enqueue(50, 2);
        pq.enqueue(30, 5);

        System.out.println("Priority Queue: ");
        pq.display();

        System.out.println("Size: " + pq.size());
        System.out.println("Front Element: " + pq.peek());
        System.out.println("Dequeued: " + pq.dequeue());
        pq.display();

        System.out.println("Is Empty: " + pq.isEmpty());
    }
}