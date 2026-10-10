/**
 Search for a target element in a sorted array and return its index

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Binary_Search {

    public static int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int result = search(arr, target);

        System.out.println("Target Index: " + result);
    }
}
