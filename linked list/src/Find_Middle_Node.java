/**
 Find the middle node(s) of a singly linked list
 If the list has an odd number of nodes, return the single middle node
 If the list has an even number of nodes, return the two middle nodes
 Handle an empty list

 Approach 1: Slow and Fast Pointer
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: Two-pass approach / Length-Based approach
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

public class Find_Middle_Node {
    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Find middle node
    public Node[] findMiddleNodes() {
        // Approach 1: Slow and Fast Pointer

        if (head == null) {
            return new Node[] {null, null};
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length
        if (fast != null) return new Node[]{slow, null};

        // even length
        return new Node[]{prev, slow};


        /**
        // Approach 2: Two-pass approach / Length-Based approach

        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        p = head;
        int mid = (count-1)/2;
        for (int i = 0; i < mid; i++) {
            p = p.next;
        }

        if (count % 2 == 1) {
            return new Node[]{p, null};
        }
        return new Node[] {p, p.next};
        **/
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

        Find_Middle_Node l = new Find_Middle_Node();

        l.add(23);
        l.add(12);
        l.add(99);
        l.add(45);
        System.out.print("Linked List: ");
        l.printList();

        Node[] res = l.findMiddleNodes();

        if (res[0] == null) {
            System.out.println("Linked List is empty!");
        }
        else if(res[1] == null)
            System.out.print("Middle: " + res[0].data);
        else
            System.out.print("Middles: " + res[0].data + ", " + res[1].data);
    }
}


