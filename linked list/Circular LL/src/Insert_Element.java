/**
 Time Complexity:
 -  Insert at Start: O(1)
 -  Insert at End: O(1)
 -  Insert from Any Position: O(n)
 Space Complexity: O(1)
 **/

public class Insert_Element {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    Node tail;

    void addStart(int data) {
        // Approach 1: Head Insertion
        // Time Complexity: O(1)
        // Space Complexity: O(1)

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    void addEnd(int data) {
        // Approach 2: Tail Insertion
        // Time Complexity: O(1)
        // Space Complexity: O(1)

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void addAnywhere(int data, int position) {
        // Approach 3: Traversal to Previous Node
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (position == 1) {
            addStart(data);
            return;
        }

        Node p = head;
        for (int i = 1; i < position-1 && p.next != head; i++) {
            p = p.next;
        }
        if (p == tail) {
            addEnd(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("head");
    }


    public static void main(String[] args) {
        Insert_Element cll = new Insert_Element();

        cll.addStart(10);
        cll.addStart(20);
        cll.addAnywhere(30,2);
        cll.addEnd(5);
        cll.addEnd(1);

        System.out.println("Circular Linked List:");
        cll.display();
    }
}

