import java.util.Arrays;

/**
 Find the maximum number of consecutive 1s if you can flip at most k zeros.

 Approach: Sliding Window
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

public class Max_Consecutive_Ones_3 {

    public static int longestOnes(int[] arr, int k) {

        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {

            if (arr[right] == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (arr[left] == 0) {
                    zeros--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Max Consecutive 1s : " + longestOnes(arr, k));
    }
}
