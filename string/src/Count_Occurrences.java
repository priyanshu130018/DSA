/**
 Count occurrences of each character in Word

 Approach 1: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 where
 k = Number of distinct characters in the string

 Approach 2: Character Frequency Array
 - Time Complexity: O(n)
 - Space Complexity: O(26) ≈ O(1)
 */

import java.util.HashMap;
import java.util.Map;

public class Count_Occurrences {

    public static void countOccurrences(String str) {
        // Approach 1: HaspMap

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



        /*
        // Approach 2: Character Frequency Array

        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char) ('a' + i) + " -> " + freq[i]);
            }
        }
        */
    }


    public static void main(String[] args) {

        String str = "programmingisfun";
        System.out.println("Strings: " + str);
        countOccurrences(str);
    }
}
