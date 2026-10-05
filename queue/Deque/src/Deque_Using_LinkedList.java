/**
 Approach: Deque Using Linked List

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

public class Deque_Using_LinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Current size
    public int size() {
        return size;
    }

    // Insert at front
    public void insertFront(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    // Insert at rear
    public void insertRear(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;
    }

    // Delete from front
    public int deleteFront() {

        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }

        int data = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
        return data;
    }

    // Delete from rear
    public int deleteRear() {

        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }

        int data = rear.data;

        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
        return data;
    }

    // Get front element
    public int getFront() {

        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }

        return front.data;
    }

    // Get rear element
    public int getRear() {

        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }

        return rear.data;
    }

    // Display deque
    public void display() {

        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }

        System.out.print("Deque: ");

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Deque_Using_LinkedList dq = new Deque_Using_LinkedList();

        dq.insertRear(20);
        dq.insertRear(30);
        dq.insertFront(10);
        dq.insertFront(5);
        System.out.print("Deque Using Circular Array: ");
        dq.display();

        System.out.println("Front: " + dq.getFront());
        System.out.println("Rear: " + dq.getRear());
        System.out.println("Delete Front: " + dq.deleteFront());
        dq.display();
        System.out.println("Delete Rear: " + dq.deleteRear());
        dq.display();
        System.out.println("Is Empty: " + dq.isEmpty());

    }
}