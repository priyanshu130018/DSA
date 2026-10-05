/**
 Rearrange the array so that elements appear alternately in maximum and minimum order
 [max, min, second max, second min, ...]

 Approach: In-place Encoding Method
 Store two values in one index
 Old value → arr[i] % max
 New value → arr[i] / max
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)

 Approach: Sorting + Two Pointer
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 **/

import java.util.Arrays;

public class Rearrange_Array_1 {

    public static int[] rearrange_MaxMin(int[] arr) {
        // Approach 1: In-place Encoding Method

        // Store two values in one index
        // Old value → arr[i] % max
        // New value → arr[i] / max

        if (arr == null || arr.length == 0) return arr;

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int max = arr[arr.length-1] + 1;

        for (int i = 0; i < arr.length; i++) {

            // Store maximum element
            if (i % 2 == 0) {

                // arr[i] = original + new * max
                // % max-> original value
                arr[i] += (arr[right--] % max) * max;
            }

            // Store minimum element
            else {
                arr[i] += (arr[left++] % max) * max;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
        return arr;

        /*
         explanation
         [5,7,10], max=11
         a[0]= 5+ (10 % 11 * 11)= 115,
         a[1]= 7+ (115 % 11 * 11)= 62,
         a[2]= 10+ (62 % 11 * 11)= 87

         a[0]= 115/11 = 10
         a[1]= 62/11 = 5
         a[2]= 87/11= 7
         [10,5,7]
         */


        /*
        // Approach 2: Sorting + Two Pointer

        if (arr.length == 0) return arr;

        Arrays.sort(arr);

        int[] res = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        int k = 0;
        while (left <= right) {
            // max
            if (k < arr.length) {
                res[k++] = arr[right--];
            }
            // min
            if (k < arr.length) {
                res[k++] = arr[left++];
            }
        }
        return res;
        **/
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 9, 7, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] res = rearrange_MaxMin(arr);
        System.out.println("After Rearrange(max, min...): " + Arrays.toString(res));
    }
}
