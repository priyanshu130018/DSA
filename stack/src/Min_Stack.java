/**
 Time Complexity:
 - push(): O(1)
 - pop(): O(1)
 - peek(): O(1)
 - getMin(): O(1)

 Space Complexity: O(n)
 */
import java.util.Stack;

public class Min_Stack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public Min_Stack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int data) {
        stack.push(data);

        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return minStack.peek();
    }

    public void display() {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        Min_Stack s = new Min_Stack();

        s.push(10);
        s.push(5);
        s.push(20);
        s.push(3);
        s.push(15);
        System.out.print("Stack: ");
        s.display();

        System.out.println("Minimum Element: " + s.getMin());

        System.out.println("Popped Element: " + s.pop());
        System.out.println("Minimum Element: " + s.getMin());

        System.out.println("Popped Element: " + s.pop());
        System.out.println("Minimum Element: " + s.getMin());

        System.out.println("Top Element: " + s.peek());
    }

}
