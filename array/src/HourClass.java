/**
 Given a 2D matrix, find the maximum sum of any hourglass pattern
 Hour Glass Pattern:
 a b c
   d
 e f g

 Approach: Matrix Traversal
 - Time Complexity: O((row-2) * (col-2))
 - Space Complexity: O(1)
 **/

import java.util.Scanner;

public class HourClass {

    public static int findMaxHourglassSum(int[][] arr) {
        // Approach: Matrix Traversal

        int row = arr.length;
        int col = arr[0].length;

        if (row < 3 || col < 3) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        // Traverse every possible hourglass
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {

                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 0, 0},
                {0, 1, 0, 0, 0},
                {2, 1, 4, 0, 0},
                {0, 0, 0, 2, 0},
                {1, 2, 3, 1, 1}
        };

        System.out.println("Maximum Hourglass Sum: " + findMaxHourglassSum(arr));
    }
}