/**
 Find the smallest elements in the given array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Min_Element_1 {

    public static int findMinElement(int[] arr) {
        // Approach: Linear Traversal

        int min = arr[0];
        for (int val: arr) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 6, 1};
        System.out.println("Array: " + Arrays.toString(arr));

        int min = findMinElement(arr);
        System.out.println("Min Element: " + min);
    }
}
