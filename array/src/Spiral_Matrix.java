/**
 Spiral Matrix
 Print all elements of the given matrix in spiral order

 Approach : Boundary Traversal / Spiral Traversal
 - Time Complexity : O(n × m)
 - Space Complexity: O(1)
 **/

public class Spiral_Matrix {

    public static void spiralMatrix(int[][] matrix) {
        // Approach : Boundary Traversal / Spiral Traversal

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left → Right
            for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }
            top++;

            // Top → Bottom
            for (int row = top; row <= bottom; row++) {
                System.out.print(matrix[row][right] + " ");
            }
            right--;

            // Right → Left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;
            }

            // Bottom → Top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(matrix[row][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Spiral Matrix:");
        spiralMatrix(matrix);
    }
}