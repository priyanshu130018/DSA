/**
 Bubble Sort
 - Time Complexity:
   - Best Case: O(n)
   - Worst Case: O(n²)
 - Space Complexity: O(1)
 */

/**
 * Selection Sort
 * - Time Complexity:
 *   - Best/Average/Worst: O(n²)
 * - Space Complexity: O(1)
 *
 * Bubble Sort
 * - Time Complexity:
 *   - Best: O(n)
 *   - Average: O(n²)
 *   - Worst: O(n²)
 * - Space Complexity: O(1)
 *
 * Insertion Sort
 * - Time Complexity:
 *   - Best: O(n)
 *   - Average: O(n²)
 *   - Worst: O(n²)
 * - Space Complexity: O(1)
 *
 * Merge Sort
 * - Time Complexity:
 *   - Best/Average/Worst: O(n log n)
 * - Space Complexity: O(n)
 *
 * Quick Sort
 * - Time Complexity:
 *   - Best: O(n log n)
 *   - Average: O(n log n)
 *   - Worst: O(n²)
 * - Space Complexity:
 *   - Average: O(log n)
 *   - Worst: O(n)
 *
 * Heap Sort
 * - Time Complexity:
 *   - Best/Average/Worst: O(n log n)
 * - Space Complexity: O(1)
 *
 * Counting Sort
 * - Time Complexity: O(n + k)
 * - Space Complexity: O(n + k)
 *   (k = range of input values)
 *
 * Bucket Sort
 * - Best/Average: O(n)
 * - Worst: O(n²)
 * - Space Complexity: O(n)
 *
 * Radix Sort
 * - Time Complexity: O(d × n)
 *   (d = number of digits; effectively O(n) for fixed-size integers)
 * - Space Complexity: O(n)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Bubble_Sort {

    // BubbleSort Optimized: Compare neighbouring elements and swap
    public static void bubbleSort(int[] arr) {

        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }


     /**
     // BubbleSort
     public static void bubbleSort(int[] arr) {
         int low = 0;
         int high = arr.length-1;
         while (low < high) {
             for (int j= low; j < high; j++) {
                 if (arr[j] > arr[j+1]) {
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
             }
             high--;
         }
     }
     **/

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

         bubbleSort(arr);
         System.out.println("After:" + Arrays.toString(arr));

         sc.close();
     }
}
