/**
 Approach 1: Queue Using built-in Class Queue + ArrayDeque
 Approach 2: Queue Using built-in Class Queue + LinkedList
 Approach 3: Queue Using built-in Class ArrayDeque

 Time Complexity:
 - offer() : O(1)
 - poll() : O(1)
 - peek()    : O(1)
 - size()    : O(1)
 - isEmpty() : O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class My_Queue {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        // Queue<Integer> q = new LinkedList<>();
        // ArrayDeque<Integer> dq = new ArrayDeque<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        System.out.print("Queue: ");
        System.out.println(q);


        if (q.isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }
        System.out.println("Front: " + q.peek());

        System.out.println("Dequeued: " + q.poll());
        System.out.print("Queue: ");
        System.out.println(q);
        System.out.println("Size: " + q.size());
        System.out.println("Is Empty: " + q.isEmpty());
    }
}