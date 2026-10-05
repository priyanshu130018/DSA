/**
 Transpose of Matrix

 Approach: Matrix Traversal
 - Time Complexity: O(n × m)
 - Space Complexity: O(n × m)
 */
public class Transpose_Matrix {

    public static int[][] transpose(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
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

        int[][] ans = transpose(matrix);
        System.out.println("Transpose Matrix:");
        display(ans);
    }
}
