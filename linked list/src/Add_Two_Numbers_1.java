/**
 Add Two Numbers using Singly Linked List
 Digits are stored in reverse order

 Approach: Iterative Traversal + Dummy Linked List
 - Time Complexity: O(max(n, m))
 - Space Complexity: O(1)
 */

public class Add_Two_Numbers_1 {

    Node head;
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addNumbers(Node l1, Node l2) {

        Node dummy = new Node(-1);
        Node p = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = 0, y = 0;

            if (l1 != null) {
                x = l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.data;
                l2 = l2.next;
            }

            int sum = x + y + carry;
            p.next = new Node(sum % 10);
            p = p.next;

            carry = sum / 10;
        }

        return dummy.next;
    }

    // Add
    public void insertEnd(int data) {
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

    // Print List
    public static void printList(Node head) {

        Node p = head;

        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Add_Two_Numbers_1 l = new Add_Two_Numbers_1();
        l.insertEnd(2);
        l.insertEnd(4);
        l.insertEnd(3);

        Add_Two_Numbers_1 list2 = new Add_Two_Numbers_1();
        list2.insertEnd(5);
        list2.insertEnd(6);
        list2.insertEnd(4);

        Node ans = addNumbers(l.head, list2.head);
        System.out.print("Result: ");
        printList(ans);
    }
}
