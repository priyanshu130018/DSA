/**
 Find the minimum element in a rotated sorted array

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Min_In_Rotated_Array {

    public static int findMin(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return arr[left];
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Array: " + Arrays.toString(arr));

        int result = findMin(arr);
        System.out.println("Minimum Element: " + result);
    }
}
