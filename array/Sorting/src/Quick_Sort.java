/**
 Quick Sort
 - Time Complexity:
   - Average Case: O(n log n)
   - Worst Case: O(n²)
 - Space Complexity: O(log n)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Quick_Sort {

    // Quick Sort: Chooses a pivot element and recursively sorts left and right parts
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Get pivot index
            int pi = partition(arr, low, high);

            // recursively sort left and right halves
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partitioning
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap smaller elements left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

        quickSort(arr, 0, arr.length - 1);
        System.out.println("After:" + Arrays.toString(arr));

        sc.close();
    }
}
