/**
 Find the minimum sum that can be obtained from continuous subarray of the given array

 Approach: Kadane's Algorithm
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)

 Approach: Brute Force
 -  Time Complexity: O(n²)
 -  Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Min_Subarray_Sum {

    public static int minSum(int[] arr) {
        // Approach: Kadane's Algorithm

        if (arr.length == 0) return 0;

        int minsum = arr[0];
        int cursum = arr[0];

        // Sum of subarray is minimum
        for(int i = 1; i < arr.length; i++){

            cursum = Math.min(cursum + arr[i], arr[i]);
            minsum = Math.min(minsum, cursum);
        }
        return minsum;



        /*
        // Approach: Brute Force

        int minsum = arr[0];
        for (int i = 0; i < arr.length; i++) {

            int cursum = 0;
            for (int j = i; j < arr.length; j++) {

                cursum += arr[j];
                minsum = Math.min(minsum, cursum);
            }
        }
        return minsum;
        **/
    }

    public static void main(String[] args) {

        int[] arr = {4, -2, -5, 1, 6};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = minSum(arr);
        System.out.println("Minimum subarray sum: " + res);
    }
}

