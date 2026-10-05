/**
 Find the union of two array

 Approach: Sorting + Two Pointer
 - Time Complexity: O(m log m + n log n), if sorted O(n+m)
 - Space Complexity: O(1)

 Approach: HashSet
 - Time Complexity: O(m + n)
 - Space Complexity: O(m + n)
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Union_of_Array {
    public static void unionArr(int[] arr1, int[] arr2) {
        // Approach: Sorting + Two Pointer

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        Integer last = null;

        while (i < arr1.length && j < arr2.length) {

            int val;

            if (arr1[i] < arr2[j]) {
                val = arr1[i++];
            }
            else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            }
            else {
                val = arr1[i];
                i++;
                j++;
            }

            // Avoid duplicates
            if (last == null || val != last) {
                System.out.print(val + " ");
                last = val;
            }
        }

        // Remaining elements
        while (i < arr1.length) {
            if (last == null || arr1[i] != last) {
                System.out.print(arr1[i] + " ");
                last = arr1[i];
            }
            i++;
        }

        while (j < arr2.length) {
            if (last == null || arr2[j] != last) {
                System.out.print(arr2[j] + " ");
                last = arr2[j];
            }
            j++;
        }


        /*
        // Approach: HashSet

        Set<Integer> set = new HashSet<>();
        for (int x : arr1) {
            set.add(x);
        }
        for (int x : arr2) {
            set.add(x);
        }
        for (int x : set) {
            System.out.print(x + " ");
        }
        */
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 7, 3, 9, 4};
        int[] arr2 = {5, 9, 2, 7, 6};

        System.out.println("Array1:" + Arrays.toString(arr1));
        System.out.println("Array2:" + Arrays.toString(arr2));

        System.out.print("Union of two array: ");
        unionArr(arr1,arr2);
    }
}
