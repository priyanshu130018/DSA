/**
 Rotate the array by 1 position to the right

 Approach: Shift Right
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Adjacent Swapping
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Rotated_Array_Right {

    public static int[] rotateRightSwap(int[] arr){
        // Approach: Right Shift

        if (arr.length <= 1) return arr;

        int temp = arr[arr.length-1];
        for(int i = arr.length-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;



        /*
        // Approach: Adjacent Swapping

        for(int i = arr.length-1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        return arr;
        */
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 3, 9, 4};
        System.out.println("Array:" + Arrays.toString(arr));

        int[] resR = rotateRightSwap(arr);
        System.out.println("After Right rotation: " + Arrays.toString(resR));
    }
}

