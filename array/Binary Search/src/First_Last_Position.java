/**
 Find the first and last position of a target element in a sorted array.

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class First_Last_Position {

    public static int[] searchRange(int[] arr, int target) {

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int[] result = searchRange(arr, target);

        System.out.println("First Position: " + result[0]);
        System.out.println("Last Position: " + result[1]);
    }
}
