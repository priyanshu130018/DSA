/**
 Check whether two strings are valid anagrams of each other
 Anagrams: A word or phrase formed by rearranging the letters of another word or phrase, using all letters exactly once

 Approach 1: Frequency Array
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 1: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 **/

public class Valid_Anagrams {

    public static boolean checkValidAnagram(String str1, String str2) {
        // Approach 1: Frequency Count Array

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }

        for (int val : freq) {
            if (val != 0) return false;
        }

        return true;



        /*
        // Approach 2: Sorting

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
        */
    }

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "world";

        System.out.println("Word 1: " + str1);
        System.out.println("Word 2: " + str2);

        boolean isValid = checkValidAnagram(str1, str2);
        if (isValid) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
