/**
 Approach: Circular Doubly Linked List

 Time Complexity:
 - insertAtBeginning()  : O(1)
 - insertAtEnd()        : O(1)
 - insertAtPosition()   : O(n)

 - deleteFromBeginning(): O(1)
 - deleteFromEnd()      : O(1)
 - deleteFromPosition() : O(n)

 - search()             : O(n)

 - get()                : O(n)
 - getFirst()           : O(1)
 - getLast()            : O(1)

 - update()             : O(n)

 - displayForward()     : O(n)
 - displayBackward()    : O(n)
 - size()               : O(1)
 - isEmpty()            : O(1)

 Space Complexity: O(n)
 */

import java.util.*;

public class Circular_Doubly_LL {

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

    // Return current size
    public int size() {
        return size;
    }

    // Insert at beginning
    public void insertAtBeginning(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {

            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }

        size++;
    }

    // Insert at end
    public void insertAtEnd(int value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {

            newNode.prev = tail;
            newNode.next = head;

            tail.next = newNode;
            head.prev = newNode;

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

            head.prev = tail;
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

        int data = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {

            tail = tail.prev;

            tail.next = head;
            head.prev = tail;
        }

        size--;

        return data;
    }

    // Search element
    public boolean search(int value) {

        if (isEmpty()) {
            return false;
        }

        Node temp = head;

        do {

            if (temp.data == value) {
                return true;
            }

            temp = temp.next;

        } while (temp != head);

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



    // Display forward
    public void displayForward() {

        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        System.out.print("\nCircular Doubly Linked List: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

    // Display backward
    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = tail;
        System.out.print("\nCircular Doubly Linked List: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println("(tail)");
    }

    public static void main(String[] args) {

        Circular_Doubly_LL list = new Circular_Doubly_LL();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtPosition(3, 30);
        System.out.print("Forward:");
        list.displayForward();
        System.out.print("Backward:");
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
    }

}