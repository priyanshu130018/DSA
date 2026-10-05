/**
 Approach: Queue Using Stack

 Time Complexity:
 - enqueue() : O(1)
 - dequeue() : Amortized O(1)
 - peek()    : Amortized O(1)
 - size()    : O(1)
 - isEmpty() : O(1)
 - display() : O(n)

 Space Complexity: O(n)
 */

import java.util.NoSuchElementException;
import java.util.Stack;

public class Queue_Using_Stack {

    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;

    public Queue_Using_Stack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Insert element
    public void enqueue(int value) {
        inputStack.push(value);
    }

    // Remove front element
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();
    }

    // Get front element
    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.peek();
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public int size() {
        return inputStack.size() + outputStack.size();
    }

    // Print
    public void display() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }

        // Front part (outputStack)
        for (int i = outputStack.size() - 1; i >= 0; i--) {
            System.out.print(outputStack.get(i) + " ");
        }

        // Rear part (inputStack)
        for (int val : inputStack) {
            System.out.print(val + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Queue_Using_Stack q1 = new Queue_Using_Stack();

        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        System.out.print("Queue Using Stack: ");
        q1.display();

        System.out.println("Size: " + q1.size());
        System.out.println("Front Element: " + q1.peek());
        System.out.println("Dequeue Element: " + q1.dequeue());
        System.out.print("After Dequeue: ");
        q1.display();
        System.out.println("Is Queue Empty? " + q1.isEmpty());
    }
}