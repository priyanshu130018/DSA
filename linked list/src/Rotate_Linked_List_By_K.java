/**
 Rotate the Linked List by k position

 Approach 1: Circular Linked List Method
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: Two Pointer (Slow & fast) Technique
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Scanner;

public class Rotate_Linked_List_By_K {
    Node head;

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int len(Node head) {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public Node rotateList(Node head, int k) {
        // Approach 1: Circular Linked List Method

        if (head == null || head.next == null ||k==0) return head;

        int length = len(head);
        k = k % length;

        if (k == 0) {
            return head;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        int steps = length - k;
        Node p = head;
        for (int i = 1; i < steps; i++) {
            p = p.next;
        }
        Node newHead = p.next;
        p.next = null;

        return newHead;


        /**
        // Approach 2: Two Pointer Technique

        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        Node slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
        */
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node p = head;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Rotate_Linked_List_By_K l = new Rotate_Linked_List_By_K();

        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        System.out.print("Before: ");
        l.printList();

        int k = 3;
        l.head = l.rotateList(l.head, k);
        System.out.print("After: ");
        l.printList();
    }
}