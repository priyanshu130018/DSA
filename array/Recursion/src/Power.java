/**
 Find the power of a number using recursion.

 Approach: Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Power {

    public static int power(int x, int n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // Recursive Call
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {

        int x = 2;
        int n = 5;

        int result = power(x, n);

        System.out.println("Power = " + result);
    }
}
