/**
 Create a new array by concatenating the given array with itself

 Approach: Direct Copy
 - Time complexity: O(n)
 - Space complexity: O(n)

 Approach: Array Copy
 - Time complexity: O(n)
 - Space complexity: O(n)
*/

import java.util.Arrays;

class Concatenation_Array {

    public static int[] getConcatenation(int[] nums) {
        // Approach: Direct Copy

        int n = nums.length;
        int[] newArr = new int[2 * n];

        for (int i = 0; i < n; i++) {
            newArr[i] = nums[i];
            newArr[i + n] = nums[i];
        }

        return newArr;



        /*
        // Approach: Array Copy

        int n = nums.length;
        int[] newArr = new int[2 * n];

        System.arraycopy(nums, 0, newArr, 0, n);
        System.arraycopy(nums, 0, newArr, n, n);

        return newArr;
        */
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] result = getConcatenation(arr);
        System.out.println("New Array: " + Arrays.toString(result));
    }
}