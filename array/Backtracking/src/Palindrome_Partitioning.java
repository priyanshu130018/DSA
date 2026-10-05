/**
 Find all possible ways to partition a string such that every substring is a palindrome.

 Approach: Backtracking
 - Time Complexity: O(n * 2^n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Palindrome_Partitioning {

    public static List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), res);

        return res;
    }

    private static void backtrack(
            String s,
            int start,
            List<String> current,
            List<List<String>> res) {

        if (start == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, res);

                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(
            String s,
            int left,
            int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aab";

        List<List<String>> res = partition(s);

        System.out.println("String: " + s);
        System.out.println("Palindrome Partitions: " + res);
    }
}
