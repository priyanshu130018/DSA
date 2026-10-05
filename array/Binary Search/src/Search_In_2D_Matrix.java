/**
 Search for a target element in a sorted 2D matrix.

 Approach: Binary Search
 - Time Complexity: O(log(m * n))
 - Space Complexity: O(1)
 **/

public class Search_In_2D_Matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D index
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        boolean result = searchMatrix(matrix, target);

        System.out.println("Target Found = " + result);
    }
}

