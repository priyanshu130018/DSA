/**
 Approach: Stack Using Linked List

 Time Complexity:
 - push(): O(1)
 - pop(): O(1)
 - peek(): O(1)
 - size(): O(1)
 - isEmpty(): O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Stack_Using_LinkedList {

    private Node top;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert element
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove front element
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }

        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    // Get front element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Print
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }

        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Using_LinkedList s = new Stack_Using_LinkedList();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.print("Stack Using Linked List: ");
        s.display();

        System.out.println("Size: " + s.size());
        System.out.println("Top Element: " + s.peek());
        System.out.println("Pop Element: " + s.pop());
        s.display();
        System.out.println("Is Stack Empty? " + s.isEmpty());
    }
}
