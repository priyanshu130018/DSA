/**
 Sort the array in descending Order

 Approach: Selection Sort
 - Time Complexity:
     Best/Average/Worst Case: O(n²)
 - Space Complexity: O(1)

 Approach: Bubble Sort
 - Time Complexity:
     Best Case:  O(n)
     Average Case:  O(n²)
     Worst Case:  O(n²)
 - Space Complexity:  O(1)

 Approach: Quick Sort
 - Time Complexity:
     Best/Average Case: O(n log n)
     Worst Case: O(n²)
 - Space Complexity:
     Average Case: O(log n)
     Worst Case: O(n)

 Merge Sort
 - Time Complexity:
     Best/Average/Worst Case: O(n log n)
 - Space Complexity: O(n)
 **/

import java.util.Arrays;

public class Sort_Descending {


    // Selection Sort: Find the largest element and place it at the beginning and repeat
    public static void selectionSort(int[] arr) {
        for (int i=0; i < arr.length-1; i++) {
            int max = i;
            for (int j=i+1; j < arr.length; j++) {
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (max != i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    }



    // BubbleSort Optimized: Compare neighbouring elements and swap
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                     swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /*
    // BubbleSort
    public static void bubbleSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while (low < high) {
            for (int j=low; j<high; j++) {
                 if (arr[j] < arr[j+1]) {
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
            }
            high--;
        }
    }
    */



    // Quick Sort: Chooses a pivot element and recursively sorts left and right parts
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Get pivot index
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partitioning
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;

                // Swap larger elements to left side
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





    // Merge Sort: Divide first, then merge sorted halves
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    // Merge Two Sorted Arrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge while both arrays have elements
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
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

        int[] arr = {8, 3, 1, 7, 4, 2, 9};

        System.out.println("Original Array : " + Arrays.toString(arr));

        int[] arr1 = arr.clone();
        selectionSort(arr1);
        System.out.println("Selection Sort : " + Arrays.toString(arr1));

        int[] arr2 = arr.clone();
        bubbleSort(arr2);
        System.out.println("Bubble Sort    : " + Arrays.toString(arr2));

        int[] arr3 = arr.clone();
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println("Quick Sort     : " + Arrays.toString(arr3));

        int[] arr4 = arr.clone();
        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge Sort     : " + Arrays.toString(arr4));
    }
}




