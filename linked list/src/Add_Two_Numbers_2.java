/**
 Add Two Numbers using Singly Linked List
 Digits are stored in forward order

 Approach 1: Reverse LL + Dummy Linked List
 - Time Complexity: O(n + m)
 - Space Complexity: O(1)

 Approach 2: Using Stack-Based Traversal
 - Time Complexity: O(n + m)
 - Space Complexity: O(n + m)

 */

public class Add_Two_Numbers_2 {

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
        // Approach: Reverse LL + Add + Reverse Result

        l1 = reverse(l1);
        l2 = reverse(l2);

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

        return reverse(dummy.next);



        /*
        // Approach 2: Using Stack-Based Traversal

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();

            int sum = x + y + carry;
            carry = sum / 10;

            Node newNode = new Node(sum % 10);
            newNode.next = head;
            head = newNode;
        }

        return head;
        */
    }

    // Insert at End
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

    // Reverse Linked List
    public static Node reverse(Node head) {
        Node prev = null;
        Node p = head;

        while (p != null) {
            Node next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return prev;
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

        Add_Two_Numbers_2 l1 = new Add_Two_Numbers_2();
        l1.insertEnd(3);
        l1.insertEnd(4);
        l1.insertEnd(2);

        Add_Two_Numbers_2 l2 = new Add_Two_Numbers_2();
        l2.insertEnd(4);
        l2.insertEnd(6);
        l2.insertEnd(5);

        Node ans = addNumbers(l1.head, l2.head);

        System.out.print("Result: ");
        printList(ans);
    }
}