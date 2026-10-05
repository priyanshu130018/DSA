/**
 Detect whether a linked list contains a cycle

 Approach: Floyd's Cycle Detection Algorithm / Tortoise and Hare Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

public class Linked_List_Cycle_1 {

    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Approach: Floyd's Cycle Detection Algorithm / Tortoise and Hare Algorithm
    public static boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create cycle
        fifth.next = third;

        boolean result = hasCycle(first);
        if (result) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
}
