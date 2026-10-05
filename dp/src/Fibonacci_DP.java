/**
 Find the nth Fibonacci number, where F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1

 Approach 1: Top Down DP (Memoization)
 - Time Complexity: O(n)
 - Space Complexity: O(n) + O(n) = O(n)

 Approach 2: Bottom Up DP (Tabulation)
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach 3: Space Optimized DP (Iterative)
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 4: Matrix Exponentiation Method
 - Time Complexity: O(log n)
 - Space Complexity: O(log n)

*/
import java.util.Arrays;

public class Fibonacci_DP {

    // Approach 1: Top Down DP
    public static int fibonacci2(int n, int[] dp) {
        if (n == 0 || n == 1) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = fibonacci2(n - 1, dp) + fibonacci2(n - 2, dp);
        return dp[n];
    }


    // Approach 2: Bottom Up DP (Tabulation)
    public static int fibonacci2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



    // Approach 3: Space Optimized DP (Iterative DP)
    public static int fibonacciOptimized(int n) {
        if (n <= 1) return n;

        int prev1 = 1, prev2 = 0, curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }



    // Approach 4: Matrix Exponentiation Method
    public static void multiply(int[][] mat1, int[][] mat2) {
        int x = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int y = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int z = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int w = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];

        mat1[0][0] = x;
        mat1[0][1] = y;
        mat1[1][0] = z;
        mat1[1][1] = w;
    }

    public static void matrixPower(int[][] mat1, int n) {
        if (n == 0 || n == 1) return;

        int[][] mat2 = {{1, 1}, {1, 0}};

        matrixPower(mat1, n / 2);
        multiply(mat1, mat1);

        if (n % 2 != 0) {
            multiply(mat1, mat2);
        }
    }

    public static int matrixFib(int n) {
        if (n <= 1) return n;

        int[][] mat1 = {{1, 1}, {1, 0}};
        matrixPower(mat1, n - 1);

        return mat1[0][0];
    }


    public static void main(String[] args) {

        int n = 6;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Top Down: " + fibonacci2(n, dp));

        System.out.println("Bottom Up: " + fibonacci2(n));

        System.out.println("Optimized: " + fibonacciOptimized(n));

        System.out.println("Matrix: " + matrixFib(n));
    }
}
