/**
 Determine whether it is possible to reach the last index of the array.

 Approach: Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Jump_Game_1 {

    public static boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > farthest) {
                return false;
            }

            farthest = Math.max(
                    farthest,
                    i + nums[i]
            );

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("Array: " + Arrays.toString(nums));

        boolean result = canJump(nums);

        System.out.println("Can Reach Last Index: " + result);
    }
}
