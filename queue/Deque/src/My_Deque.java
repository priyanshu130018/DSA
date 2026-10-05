/**
 Approach 1: Deque Using built-in Class Deque + ArrayDeque
 Approach 2: Deque Using built-in Class Deque + LinkedList
 Approach 3: Queue Using built-in Class ArrayDeque

 Time Complexity:
 - offerFirst() : O(1)
 - offerLast()  : O(1)
 - pollFirst() : O(1)
 - pollLast()  : O(1)
 - peekFirst()   : O(1)
 - peekLast()   : O(1)
 - size()        : O(1)
 - isEmpty()     : O(1)
 - display()     : O(n)

 Space Complexity: O(n)
 */

import java.util.*;
import java.util.ArrayDeque;

public class My_Deque {

    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        // Deque<Integer> dq = new LinkedList<>();
        // ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(20);
        dq.offerFirst(10);
        dq.offerLast(30);
        dq.offerLast(40);
        System.out.print("Deque: ");
        System.out.println(dq);

        if (dq.isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
        System.out.println("Front: " + dq.peekFirst());
        System.out.println("Rear: " + dq.peekLast());
        System.out.println("Size: " + dq.size());

        System.out.println("Delete Front: " + dq.pollFirst());
        System.out.println("Delete Rear: " + dq.pollLast());
        System.out.print("Deque: ");
        System.out.println(dq);

        System.out.println("Is Empty: " + dq.isEmpty());
    }
}