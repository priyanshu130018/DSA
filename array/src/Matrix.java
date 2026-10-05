/**
 Matrix

 Time Complexity:
 - Print Matrix         : O(n × m)
 - Sum of All Elements  : O(n × m)
 - Max Element          : O(n × m)
 - Min Element          : O(n × m)
 - Row Sum              : O(n × m)
 - Column Sum           : O(n × m)
 - Transpose Matrix     : O(n × m)
 - Search Element       : O(n × m)
 - Main Diagonal        : O(n)
 - Secondary Diagonal   : O(n)

 Space Complexity: O(1)
 **/

public class Matrix {

    // Print Matrix
    static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Sum of All Elements
    public static int sumMatrix(int[][] matrix) {

        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    // Max Element
    public static int findMax(int[][] matrix) {

        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max)
                    max = num;
            }
        }
        return max;
    }

    // Min Element
    public static int findMin(int[][] matrix) {

        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min)
                    min = num;
            }
        }
        return min;
    }

    // Row Sum
    public static void rowSum(int[][] matrix) {

        int rowNo = 0;
        for (int[] row : matrix) {

            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            System.out.println("Row " + rowNo + " = " + sum);
            rowNo++;
        }
    }

    // Column Sum
    public static void columnSum(int[][] matrix) {

        for (int col = 0; col < matrix[0].length; col++) {

            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            System.out.println("Column " + col + " = " + sum);
        }
    }

    // Transpose Matrix
    public static void transpose(int[][] matrix) {

        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }

    // Search Element
    public static boolean search(int[][] matrix, int target) {

        for (int[] row : matrix) {
            for (int num : row) {

                if (num == target)
                    return true;
            }
        }
        return false;
    }

    // Main Diagonal
    public static void mainDiagonal(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
    }

    // Secondary Diagonal
    public static void secondaryDiagonal(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix:");
        printMatrix(matrix);

        System.out.println("\nSum of Matrix:" + sumMatrix(matrix));
        System.out.println("Maximum Element:" + findMax(matrix));
        System.out.println("\nMinimum Element:" + findMin(matrix));

        System.out.println("Row Sum:");
        rowSum(matrix);

        System.out.println("\nColumn Sum:");
        columnSum(matrix);

        System.out.println("\nTranspose Matrix:");
        transpose(matrix);

        System.out.println("\nSearch 6:");
        System.out.println(search(matrix, 6));

        System.out.println("\nMain Diagonal:");
        mainDiagonal(matrix);

        System.out.println("\n\nSecondary Diagonal:");
        secondaryDiagonal(matrix);
    }
}
