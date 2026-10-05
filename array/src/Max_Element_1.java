/**
 Find the largest elements in the given array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Max_Element_1 {

    public static int findMaxElement(int[] arr) {
        // Approach: Linear Traversal

        int max = arr[0];
        for (int val: arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 6, 1};
        System.out.println("Array: " + Arrays.toString(arr));

        int max = findMaxElement(arr);
        System.out.println("Max Element: " + max);
    }
}
