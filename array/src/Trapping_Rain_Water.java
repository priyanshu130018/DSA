/**
 Given an array where each element represents the height of a bar,
 Find the total amount of rainwater that can be trapped after raining

 Approach: Two Pointers + Greedy
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;

public class Trapping_Rain_Water {

    public static int trap(int[] height) {
        // Approach: Two Pointers + Greedy

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    water += leftMax - height[left];
                }
                left++;
            }
            else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Height: " + Arrays.toString(height));

        int res = trap(height);
        System.out.println("Total water trapped: " + res);
    }
}