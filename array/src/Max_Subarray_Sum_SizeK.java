/**
 Find the maximum sum of a subarray of size k

 Approach: Sliding Window
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Max_Subarray_Sum_SizeK {

    public static int maxSum(int[] arr, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window
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
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("k: " + k);

        int result = maxSum(arr, k);
        System.out.println("Maximum Sum = " + result);
    }
}
