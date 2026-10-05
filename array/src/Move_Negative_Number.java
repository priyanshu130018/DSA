/**
 Move all negative numbers to the end of the array

 Approach: Two Pointer + Swapping (Order)
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Partition Method (Unorder)
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Move_Negative_Number {

    public static int[] moveNegative(int[] arr) {
        // Approach: Two Pointer + Swapping

        // Move positive numbers to front
        int j=0;
        for (int i=0; i<arr.length; i++) {
            if(arr[i] >= 0){
                if (i != j){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }
        return arr;


        /*
        // Approach: Partition Method

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] >= 0) {
                left++;
            }
            while (left < right && arr[right] < 0) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
         **/
    }

    public static void main(String[] args) {

        int[] arr = {3, -8, 5, -7, 1};
        System.out.println("Array: " + Arrays.toString(arr));

        int[] res = moveNegative(arr);
        System.out.println("New Array: " + Arrays.toString(res));
    }
}

