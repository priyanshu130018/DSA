/**
 For each number, find how many numbers in the array are smaller than it

 Approach: Counting
 - Time complexity: O(n)
 - Space complexity: O(1)

 Approach: Brute Force
 - Time complexity: O(n²)
 - Space complexity: O(n)
 */

import java.util.Arrays;

class SmallNum_Than_Curr {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        // Approach: Counting
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        // Convert frequency into cumulative count
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }

        return res;



        /*
        // Approach: Brute Force
        int[] res = new int[nums.length];

        int count = 0;
        int num;

        for (int i = 0; i < nums.length; i++) {
            num = nums[i];

            int j = 0;
            while (j < nums.length) {
                if (num > nums[j]) {
                    count++;
                }
                j++;
            }

            res[i] = count;
            count = 0;
        }
        return res;
        */
    }

    public static void main(String[] args) {

        int[] arr = {8, 1, 2, 2, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] result = smallerNumbersThanCurrent(arr);
        System.out.println("Result: " + Arrays.toString(result));
    }
}