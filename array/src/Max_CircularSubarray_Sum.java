/**
 Find the maximum sum of any circular contiguous subarray.

 Approach: Kadane's Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Brute Force
 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Max_CircularSubarray_Sum {

    public static int maxCircularSum(int[] arr) {
        // Approach: Kadane's Algorithm

        if (arr == null || arr.length == 0)
            return 0;

        int totalSum = 0;

        int curMax = arr[0];
        int maxSum = arr[0];

        int curMin = arr[0];
        int minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {

            totalSum += arr[i];

            if (i == 0) continue;

            // Maximum Subarray Sum (Kadane)
            curMax = Math.max(curMax + arr[i], arr[i]);
            maxSum = Math.max(maxSum, curMax);

            // Minimum Subarray Sum (Kadane)
            curMin = Math.min(curMin + arr[i], arr[i]);
            minSum = Math.min(minSum, curMin);
        }

        // All elements are negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, totalSum - minSum);


        /*
        // Approach: Brute Force

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int curSum = 0;

            for (int j = 0; j < n; j++) {
                curSum += arr[(i + j) % n];
                maxSum = Math.max(maxSum, curSum);
            }
        }

        return maxSum;
        */
    }

    public static void main(String[] args) {

        int[] arr = {5, -3, 5};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = maxCircularSum(arr);
        System.out.println("Maximum Circular Subarray Sum: " + res);
    }
}