/**
 Find the factorial of a given number using recursion.

 Approach: Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Factorial {

    public static int factorial(int n) {

        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive Call
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        int n = 5;

        int result = factorial(n);

        System.out.println("Factorial = " + result);
    }
}

