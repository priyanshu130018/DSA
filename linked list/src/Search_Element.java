/**
 Time Complexity: O(n)
 Space Complexity: O(1)
 */

import java.util.Scanner;

public class Search_Element {
    Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

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

    public int searchEle(int ele){
        // Approach 1: Linear Search
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        Node p = head;
        int pos = 1;

        while (p != null) {
            if (p.data == ele) {
                return pos;
            }
            p = p.next;
            pos++;
        }
        return -1;


        /**
         // Approach 2: Recursive Search
         // Time Complexity: O(n)
         // Space Complexity: O(n)

         return searchRecursive(head, ele, 1);
         **/
    }

    public int searchRecursive(Node node, int ele, int pos) {
        if (node == null) return -1;
        if (node.data == ele) {
            return pos;
        }
        return searchRecursive(node.next, ele, pos + 1);
    }

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
        Scanner sc = new Scanner(System.in);
        Search_Element l = new Search_Element();

        l.add(23);
        l.add(35);
        l.add(46);
        l.add(73);
        System.out.println("Linked List:");
        l.printList();

        System.out.println("Enter element to be searched:");
        int ele=sc.nextInt();

        int res = l.searchEle(ele);
        if(res!=-1)
            System.out.println("Element found at " + res + " position");
        else
            System.out.println("Element not found");

        sc.close();
    }
}

