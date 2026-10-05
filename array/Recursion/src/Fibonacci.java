/**
 Find the nth Fibonacci number using recursion.

 Approach: Recursion
 - Time Complexity: O(2^n)
 - Space Complexity: O(n)
 **/

public class Fibonacci {

    public static int fibonacci(int n) {

        // Base Case
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive Call
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        int n = 6;

        int result = fibonacci(n);

        System.out.println("Fibonacci = " + result);
    }
}
