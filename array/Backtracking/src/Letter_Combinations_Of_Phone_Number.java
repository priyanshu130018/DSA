/**
 Find all possible letter combinations represented by the given phone number digits.

 Approach: Backtracking
 - Time Complexity: O(4^n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Letter_Combinations_Of_Phone_Number {

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return res;
        }

        String[] phone = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), phone, res);

        return res;
    }

    private static void backtrack(
            String digits,
            int index,
            StringBuilder current,
            String[] phone,
            List<String> res) {

        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            current.append(ch);

            backtrack(
                    digits,
                    index + 1,
                    current,
                    phone,
                    res
            );

            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        String digits = "23";

        System.out.println("Digits: " + digits);
        System.out.println("Letter Combinations: " + letterCombinations(digits));
    }
}
