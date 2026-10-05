/**
 Approach: (Max Heap) Priority Queue Using built-in Class Priority Queue + Reverse

 Time Complexity:
 - offer()   : O(log n)
 - poll()    : O(log n)
 - peek()    : O(1)
 - size()    : O(1)
 - isEmpty() : O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Max_Heap_Priority_Queue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(40);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        System.out.print("Priority Queue (Max Heap): ");
        System.out.println(pq);

        if (pq.isEmpty()) {
            throw new NoSuchElementException("Priority Queue is empty!");
        }
        System.out.println("Top Element: " + pq.peek());
        System.out.println("Size: " + pq.size());
        System.out.println("Removed: " + pq.poll());
        System.out.print("Priority Queue: ");
        System.out.println(pq);

        System.out.println("Is Empty: " + pq.isEmpty());
        System.out.print("Sorted Order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}