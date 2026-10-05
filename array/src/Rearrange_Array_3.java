/**
 Rearrange array so arr[i] = i if possible.

 Approach: Cyclic Sort
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Rearrange_Array_3 {

    public static void rearrangeArray(int[] arr) {

        int i = 0;

        while (i < arr.length) {

            if (arr[i] >= 0 && arr[i] < arr.length && arr[i] != i) {

                int correctIndex = arr[i];

                if (arr[correctIndex] != correctIndex) {
                    int temp = arr[i];
                    arr[i] = arr[correctIndex];
                    arr[correctIndex] = temp;
                }
                else {
                    i++;
                }
            }
            else {
                i++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 0, 1, 5};

        System.out.println("Original Array : "
                + Arrays.toString(arr));

        rearrangeArray(arr);

        System.out.println("Rearranged Array : "
                + Arrays.toString(arr));
    }
}

