/**
 Find the minimum number of jumps needed to reach the last index of the array
 Each value represents the maximum number of positions you can jump forward

 Approach: Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Min_Jump {

    public static int minJump(int[] arr) {

        if (arr.length <= 1) return 0;

        int jump = 0;
        int currentEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            maxReach = Math.max(maxReach, i + arr[i]);

            if (i == currentEnd) {
                jump++;
                currentEnd = maxReach;
            }
        }

        return jump;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 1, 4};

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Minimum Jumps : " + minJump(arr));
    }
}
