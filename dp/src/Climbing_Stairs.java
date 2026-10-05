/**
 Count total ways to reach nth stair when you can take 1 or 2 steps at a time

 Approach 1: Top Down DP (Memoization)
 - Time Complexity: O(n)
 - Space Complexity: dp array + recursion stack O(n) + O(n) = O(n)

 Approach 2: Bottom Up DP (Tabulation)
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach 3: Space Optimized DP (Iterative)
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Climbing_Stairs {

    // Approach 1: Top Down DP
    public static int climbStairs1(int n, int[] dp) {

        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        dp[n] = climbStairs1(n - 1, dp) + climbStairs1(n - 2, dp);

        return dp[n];
    }



    // Approach 2: Bottom Up DP
    public static int climbStairs2(int n) {

        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }



    // Approach 3: Space Optimized DP
    public static int climbOptimized(int n) {

        if (n <= 1) return 1;

        int prev2 = 1, prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    public static void main(String[] args) {

        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Top Down: " + climbStairs1(n, dp));

        System.out.println("Bottom Up: " + climbStairs2(n));

        System.out.println("Optimized: " + climbOptimized(n));
    }
}
