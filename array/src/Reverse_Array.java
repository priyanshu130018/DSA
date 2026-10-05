/**
 Find the reverse of the given array in-place

 Approach: Two Pointer
 -  Time Complexity: O(n)
 -  Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Reverse_Array {

    public static void reverseArray(int[] arr) {
        // Approach: Two Pointer

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 9, 7, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        reverseArray(arr);
        System.out.println("Reverse Array: " + Arrays.toString(arr));
    }
}