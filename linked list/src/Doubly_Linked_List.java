/**
 Approach: Doubly Linked List

 Time Complexity:
 - insertAtBeginning()  : O(1)
 - insertAtEnd()        : O(1)
 - insertAtPosition()   : O(1)

 - deleteFromBeginning(): O(1)
 - deleteFromEnd()      : O(n)
 - deleteFromPosition() : O(n)

 - search()             : O(n)

 - get()                : O(n)
 - getFirst()           : O(1)
 - getLast()            : O(n)

 - update()             : O(n)

 - reverse()            : O(n)

 - displayForward()     : O(n)
 - displayBackward()    : O(n)

 - size()               : O(1)
 - isEmpty()            : O(1)

 Space Complexity: O(n)
 */

import java.util.*;

public class Doubly_Linked_List {

    private static class Node {
        int data;
        Node prev;
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

    // Return size
    public int size() {
        return size;
    }

    // Insert at beginning
    public void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    // Insert at end
    public void insertAtEnd(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(value);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;

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
            head.prev = null;
        }

        size--;
        return data;
    }

    // Delete from end
    public int deleteFromEnd() {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        int data = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return data;
    }

    // Search
    public boolean search(int value) {

        Node temp = head;
        while (temp != null) {

            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }

        return false;
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

        Node temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        int data = temp.data;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;

        return data;
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

    // Get element at position (1-based)
    public int get(int position) {

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // Update element at position
    public void update(int position, int value) {

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid Position!");
        }

        Node temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        temp.data = value;
    }

    // Reverse the list
    public void reverse() {

        Node current = head;
        Node temp = null;

        while (current != null) {

            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // Display from head to tail
    public void displayForward() {

        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;

        System.out.print("\nDoubly Linked List: ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display from tail to head
    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = tail;

        System.out.print("\nDoubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Doubly_Linked_List list = new Doubly_Linked_List();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtPosition(3, 30);

        System.out.print("Forward");
        list.displayForward();
        System.out.print("Backward");
        list.displayBackward();

        System.out.println("\nSize: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());

        System.out.println("\nFirst: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Position 2: " + list.get(2));

        System.out.println("\nSearch 30: " + list.search(30));
        System.out.println("Search 100: " + list.search(100));

        list.update(2, 25);
        System.out.print("\nAfter Update:");
        list.displayForward();

        System.out.println("\nDeleted First: " + list.deleteFromBeginning());
        System.out.println("Deleted Last: " + list.deleteFromEnd());
        System.out.print("Deleted Position 2: " + list.deleteFromPosition(2));
        list.displayForward();


        System.out.print("\nBefore Reverse:");
        list.displayForward();
        list.reverse();

        System.out.print("\nAfter Reverse:");
        list.displayForward();
    }
}
