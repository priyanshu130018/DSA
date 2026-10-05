/**
 Find the maximum sum of a subarray of size k

 Approach: Fixed Sliding Window
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Max_Subarray_Sum_SizeK {

    public static int maxSubarraySum(int[] arr, int k) {

        if (arr.length < k) return 0;

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];
            windowSum -= arr[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("K : " + k);

        System.out.println("Maximum Subarray Sum : " + maxSubarraySum(arr, k));
    }
}
