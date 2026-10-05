/**
 Find the longest substring that contains at most k distinct characters

 Approach 1: Sliding Window + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 where
 k = maximum number of distinct characters allowed in the substring

 Approach 2: Brute Force + HashMap
 - Time Complexity: O(n²)
 - Space Complexity: O(k)
 **/

import java.util.HashMap;

public class Longest_Substring_1 {

    public static String longestSubstring(String s, int k) {
        // Approach 1: Sliding Window + HashMap

        if (s == null || s.isEmpty() || k == 0) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);


            // Shrink window if distinct characters exceed k
            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update max window
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLen);


        /*
        // Approach 2: Brute Force + HashMap

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j),
                        map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() > k) break;

                if (j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        */
    }

    public static void main(String[] args) {

        String s = "aabcbcd";
        int k = 2;
        System.out.println("Strings: " + s);

        String res = longestSubstring(s, k);
        System.out.println("Longest Substring with distinct character: " + res);
    }
}