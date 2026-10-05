/**
 Approach 1: Stack Using Built-in Class Stack
 Approach 3: Queue Using built-in Class ArrayDeque

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
import java.util.Stack;
import java.util.ArrayDeque;

public class My_Stack {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        // ArrayDeque<Integer> s2 = new ArrayDeque<>();

        s1.push(1000);
        s1.push(2000);
        s1.push(3000);
        s1.push(5000);

        System.out.print("Stack: ");
        System.out.println(s1);

        System.out.println("Size: " + s1.size());

        if (s1.isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println("Top Element: " + s1.peek());
        System.out.println("Pop Element: " + s1.pop());
        System.out.println(s1);
        System.out.println("Is Stack Empty? " + s1.isEmpty());
    }
}