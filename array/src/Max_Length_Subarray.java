/**
 Find the length of maximum subarray of odd-even in order

 Approach: Brute Force
 - Time Complexity: O()
 - Space Complexity: O()
 */

import java.util.Arrays;

public class Max_Length_Subarray {
    public static int findLength(int[] arr) {
        // Approach: Brute Force

        int count = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {

            if ((arr[i]%2 == 0 && arr[i-1]%2 != 0)
                    || (arr[i]%2 != 0 && arr[i-1]%2 == 0)) {

                count++;
                res = Math.max(res, count);
            }
            else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {5,10,20,6,3,8};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = findLength(arr);
        System.out.println("Length of max subarray: " + res);
    }
}
