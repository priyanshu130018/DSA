/**
 Find the maximum product that can be obtained from continuous subarray of the given array

 Approach: DP
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)

 Approach: Prefix-Suffix Method
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)

 Integer.MIN_VALUE = -2147483648
 **/

import java.util.Arrays;

public class Max_Subarray_Product {

    public static int MaxProduct(int[] arr) {
        // Approach 1: DP

        if (arr.length == 0) return 0;

        int curMax = arr[0];
        int curMin = arr[0];
        int maxProd = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // -2,3,4
            int temp = curMax;
            curMax = Math.max(arr[i],
                      Math.max(curMax * arr[i], curMin * arr[i]) );

            curMin = Math.min(arr[i],
                      Math.min(temp * arr[i], curMin * arr[i]) );

            maxProd = Math.max(maxProd, curMax);
        }
        return maxProd;



        /*
        // Approach: Prefix-Suffix Method

        int n = arr.length;
        int prefix = 1, suffix = 1;
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n-1-i];

            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
        */

    }

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = MaxProduct(arr);
        System.out.println("Maximum subarray product: " + res);
    }
}

