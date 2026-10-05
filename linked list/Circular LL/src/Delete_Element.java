/**
 Time Complexity:
 -  Delete from Start: O(1)
 -  Delete from End: O(n)
 -  Delete from Any Position: O(n)
 Space Complexity: O(1)
 **/

public class Delete_Element {

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

    void add(int data) {
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

    void deleteFirst() {
        // Approach 1: Head Deletion
        // Time Complexity: O(1)
        // Space Complexity: O(1)

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    void deleteLast() {
        // Approach 2: Traverse to Second Last Node
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    void deleteAnywhere(int pos) {
        // Approach 3: Traverse to Previous Node
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos<1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node p = head;
        for (int i = 1; i < pos - 1; i++) {
            if (p.next == head) {
                System.out.println("Position out of bounds!");
                return;
            }
            p = p.next;
        }
        if (p.next == head) {
            System.out.println("Position out of bounds!");
            return;
        }

        if (p.next == tail) {
            tail = p;
            tail.next = head;
            return;
        }
        p.next = p.next.next;

    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("head");
    }

    public static void main(String[] args) {
        Delete_Element cll = new Delete_Element();

        cll.add(10);
        cll.add(7);
        cll.add(20);
        cll.add(5);
        cll.add(21);
        cll.add(1);

        System.out.println("Circular Linked List:");
        cll.display();

        cll.deleteAnywhere(3);
        System.out.println("After deleting node at position 3:");
        cll.display();

        cll.deleteFirst();
        System.out.println("After deleting first node:");
        cll.display();

        cll.deleteLast();
        System.out.println("After deleting last node:");
        cll.display();
    }
}
