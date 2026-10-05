/**
 Count the number of Inversions in an array.
 Inversion: A pair of indices (i,j) such that i < j and arr[i] > arr[j]

 Approach: Merge Sort
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)

 Approach: Brute Force
 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Count_Inversion {

    // Approach: Merge Sort
    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Divide and Conquer
    public static int mergeSort(int[] arr, int low, int high) {
        int count=0;

        // Divide until subarray contains only one element
        if (low < high) {
            int mid = low+(high-low)/2;

            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid+1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    // Merge Two Sorted Halves
    public static int merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low, j = mid+1;
        int k = 0;
        int count = 0;

        while (i <= mid && j <= high) {

            // No inversion
            // if left element is smaller or equal to arr[j]
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }

            // Inversion found
            // since left half is sorted, all elements from i to mid are greater than arr[j]
            else {
                count +=(mid-i+1);
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back to original array
        System.arraycopy(temp, 0, arr, low, temp.length);

        return count;
    }

    /*
    // Approach: Brute Force

    public static int countInversions(int[] arr) {
        int count=0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(i < j && arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    */


    public static void main(String[] args) {

        int[] arr = {5, 6, 8, 6, 2};
        System.out.println("Given array:" + Arrays.toString(arr));

        int res = countInversions(arr);
        System.out.println("Total inversions in array: " + res);
    }
}


