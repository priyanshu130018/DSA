/**
 Find the minimum number of group flips needed to make all elements the same

 Approach: Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Min_Group_Flip {

    public static int minFlip(int[] arr) {

        int first = arr[0];

        int flip = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]
                    && arr[i] != first) {
                flip++;
            }
        }

        return flip;
    }

    public static void main(String[] args) {

        // 0 1 0 0 1 1 1 0
        // 0 1 0 0 1 1 0 1 0 0 1 0 1
        int[] arr = {0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = minFlip(arr);
        System.out.println("Min no of flip: " + res);
    }
}
