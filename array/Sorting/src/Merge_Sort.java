/**
 Merge Sort
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sort {

    // Merge Sort: Divide first, then merge sorted halves
    public static void mergeSort(int[] arr, int left, int right) {

        // Divide and Conquer
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort left and right halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge Two Sorted Arrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge while both arrays have elements
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n=sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before:" + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After:" + Arrays.toString(arr));

        sc.close();
    }
}
