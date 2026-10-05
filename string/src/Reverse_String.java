/**
 Reverse the string by letter

 Approach 1: Traversing from End
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach 2: Two Pointer + Character Array
 - Time Complexity: O(n)
 - Space Complexity: O(n)


 Reverse the string by word

 Approach: Split + Traverse Backward
 - Time Complexity: O(n)
 - Space Complexity: O(n)


 Reverse only vowels in string

 Approach: Two Pointer
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

public class Reverse_String {

    // Reverse the string by letter

    public static void ReverseByLetter(String s) {
        // Approach 1: Traversing from End

        String result="";
        for(int i=s.length()-1; i>=0; i--) {
                result += s.charAt(i);
        }
        System.out.println("Given word: " +s);
        System.out.println("After reverse: " +result);


        /*
        // Approach 2: Two Pointer + Character Array

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println(new String(arr));
        */
    }



    // Reverse the string by word

    public static void ReverseByWord(String s) {
        // Approach: Split + Traverse Backward

        String result = "";

        // Trim String and store into String array
        String[] word = s.trim().split(" ");

        // Concatenation the word into result from array
        for(int i = word.length - 1; i >= 0; i--) {
            result += word[i];
            if (i > 0) result += " ";
        }

        System.out.println("Given string: " +s);
        System.out.println("After reverse: " + result);
    }



    // Reverse only vowels in string

    public static void ReverseOnlyVowel(String s) {
        // Approach: Split + Traverse Backward

        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length-1;

        while (left < right) {
            // check if vowels from left
            while (left < right && vowels.indexOf(arr[left]) == -1) left++;

            // check if vowels from right
            while (left < right && vowels.indexOf(arr[right]) == -1) right--;

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        System.out.println("Given word: " + s);
        System.out.println("After reverse vowel: " + new String(arr));
    }


    public static void main(String[] args) {

        ReverseByLetter("hello");
        System.out.println();

        ReverseByWord("hello I am Priyanshu");
        System.out.println();

        ReverseOnlyVowel("hello");
    }
}
