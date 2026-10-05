/**
 Move all zeros to the end of the array while maintaining the relative order of non-zero element

 Approach: Two Pointer + Overwrite
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Two pointer + Swaping
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Move_Zero_2 {
    public static int[] moveZeroToEnd(int[] arr) {
        // Approach: Two pointer

        // Move all non-zero element to start
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[start++] = arr[i];
            }
        }

        while (start < arr.length) {
            arr[start++] = 0;
        }
        return arr;



        /*
        // Approach: Two pointer + Swaping

        // Swap each non-zero element with the leftmost zero position element
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != start) {
                    int temp = arr[i];
                    arr[i] = arr[start];
                    arr[start] = temp;
                }
                start++;
            }
        }
        return arr;
        */
    }

    public static void main(String[] args){

        int[] arr = {4, 0, 5, 0, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] res = moveZeroToEnd(arr);
        System.out.println("After move all zeros to end\nArray: " + Arrays.toString(res));
    }

}
