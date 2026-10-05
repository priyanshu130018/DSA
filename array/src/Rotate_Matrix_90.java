/**
 Rotate the given square matrix by 90° clockwise

 Approach: Transpose + Reverse
 - Time Complexity: O(n²)
 - Space Complexity: O(1)

 Approach: Brute Force
 - Time Complexity: O(n²)
 - Space Complexity: O(n²)
 **/

public class Rotate_Matrix_90 {

    public static void rotate(int[][] matrix) {

        // Approach: Transpose + Reverse Each Row

        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[i].length-1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

        /*
        // Approach: Brute Force

        int[][] temp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
        **/
    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original Matrix:");
        display(matrix);

        rotate(matrix);
        System.out.println("\nMatrix After 90° Clockwise Rotation:");
        display(matrix);
    }
}
