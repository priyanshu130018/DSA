/**
 Find the maximum number of consecutive 1s if you can flip at most one 0

 Approach: Sliding Window
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Max_Consecutive_Ones_2 {

    public static int maxConsecutiveOnes(int[] arr) {

        int left = 0;
        int zeroCount = 0;
        int maxCount = 0;

        for (int right = 0; right < arr.length; right++) {

            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {

                if (arr[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1};

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Max Consecutive 1s : " + maxConsecutiveOnes(arr));
    }
}
