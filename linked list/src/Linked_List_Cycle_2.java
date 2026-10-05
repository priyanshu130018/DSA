/**
 Find the node where the cycle begins
 
 Approach: Floyd's Cycle Detection Algorithm / Tortoise and Hare Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

public class Linked_List_Cycle_2 {

    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findStartNode(Node head) {

        Node slow = head;
        Node fast = head;

        if(fast == null || fast.next == null) {
            return null;
        }

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // Create cycle
        n6.next = n3;

        Node result = findStartNode(n1);
        if (result != null) {
            System.out.println("Cycle starts at node: " + result.data);
        } else {
            System.out.println("No cycle");
        }
    }
}
