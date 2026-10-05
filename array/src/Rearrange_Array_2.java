/**
 Rearrange the array so that elements appear alternately in positive-negative order
 [positive, negative, positive, negative, ...]

 Approach: Two Pointer + Extra Array
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Rearrange_Array_2 {

    public static int[] rearrangeArray(int[] arr) {

        int[] result = new int[arr.length];

        int positive = 0;
        int negative = 1;

        for (int num : arr) {

            if (num >= 0) {
                result[positive] = num;
                positive += 2;
            }
            else {
                result[negative] = num;
                negative += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println("Original Array : " + Arrays.toString(arr));

        int[] result = rearrangeArray(arr);
        System.out.println("Rearranged Array : " + Arrays.toString(result));
    }
}

