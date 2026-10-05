/**
 Doubly Linked List

 Approach: Using built-in Class Linked List
 Time Complexity:
 - add()         : O(1)
 - addFirst()    : O(1)
 - addLast()     : O(1)

 - remove()      : O(n)
 - removeFirst() : O(1)
 - removeLast()  : O(1)

 - contains()    : O(n)
 - set()         : O(n)

 - get()         : O(n)
 - getFirst()    : O(1)
 - getLast()     : O(1)

 - size()        : O(1)
 - isEmpty()     : O(1)
 - clear()       : O(n)

 Space Complexity: O(n)
 */

import java.util.LinkedList;

public class My_Linked_List {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        // add()
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("add(): " + list);

        list.addFirst(5);
        System.out.println("addFirst(): " + list);
        list.addLast(40);
        System.out.println("addLast(): " + list);

        // remove()
        list.remove(2);
        System.out.println("remove(): " + list);
        list.removeFirst();
        System.out.println("removeFirst(): " + list);
        list.removeLast();
        System.out.println("removeLast(): " + list);

        // isEmpty()
        System.out.println("isEmpty(): " + list.isEmpty());

        // contains()
        System.out.println("contains(20): " + list.contains(20));


        // set()
        list.set(1, 25);
        System.out.println("set(): " + list);

        System.out.println("get(1): " + list.get(1));
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        // size
        System.out.println("size(): " + list.size());

        // clear()
        list.clear();
        System.out.println("clear(): " + list);
    }
}