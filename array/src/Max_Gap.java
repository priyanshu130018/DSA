/**
 Find the maximum difference between two consecutive elements after sorting the array

 Approach: Bucket Sort
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach:  Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)

 Approach: Radix Sort
 - Time Complexity: O(d × (n + k))
 - Space Complexity: O(n + k)

 d = number of digits in the maximum element
 k = radix/base (10 for decimal integers)
 */

import java.util.Arrays;

public class Max_Gap {

    public static int maximumGap1(int[] arr) {

        // Approach: Bucket Sort

        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // All elements are the same
        if (min == max) return 0;


        // Calculate bucket size and bucket count
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Put each number into its bucket
        for (int num : arr) {
            int index = (num - min) / bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
            used[index] = true;
        }

        int maxGap = 0;
        int prevMax = min;

        // Compare adjacent non-empty buckets
        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;




        /*
        // Approach:  Sorting

        if (arr == null || arr.length < 2) return 0;

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            max = Math.max(arr[i+1] - arr[i], max);
        }
        return max;
        */
    }


    /*
    // Approach: Radix Sort
    public static int maximumGap2(int[] arr) {

        if (arr == null || arr.length < 2) return 0;

        radixSort(arr);

        int maxGap = 0;
        for (int i = 1; i < arr.length; i++) {
            maxGap = Math.max(maxGap, arr[i] - arr[i - 1]);
        }
        return maxGap;
    }

    private static void radixSort(int[] arr) {
        int max = arr[0];

        // Find maximum element
        for (int val : arr) {
            max = Math.max(max, val);
        }

        // Sort by each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count frequency of each digit
        for (int val : arr) {
            int digit = (val / exp) % 10;
            count[digit]++;
        }

        // Prefix sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        // Copy back
        System.arraycopy(output, 0, arr, 0, n);
    }
    */


    public static void main(String[] args) {

        int[] arr = {34, 26, 19, 21, 49, 42};
        System.out.println("Array: " + Arrays.toString(arr));
        int res = maximumGap1(arr);
        System.out.println("Max Gap between two consecutive element: " + res);
    }
}
