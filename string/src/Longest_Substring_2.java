/**
 Find the longest substring without repeating characters

 Approach: Sliding Window + HashSet
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 where
 k = number of distinct characters possible in the input/window
 **/

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_2 {

    public static String longestSubstring(String s) {
        // Approach: Sliding Window + HashSet

        if (s == null || s.isEmpty()) return "";

        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Shrink the window until the duplicate is removed
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            // Update the longest valid window
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {

        String s = "abcbdebcd";
        System.out.println("Strings: " + s);

        String res = longestSubstring(s);
        System.out.println("Longest Substring with distinct character: " + res);

    }
}