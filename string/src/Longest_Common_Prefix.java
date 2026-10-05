/**
 Find the longest common prefix among an array of strings

 Approach 1: Horizontal Scanning (Prefix Reduction)
 - Time Complexity: O(n × m²)
 - Space Complexity: O(1)

 Approach 2: Vertical Scanning
 - Time Complexity: O(n × m)
 - Space Complexity: O(1)

 where
 n = number of strings
 m = length of the shortest string
 **/

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        // Approach 1: Horizontal Scanning (Prefix Reduction)

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            // check common prefix
            while (strs[i].indexOf(prefix) != 0) {
                if (prefix.isEmpty()) {
                    return "";
                }

                // remove last element
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;

        /*
        // Approach 2: Vertical Scanning

        String prefix = strs[0];
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {

                // check range & find common prefix
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
        */
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Strings: " + Arrays.toString(strs));

        String res = longestCommonPrefix(strs);
        if (res.isEmpty())
            System.out.println("No Common Prefix");
        else
            System.out.println("Longest Common Prefix: " + res);
    }
}