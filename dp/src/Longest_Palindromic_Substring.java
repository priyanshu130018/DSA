/**
 Find the longest palindromic substring in a given string

 Approach: Dynamic Programming
 - Time Complexity: O(n²)
 - Space Complexity: O(n²)
 **/


public class Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {
        // Approach: Dynamic Programming

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // For length = 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // For length ≥ 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;

                        if (len > maxLen) {
                            start = i;
                            maxLen = len;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {

        String s = "babad";
        System.out.println("Given string: " + s);

        String res = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + res);
    }
}
