/**
 Given a binary string `target` and a string `s` containing all `0`s
 In one operation, flip all bits from any index to the end
 Find the minimum operations needed to make it equal to target

 Approach:
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 */

import java.util.Arrays;

public class Min_Suffix_Flip {

    public static int minFlip(String target) {

        char prev = '0';
        int count = 0;

        for (char c : target.toCharArray()) {
            if (c != prev) {
                prev = c;
                count++;
            }
        }
        return count;
    }

    public static void printArr(String target) {

        char[] arr = new char[target.length()];
        Arrays.fill(arr, '0');

        if (target.charAt(0) == '1') {
            flip(arr, '1', 0);
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 1; i < target.length(); i++) {

            if (target.charAt(i - 1) != target.charAt(i)) {
                flip(arr, target.charAt(i), i);
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    private static void flip(char[] arr, char val, int index) {
        for (int j = index; j < arr.length; j++) {
            arr[j] = val;
        }
    }

    public static void main(String[] args) {

        String str = "101100101101";
        System.out.println("Array: " + str);

        int res = minFlip(str);
        System.out.println("Min no of flip: " + res);
        printArr(str);
    }
}
