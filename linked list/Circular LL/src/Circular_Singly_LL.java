/**
 Circular Singly Linked List

 Time Complexity:
 - insertAtBeginning()  : O(1)
 - insertAtEnd()        : O(1)
 - insertAtPosition()   : O(n)

 - deleteFromBeginning(): O(1)
 - deleteFromEnd()      : O(n)
 - deleteFromPosition() : O(n)

 - search()             : O(n)

 - get()                : O(n)
 - getFirst()           : O(1)
 - getLast()            : O(1)

 - update()             : O(n)

 - display()            : O(n)
 - size()               : O(1)
 - isEmpty()            : O(1)

 Space Complexity: O(n)
 */

import java.util.NoSuchElementException;

public class Circular_Singly_LL {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Size
    public int size() {
        return size;
    }

    // Insert at beginning
    public void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        size++;
    }

    // Insert at end
    public void insertAtEnd(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Insert at position (1-based)
    public void insertAtPosition(int position, int value) {

        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        if (position == size + 1) {
            insertAtEnd(value);
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node(value);

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    // Delete from beginning
    public int deleteFromBeginning() {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        int data = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        size--;

        return data;
    }

    // Delete from end
    public int deleteFromEnd() {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        if (head == tail) {
            return deleteFromBeginning();
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        int data = tail.data;

        tail = current;
        tail.next = head;

        size--;

        return data;
    }

    // Delete from position (1-based)
    public int deleteFromPosition(int position) {

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        if (position == 1) {
            return deleteFromBeginning();
        }

        if (position == size) {
            return deleteFromEnd();
        }

        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        int data = current.next.data;

        current.next = current.next.next;

        size--;

        return data;
    }

    // Search
    public boolean search(int value) {

        if (isEmpty()) {
            return false;
        }

        Node current = head;

        do {
            if (current.data == value) {
                return true;
            }

            current = current.next;

        } while (current != head);

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

        return tail.data;
    }

    // Get element at position
    public int get(int position) {

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node current = head;

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Update element
    public void update(int position, int value) {

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node current = head;

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        current.data = value;
    }

    // Display
    public void display() {

        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        System.out.print("\nCircular Singly Linked List: ");

        do {
            System.out.print(current.data + " -> ");
            current = current.next;

        } while (current != head);

        System.out.println("(head)");
    }

    public static void main(String[] args) {

        Circular_Singly_LL list = new Circular_Singly_LL();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtPosition(3, 30);
        list.display();

        System.out.println("\nSize: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());

        System.out.println("\nFirst: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Position 2: " + list.get(2));

        System.out.println("\nSearch 30: " + list.search(30));
        System.out.println("Search 100: " + list.search(100));

        list.update(2, 25);
        System.out.print("After Update:");
        list.display();

        System.out.println("\nDeleted First: " + list.deleteFromBeginning());
        System.out.println("Deleted Last: " + list.deleteFromEnd());
        System.out.print("Deleted Position 2: " + list.deleteFromPosition(2));
        list.display();
    }
}