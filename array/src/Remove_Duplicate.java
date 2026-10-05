/**
 Remove all duplicate elements from the given array

 If array is unsorted
 Approach: LinkedHashSet
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 If array is sorted
 Approach: Two Pointer
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Remove_Duplicate {

    // If array is unsorted
    public static int[] removeDuplicate(int[] arr) {
        // Approach: LinkedHashSet

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int index = 0;

        for (int num : set) {
            result[index++] = num;
        }

        return result;


        /*
        // If array is sorted
        // Approach: Two Pointer

        int j = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[j]) {
                j++;
            }
            arr[j] = arr[i];
        }

        return  Arrays.copyOf(arr, j + 1);
        */
    }

    public static void main(String[] args) {

        int[] arr = {7, 4, 7, 5, 7, 8, 8};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] res = removeDuplicate(arr);
        System.out.print("After Remove duplicates: " + Arrays.toString(res));
    }
}
