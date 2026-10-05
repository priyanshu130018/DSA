/**
 Given an array where each element represents the height of a vertical line,
 Find the maximum amount of water that can be contained between any two lines

 Approach: Two Pointers
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Container_Most_Water {

    public static int maxArea(int[] height) {
        // Approach: Two Pointers

        int left = 0, right = height.length-1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int curArea = minHeight * width;

            maxArea = Math.max(curArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            }
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {9, 2, 4, 2, 3, 7, 1, 6, 5};
        System.out.println("Height: " + Arrays.toString(height));

        int res = maxArea(height);
        System.out.println("Maximum Water: " + res);
    }
}
