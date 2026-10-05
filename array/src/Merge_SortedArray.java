/**
 Merge two sorted arrays into a single sorted array

 Approach: Two Pointer
 - Time Complexity: O(m+n)
 - Space Complexity: O(m+n)
 where
 m = size of array1
 m = size of array2
 **/

import java.util.Arrays;

public class Merge_SortedArray {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < arr1.length)
            merged[k++] = arr1[i++];

        while (j < arr2.length)
            merged[k++] = arr2[j++];

        return merged;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 4, 6};
        int[] arr2 = {2, 3, 7};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int[] res2 = mergeSortedArrays(arr1, arr2);
        System.out.println("New Merged Array: " + Arrays.toString(res2));
    }
}
