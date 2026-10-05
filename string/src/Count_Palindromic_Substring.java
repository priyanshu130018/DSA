/**
 Count the total number of palindromic substrings in a string

 Approach 1: Two Pointer Expansion
 - Time Complexity: O(n²)
 - Space Complexity: O(1)

 Approach 2: Dynamic Programming
 - Time Complexity: O(n²)
 - Space Complexity: O(n²)
 **/

public class Count_Palindromic_Substring {
    // Approach 1: Two Pointer Expansion

    // Expand Around Center
    public static int countPalindrome(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            // Odd length palindromes
            count += expand(str, i, i);

            // Even length palindromes
            count += expand(str, i, i + 1);
        }
        return count;
    }

    // Expand from center
    public static int expand(String str, int left, int right) {

        int count = 0;
        while (left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)) {

            left--;
            right++;
            count++;
        }
        return count;
    }




    /*
    public static int count_Palindrome(String str) {
        // Approach 2: Dynamic Programming

        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    if (len <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    */

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println("String: " + str);

        int ans = countPalindrome(str);
        System.out.println("Total Palindromic Substrings = " + ans);
    }
}