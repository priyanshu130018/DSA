/**
 Approach: Stack Using Queue

 Time Complexity:
 - push(): O(n)
 - pop(): O(1)
 - peek(): O(1)
 - size(): O(1)
 - isEmpty(): O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_Queue {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Insert element
    public void push(int data) {

        q2.offer(data);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove front element
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }
        return q1.poll();
    }

    // Get front element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Print
    public void display() {
        System.out.println(q1);
    }


    public static void main(String[] args) {
        Stack_Using_Queue s = new Stack_Using_Queue();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.print("Stack Using Queue: ");
        s.display();

        System.out.println("Size: " + s.size());
        System.out.println("Top Element: " + s.peek());
        System.out.println("Pop Element: " + s.pop());
        s.display();
        System.out.println("Is Stack Empty? " + s.isEmpty());
    }

}
