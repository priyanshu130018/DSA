/**
 Group all anagrams from the given array of strings into separate lists
 Anagrams: A word or phrase formed by rearranging the letters of another word or phrase,
           using all the original letters exactly once

 Approach 1: Character Frequency Array + HashMap
 - Time Complexity: O(n * k)
 - Space Complexity: O(n * k)

 Approach 2: Sorting + HashMap
 - Time Complexity: O(n * k log k)
 - Space Complexity: O(n * k)

 where
 n = number of strings
 k = maximum length of a string
 **/

import java.util.*;

public class Group_Anagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Approach 1: Character Frequency array + HashMap

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            // Create unique key
            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append(num).append('#');
            }
            String k = key.toString();

            // if key exist, Add word with same key in Arraylist
            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(str);
        }

        return new ArrayList<>(map.values());


        /*
        // Approach 2: Sorting + HashMap

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();

             Arrays.sort(ch);

             // Sorted string becomes key
             String key = new String(ch);

             map.putIfAbsent(key, new ArrayList<>());
             map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
        */
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Strings: " + Arrays.toString(strs));

        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Grouped Anagrams:" + result);
    }
}