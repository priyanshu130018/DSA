/**
 Remove the Nth node from the end of a singly linked list

 Approach: Two Pass Traversal
 Time Complexity: O(n)
 Space Complexity:
 -  Iterative: O(1)
 -  Recursive: O(n)
 **/

public class Remove_Nth_Node_From_End {

    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Approach: Two Pass Traversal
    public Node removeNthFromEnd(Node head, int n) {

        if (head == null) return null;

        int len = 0;
        Node p = head;
        while (p != null) {
            len++;
            p = p.next;
        }


        if (len == n) return head.next;

        int index = len - n;
        p = head;

        for (int i = 1; i < index; i++) {
            p = p.next;
        }

        p.next = p.next.next;

        return head;
    }

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
        Remove_Nth_Node_From_End l = new Remove_Nth_Node_From_End();

        l.add(23);
        l.add(12);
        l.add(99);
        l.add(45);
        System.out.print("Linked List: ");
        l.printList();;

        l.head = l.removeNthFromEnd(l.head, 2);
        System.out.print("After remove Nth node from end: ");
        l.printList();

    }
}



