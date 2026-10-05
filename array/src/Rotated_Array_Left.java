/**
 Rotate the array by 1 position to left

 Approach: Shift Left
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Adjacent Swapping
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Rotated_Array_Left {

    public static int[] rotateLeftSwap(int[] arr){
        // Approach: Shift Left

        if (arr.length <= 1) return arr;

        int temp = arr[0];
        for(int i = 0; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;


        /*
        // Approach: Adjacent Swapping

        for(int i = 0; i < arr.length-1; i++){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        return arr;
        */
    }

    public static void main(String[] args) {

        int[] arr = {5, 8, 0, 9, 1};
        System.out.println("Array:" + Arrays.toString(arr));

        int[] resL = rotateLeftSwap(arr);
        System.out.println("After Left rotation: " + Arrays.toString(resL));
    }
}
