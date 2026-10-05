/**
 Rotate the array to the left by k positions

 Approach: Reversal Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Brute Force
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.Arrays;

public class Rotated_Array_Left_K {

    // Approach: Reversal Algorithm
    public static int[] rotateArr(int[] arr, int k) {

        if (arr == null || arr.length == 0) return arr;

        int n = arr.length;
        k = k % n;

        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);

        // [4 5 9 7 3] n=5, k=2
        // [4 5 | 9 7 3] => [5 4 | 9 7 3] => [5 4 | 3 7 9] => [9 7 3 4 5]
        return arr;
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }



    /*
    // Approach: Brute Force

    public static int[] rotateArray(int[] arr, int k) {

        if (arr == null || arr.length == 0) return arr;
        int n=arr.length;
        k = k % n;
        int[] tempArr = new int[k];

        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[i];
        }
        for (int i = 0; i < n-k; i++) {
            arr[i] = arr[i+k];
        }
        for (int i = 0; i < k; i++) {
            arr[n-k+i] = tempArr[i];
        }
        return arr;
    }
    */


    public static void main(String[] args) {

        int[] arr = {4, 5, 9, 7, 3};
        int k = 2;
        System.out.println("Before\nArray: " + Arrays.toString(arr));

        int[] res = rotateArr(arr, k);
        System.out.println("After\nArray Rotate by " + k + " positions: " + Arrays.toString(res));
    }
}

