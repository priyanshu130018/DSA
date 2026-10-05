/**
 Find the Second-Smallest element in the given array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)

 Integer.MAX_VALUE = 2147483647
 **/

import java.util.Arrays;

public class Min_Element_2 {

    public static int find_2MinElement(int[] arr) {
        // Approach: Linear Traversal

        if(arr.length < 2) return -1;

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int val: arr) {
            if (val < min) {
                min2 = min;
                min = val;
            }
            else if (val > min && val < min2) {
                min2 = val;
            }
        }

        return (min2 == Integer.MAX_VALUE) ? -1 : min2;


        /*
         // Approach: Sorting

         Arrays.sort(arr);
         for (int i = 1; i < arr.length; i++) {
             if (arr[i] != arr[0]) {
                 return arr[i];
             }
         }
         return -1;
         */
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 4, 8};
        System.out.println("Array:" + Arrays.toString(arr));

        int min2 = find_2MinElement(arr);
        if (min2 == -1)
            System.out.println("Not found");
        else
            System.out.println("Second Smallest  Element: " + min2);
    }
}
