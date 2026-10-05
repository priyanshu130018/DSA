/**
 Check whether a given string is a palindrome

 Approach 1: Two Pointer
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: Reverse + Compare
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Valid_Palindrome {

    public static boolean checkPalindrome(String str) {
        // Approach 1: Two Pointer

        int left = 0;
        int right = str.length()-1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;



        /*
        // Approach 2: Reverse + Compare

        StringBuilder revStr = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            revStr.append(str.charAt(i));
        }

        return str.contentEquals(revStr);
        */
    }

    public static void main(String[] args) {

        String str = "world";
        System.out.println("Word: " + str);

        boolean isValid = checkPalindrome(str);
        if(isValid)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome!");
    }
}
