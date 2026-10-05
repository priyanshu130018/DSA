/**
 Check whether the given array is a palindrome using recursion.

 Approach: Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Palindrome_Array {

    public static boolean isPalindrome(int[] arr, int start, int end) {

        // Base Case
        if (start >= end) {
            return true;
        }

        // If elements are different
        if (arr[start] != arr[end]) {
            return false;
        }

        // Recursive Call
        return isPalindrome(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 1};

        boolean result = isPalindrome(arr, 0, arr.length - 1);

        System.out.println("Palindrome = " + result);
    }
}
