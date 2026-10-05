/**
 Find the Second-Largest element in the given array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)

 Integer.MIN_VALUE = -2147483648
 **/

import java.util.Arrays;

public class Max_Element_2 {

    public static int find_2MaxElement(int[] arr) {
        // Approach: Linear Traversal

        if(arr.length < 2) return -1;

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                max2 = max;
                max = val;
            }
            else if (val < max && val > max2) {
                max2 = val;
            }
        }

        return (max2 == Integer.MIN_VALUE) ? -1 : max2;


        /*
         // Approach: Sorting

         Arrays.sort(arr);
         for (int i = arr.length - 2; i >= 0; i--) {
             if (arr[i] != arr[arr.length - 1]) {
                 return arr[i];
             }
         }
         return -1;
         */
    }


    public static void main(String[] args) {

        int[] arr = {5, 2, 4, 8};
        System.out.println("Array:" + Arrays.toString(arr));

        int max2 = find_2MaxElement(arr);
        if (max2 == -1)
            System.out.println("Not found");
        else
            System.out.println("Second Largest Element: " + max2);
    }
}

