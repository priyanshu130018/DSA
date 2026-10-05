/**
 Reverse the given linked list

 Approach 1: Three-Pointer Technique (Iterative)
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: Recursive Reversal
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Reverse_Linked_List {

    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Approach 1: Three-Pointer Technique (Iterative)
    public void reverseI() {

        Node curr = head;
        Node prev = null;

        while (curr != null) {

            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
         head = prev;
     }



    // Approach 2: Recursive Reversal
     public void reverseR() {

        head = reverse(head);
     }

     private Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);

        // reverse link and break old link
        head.next.next = head;
        head.next = null;

        return newHead;

        /**
         1->2->3->4->null
         reverseR(1)-> reverseR(2)-> reverseR(3) -> reverseR(4)
         reverseR(4) head=4,
         reverseR(3) head=3 newHead=4 (4->3->null),
         reverseR(2) head=2 newHead=4 (4->3->2->null),
         reverseR(1) head=1 newHead=4 (4->3->2->1->null)
         */
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
        Reverse_Linked_List l = new Reverse_Linked_List();

        l.add(23);
        l.add(12);
        l.add(99);
        l.add(45);
        System.out.println("Before");
        System.out.print("Linked List: ");
        l.printList();

        System.out.println("\nAfter");
        l.reverseI();
        System.out.println("Iterative Reverse: ");
        l.printList();

        l.reverseR();
        System.out.println("Recursive Reverse: ");
        l.printList();

    }
}


