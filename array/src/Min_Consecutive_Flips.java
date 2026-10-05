/**
 Find the minimum number of consecutive flips needed to make all elements the same

 Approach: Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Min_Consecutive_Flips {

    public static int minFlips(int[] arr) {

        int flips = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                flips++;
            }
        }

        return flips;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0};
        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Minimum Flips : " + minFlips(arr));
    }
}
