/**
 Count how many times that number appears in the list

 Approach 1: Iterative Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: Recursion Traversal
 Time Complexity: O(n)
 Space Complexity: O(n)
 **/

public class Count_Occurrences {

    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Approach 1: Iterative Traversal
    public static int countOccIterative(Node head, int val) {

        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.data == val) {
                count++;
            }
            p = p.next;
        }
        return count;
    }


    // Approach 2: Recursion Traversal
    public static int countOccRecursion(Node node, int val) {

        if (node == null) return 0;

        int count = (node.data == val) ? 1 : 0;

        return count + countOccRecursion(node.next, val);
    }

    // Add
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

    // Print linked list
    public void printList() {

        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Count_Occurrences list = new Count_Occurrences();

        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(10);
        list.add(20);
        System.out.print("List: ");
        list.printList();

        int val = 10;

        int result1 = countOccIterative(list.head, val);
        System.out.println("Iterative count: " + result1);

        int result2 = countOccRecursion(list.head, val);
        System.out.println("Recursive count: " + result2);
    }
}