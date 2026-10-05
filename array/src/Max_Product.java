/**
 Find the max product of any three number from the given array

 Approach: One Pass
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)

 Approach: Sorting
 -  Time Complexity: O(n log n)
 -  Space Complexity: O(1)

 Integer.MIN_VALUE = -2147483648
 Integer.MAX_VALUE = 2147483647
 **/

import java.util.Arrays;

public class Max_Product {

    public static int maxProduct(int[] arr) {

        if (arr.length < 3) return -1;

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int val : arr) {

            // Max
            if(val >= max) {
                max3 = max2;
                max2 = max;
                max = val;
            }
            else if (val >= max2) {
                max3 = max2;
                max2 = val;
            }
            else if (val > max3) {
                max3 = val;
            }

            // Min
            if(val <= min){
                min2 = min;
                min = val;
            }
            else if(val <= min2){
                min2 = val;
            }
        }

        return Math.max(
                max * max2 * max3,
                max * min * min2
        );
    }

    public static void main(String[] args) {

        int[] arr = {-1, 2, -3, 4};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = maxProduct(arr);
        System.out.println("Maximum product: " + res);
    }
}
