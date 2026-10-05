/**
 Find the longest palindromic substring in a given string

 Approach 1: Manacher's Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach 2: Dynamic Programming
 - Time Complexity: O(n²)
 - Space Complexity: O(n²)
 **/

public class Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {
        // Manacher's Algorithm

        if (s == null || s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }

        String t = sb.toString();
        int n = t.length();

        int[] arr = new int[n];
        int center = 0, R = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < R) {
                arr[i] = Math.min(R-i, arr[mirror]);
            }

            // Expand around center
            while ((i - arr[i] - 1 >= 0) && (i + arr[i] + 1 < n) &&
                    t.charAt(i - arr[i] - 1) == t.charAt(i + arr[i] + 1)) {
                arr[i]++;
            }

            // Update center and right boundary
            if (i + arr[i] > R) {
                center = i;
                R = i + arr[i];
            }
        }

        // Find max
        int maxLen = 0, centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxLen) {
                maxLen = arr[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen)/2;

        return s.substring(start, start + maxLen);



        /*
        // Approach 2: Dynamic Programming

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
                if (s.charAt(i) == s.charAt(j) &&
                        (len == 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
        */
    }

    public static void main(String[] args) {

        String s = "babad";
        System.out.println("Given string: " + s);

        String res = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + res); // "bab" or "aba"
    }
}
