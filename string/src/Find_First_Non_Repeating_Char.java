/**
 Find the first non-repeating character in a given string

 Approach 1: Character Frequency Array
 - Time Complexity: O(n)
 - Space Complexity: O(26) ≈ O(1)

 Approach 2: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 where
 k = number of distinct characters
 */

import java.util.HashMap;

public class Find_First_Non_Repeating_Char {

    public static Character findChar(String str) {
        // Approach 1: Character Frequency Array

        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : str.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                return ch;
            }
        }
        return null;

        /*
        // Approach 2: HashMap

        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return null;
        */
    }

    public static void main(String[] args) {

        String str = "swiss";
        System.out.println("Strings: " + str);

        Character result = findChar(str);
        System.out.println("First Non-Repeating Character: " + result);
    }
}
