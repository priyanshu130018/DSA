/**
 Find the minimum length subarray whose sum is greater than or equal to target

 Approach: Sliding Window
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Minimum_Size_Subarray_Sum {

    public static int minSubArrayLen(int target, int[] arr) {

        int left = 0;
        int windowSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {

            windowSum += arr[right];

            while (windowSum >= target) {

                minLen = Math.min(minLen, right - left + 1);

                windowSum -= arr[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        System.out.println(minSubArrayLen(target, arr));
    }
}
