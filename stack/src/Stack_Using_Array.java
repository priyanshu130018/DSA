/**
 Approach: Stack Using Array

 Time Complexity:
 - push(): O(1)
 - pop(): O(1)
 - peek(): O(1)
 - size(): O(1)
 - isEmpty(): O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Stack_Using_Array {

    private final int[] arr;
    private int top;

    Stack_Using_Array(int size) {
        arr = new int[size];
        top = -1;
    }

    // Insert element
    public void push(int data) {
        if (top == arr.length - 1) {
            throw new IllegalStateException("Stack Overflow!");
        }
        arr[++top] = data;
    }

    // Remove front element
    public int pop() {
        if (top == -1) {
            throw new NoSuchElementException("Stack Underflow!");
        }
        return arr[top--];
    }

    // Get front element
    public int peek() {
        if (top == -1) {
            throw new NoSuchElementException("Stack Underflow!");
        }
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Print
    public void display() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow!");
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Using_Array s = new Stack_Using_Array(5);

        s.push(10);
        s.push(20);
        s.push(30);
        System.out.print("Stack Using Array: ");
        s.display();

        System.out.println("Size: " + s.size());
        System.out.println("Top Element: " + s.peek());
        System.out.println("Pop Element: " + s.pop());
        s.display();
        System.out.println("Is Stack Empty? " + s.isEmpty());
    }
}