/**
 Find the maximum sum that can be obtained from continuous subarray of the array

 Approach: Kadane's Algorithm
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)

 Approach: Brute Force
 -  Time Complexity: O(n²)
 -  Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Max_Subarray_Sum {

    public static int MaxSum(int[] arr) {
        // Approach: Kadane's Algorithm

        if (arr.length == 0) return 0;

        int maxSum = arr[0];
        int curSum = arr[0];

        for(int i = 1; i < arr.length; i++){

            curSum = Math.max(curSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;



        /*
        // Approach: Brute Force

        int maxSum = arr[0];
        for (int i=0; i<arr.length; i++) {

            int curSum = 0;
            for (int j=i; j<arr.length; j++) {

                curSum += arr[j];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
        **/
    }

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = MaxSum(arr);
        System.out.println("Maximum subarray sum: " + res);
    }
}
