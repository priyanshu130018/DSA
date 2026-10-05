/**
 Find an element that is greater than its neighboring elements.

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Find_Peak_Element {

    public static int findPeakElement(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1};

        System.out.println("Array: " + Arrays.toString(arr));

        int index = findPeakElement(arr);

        System.out.println("Peak Index: " + index);
        System.out.println("Peak Element: " + arr[index]);
    }
}
