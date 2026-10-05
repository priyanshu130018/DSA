/**
 Insert Element to Linked List

 Time Complexity:
 -  Insert at Start: O(1)
 -  Insert at End: O(n)
 -  Insert at Any Position: O(n)

 Space Complexity: O(1)
 **/

public class SLL_Insert_Element {

    Node head;
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Insert at Start
    public void insertStart(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
    }

    // Insert at End
    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }

        Node p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = newNode;
    }

    // Insert at Any Position
    public void insertAnywhere(int data, int pos){
        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            insertStart(data);
            return;
        }
        if (head == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        Node newNode = new Node(data);
        Node p = head;
        for (int i = 1; i < pos-1; i++) {
            if (p.next == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            p = p.next;
        }
        newNode.next = p.next;
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
        SLL_Insert_Element l = new SLL_Insert_Element();

        l.insertStart(23);
        l.insertStart(12);
        l.insertEnd(45);
        l.insertAnywhere(31,3);

        System.out.print("Linked List: ");
        l.printList();
    }
}
