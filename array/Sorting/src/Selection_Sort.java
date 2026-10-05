/**
 Selection Sort:
 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Selection_Sort {

    // Selection Sort: Find the smallest element and place it at the beginning and repeat
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j= i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
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

        selectionSort(arr);
        System.out.println("After:" + Arrays.toString(arr));

        sc.close();
    }
}
