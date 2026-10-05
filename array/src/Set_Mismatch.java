/**
 Find the one duplicated number and the one missing number in an array containing 1 to n

 Approach: Counting
 - Time complexity: O(n)
 - Space complexity: O(n)
 */

import java.util.Arrays;

class Set_Mismatch {

    public static int[] findErrorNums(int[] nums) {

        // Approach: Counting
        int[] count = new int[nums.length + 1];

        for (int num : nums) {
            count[num]++;
        }

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) {
                duplicate = i;
            }

            if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 4};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] result = findErrorNums(arr);
        System.out.println("Result: " + Arrays.toString(result));
    }
}