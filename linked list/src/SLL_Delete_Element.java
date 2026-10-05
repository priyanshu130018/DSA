/**
 Delete Element to Linked List

 Time Complexity:
 -  Delete from Start: O(1)
 -  Delete from End: O(n)
 -  Delete from Any Position: O(n)

 Space Complexity: O(1)
 */

public class SLL_Delete_Element {
    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Add
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = newNode;
    }

    // Delete from Start
    public void deleteStart(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    // Delete from End
    public void deleteEnd(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node p = head;
        while (p.next.next != null){
            p = p.next;
        }
        p.next = null;
    }

    // Delete from Any Position
    public void deleteAnywhere(int pos){
        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if(pos == 1){
            deleteStart();
            return;
        }

        Node p =head;
        for (int i = 1; i < pos-1; i++) {
            if (p.next == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            p = p.next;
        }
        if (p.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        p.next = p.next.next;
    }

    // Print
    public void printList(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node p=head;
        while (p!=null){
            System.out.print(p.data + "->");
            p=p.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SLL_Delete_Element l = new SLL_Delete_Element();

        l.add(10);
        l.add(18);
        l.add(39);
        l.add(45);
        l.add(120);
        l.add(27);
        System.out.print("Linked List: ");
        l.printList();

        l.deleteAnywhere(3);
        System.out.print("After deleting position 3: ");
        l.printList();

        l.deleteStart();
        System.out.print("After deleting first node: ");
        l.printList();

        l.deleteEnd();
        System.out.print("After deleting last node: ");
        l.printList();
    }
}
