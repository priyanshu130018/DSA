/**
 Find the minimum number of jumps needed to reach the last index of the array.

 Approach: Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Jump_Game_2 {

    public static int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("Array: " + Arrays.toString(nums));

        int result = jump(nums);

        System.out.println("Minimum Jumps: " + result);
    }
}
