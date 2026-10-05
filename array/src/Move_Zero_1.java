/**
 Move all zeros to the beginning of the array while maintaining the relative order of non-zero elements

 Approach: Two Pointer
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Move_Zero_1 {
    public static int[] moveZeroToStart(int[] arr) {
        // Approach: Two pointer

        // Move all zero element to start
        int n = arr.length;
        int end  = n-1;
        for(int i = n-1; i >= 0; i--) {

            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;

                end--;
            }
        }
        return arr;
    }

    public static void main(String[] args){

        int[] arr = {4, 0, 5, 0, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] res = moveZeroToStart(arr);
        System.out.println("After move all zeros to start\nArray: " + Arrays.toString(res));
    }
}
