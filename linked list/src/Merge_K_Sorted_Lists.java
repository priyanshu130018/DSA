/**
 Given K sorted linked lists, merge them into one sorted linked list

 Approach: PriorityQueue (Min-Heap)
 - Time Complexity: O(N log K)
 - Space Complexity: O(K)

 where,
 N = total number of nodes in all linked lists
 K = number of linked lists
 */

import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists {

    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Approach: PriorityQueue (Min-Heap)
    public Node mergeKLists(Node[] lists) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));

        // Put first node of every list into PriorityQueue
        for (int i = 0; i < lists.length; i++) {

            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }


        Node dummy = new Node(0);
        Node cur = dummy;

        while (!pq.isEmpty()) {

            // Get the smallest node
            Node node = pq.poll();

            cur.next = node;
            cur = cur.next;

            // Add next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }



    // Create a linked list
    public Node createList(int[] arr) {
        Node dummy = new Node(0);

        Node cur = dummy;
        for (int val : arr) {
            cur.next = new Node(val);
            cur = cur.next;
        }

        return dummy.next;
    }

    // Print
    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {

        Merge_K_Sorted_Lists l = new Merge_K_Sorted_Lists();

        // List 0: 1 -> 5 -> 6
        // List 1: 1 -> 3 -> 3
        // List 2: 2 -> 5

        Node[] lists = new Node[3];

        lists[0] = l.createList(new int[] {1, 5, 6});
        lists[1] = l.createList(new int[] {1, 3, 3});
        lists[2] = l.createList(new int[] {2, 5});

        System.out.println("Original Lists:");
        for (int i = 0; i < lists.length; i++) {
            System.out.print("List " + i + ": ");
            l.printList(lists[i]);
        }

        Node result = l.mergeKLists(lists);
        System.out.print("\nMerged List: ");
        l.printList(result);
    }
}