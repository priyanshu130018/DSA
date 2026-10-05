/**
 Merge two unsorted arrays into a single sorted array

 Approach: Merge + Sorting
 - Time Complexity: O((m+n) log(m+n))
 - Space Complexity: O(m+n)

 Approach: Sorting + Two Pointer
 - Time Complexity: O(m log m + n log n)
 - Space Complexity: O(m+n)
 where
 m = size of array1
 m = size of array2
 **/

import java.util.Arrays;

public class Merge_UnsortedArray {

    public static int[] mergeUnSortedArrays(int[] arr1, int[] arr2){
        // Approach: Merge + Sorting

        int[] mergeArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            mergeArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            mergeArr[arr1.length + i] = arr2[i];
        }

        Arrays.sort(mergeArr);

        return mergeArr;


        /*
        // Approach: Sorting + Two Pointer

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] mergeArr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length){

            if (arr1[i] <= arr2[j]){
                mergeArr[k++] = arr1[i++];
            } else {
                mergeArr[k++] = arr2[j++];
            }
        }

        while(i < arr1.length) {
            mergeArr[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            mergeArr[k++] = arr2[j++];
        }
        return mergeArr;
        **/
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 2, 8};
        int[] arr2 = {1, 7, 3};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int[] res1 = mergeUnSortedArrays(arr1, arr2);
        System.out.println("New Merged Array: " + Arrays.toString(res1));
    }
}
