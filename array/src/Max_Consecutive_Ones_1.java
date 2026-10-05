/**
 Find the maximum number of consecutive 1s in a binary array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Max_Consecutive_Ones_1 {

    public static int maxConsecutiveOnes(int[] arr) {

        int count = 0;
        int maxCount = 0;

        for (int num : arr) {

            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1};

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Max Consecutive 1s : " + maxConsecutiveOnes(arr));
    }
}
