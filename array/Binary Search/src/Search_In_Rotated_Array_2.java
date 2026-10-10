/**
 Search for a target element in a rotated sorted array that may contain duplicates
 return true if the target exists

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Search_In_Rotated_Array_2 {

    public static boolean search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // shrink the window
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            }

            // If Left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;   // Target is in left half
                } else {
                    left = mid + 1;    // Search right half
                }

            }
            // Right half is sorted
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;    // Target is in right half
                } else {
                    right = mid - 1;   // Search left half
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2,5,6,0,0,1,2};
        int target = 3;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        boolean result = search(arr, target);

        System.out.println("Target Index: " + result);
    }
}
