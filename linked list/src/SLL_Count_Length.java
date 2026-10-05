/**
 Time Complexity: O(n)
 Space Complexity:
 -  Iterative: O(1)
 -  Recursive: O(n)
 **/

public class SLL_Count_Length {
    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int calcLength(){
        // Approach 1: Iterative Traversal
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        Node p = head;
        int count = 0;

        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
    public int calcLength() {
        // Approach 2: Recursion Traversal
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        return countRecursive(head);
    }
    public int countRecursive(Node node) {
        if (node == null) return 0;

        return 1 + countRecursive(node.next);
    }
    **/

    // Add
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }

        Node p=head;
        while(p.next != null){
            p=p.next;
        }
        p.next = newNode;
    }

    // Print
    public void printList() {
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
        SLL_Count_Length l = new SLL_Count_Length();

        l.add(23);
        l.add(12);
        l.add(99);
        l.add(45);
        System.out.print("Linked List: ");
        l.printList();

        int res = l.calcLength();
        System.out.print("Length of linked List: " + res);
    }
}

