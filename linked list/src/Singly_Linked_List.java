/**
 Singly Linked List

 Time Complexity:
 - insertAtBeginning()  : O(1)
 - insertAtEnd()        : O(n)
 - insertAtPosition()   : O(n)

 - deleteFromBeginning(): O(1)
 - deleteFromEnd()      : O(n)
 - deleteFromPosition() : O(n)

 - search()             : O(n)

 - get()                : O(n)
 - getFirst()           : O(1)
 - getLast()            : O(n)

 - update()             : O(n)

 - reverse()            : O(n)
 - reverseRecursive()   : O(n)

 - display()            : O(n)
 - size()               : O(1)
 - isEmpty()            : O(1)

 Space Complexity: O(n)
 */

import java.util.*;

public class Singly_Linked_List {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    private Node head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }



    // Insert at beginning
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        size++;
    }

    // Insert at end
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }

        p.next = newNode;
        size++;
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int position, int value) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node(value);

        Node p = head;
        for (int i = 1; i < position - 1; i++) {
            p = p.next;
        }

        newNode.next = p.next;
        p.next = newNode;

        size++;
    }



    // Delete from beginning
    public int deleteFromBeginning() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        int data = head.data;
        head = head.next;
        size--;

        return data;
    }

    // Delete from end
    public int deleteFromEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        if (head.next == null) {
            return deleteFromBeginning();
        }

        Node p = head;
        while (p.next.next != null) {
            p = p.next;
        }

        int data = p.next.data;
        p.next = null;
        size--;

        return data;
    }

    // Delete from position (1-based index)
    public int deleteFromPosition(int position) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        if (position == 1) {
            return deleteFromBeginning();
        }

        Node p = head;
        for (int i = 1; i < position - 1; i++) {
            p = p.next;
        }

        int data = p.next.data;
        p.next = p.next.next;
        size--;

        return data;
    }



    // Search an element
    public boolean search(int value) {

        Node p = head;
        while (p != null) {
            if (p.data == value) {
                return true;
            }
            p = p.next;
        }

        return false;
    }



    // Get first element
    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        return head.data;
    }

    // Get last element
    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }

        return p.data;
    }

    // Get element at position (1-based index)
    public int get(int position) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node p = head;
        for (int i = 1; i < position; i++) {
            p = p.next;
        }

        return p.data;
    }



    // Update element at position (1-based index)
    public void update(int position, int value) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node p = head;
        for (int i = 1; i < position; i++) {
            p = p.next;
        }

        p.data = value;
    }



    // Reverse list (Iterative)
    public void reverse() {

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Reverse list (Recursive)
    public void reverseRecursive() {
        head = reverseRecursive(head);
    }

    private Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }


    // Display list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("\nLinked list: ");
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }

        System.out.println("null");
    }


    public static void main(String[] args) {

        Singly_Linked_List list = new Singly_Linked_List();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(40);
        list.insertAtEnd(35);
        list.insertAtEnd(16);
        list.insertAtPosition(3, 30);
        list.display();

        System.out.println("\nSize: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());

        System.out.println("\nFirst Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());
        System.out.println("Element at Position 2: " + list.get(2));

        System.out.println("\nSearch 30: " + list.search(30));
        System.out.println("Search 100: " + list.search(100));

        list.update(2, 25);
        System.out.print("\nAfter Updating Position 2 to 25:");
        list.display();

        System.out.println("\nDeleted First: " + list.deleteFromBeginning());
        System.out.println("Deleted Last: " + list.deleteFromEnd());
        System.out.print("Deleted Position 2: " + list.deleteFromPosition(2));
        list.display();

        // Reverse
        System.out.print("\nBefore:");
        list.display();

        System.out.print("\nAfter:");
        list.reverse();
        System.out.print("\nIterative Reverse:");
        list.display();

        list.reverseRecursive();
        System.out.print("\nRecursive Reverse:");
        list.display();
    }
}