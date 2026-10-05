/**
 Jagged Array (Ragged Array): A 2D array where each row can have a different number of columns.

 Time Complexity:
 - Print Jagged Array    : O(n)
 - Sum of All Elements   : O(n)
 - Max Element           : O(n)
 - Min Element           : O(n)
 - Search Element        : O(n)
 - Row Sum               : O(n)

 Space Complexity: O(1)
 **/

public class Jagged_Array {

    // Print Jagged Array
    static void printJaggedArray(int[][] arr) {

        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Sum of All Elements
    static int sum(int[][] arr) {

        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    // Maximum Element
    static int findMax(int[][] arr) {

        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int num : row) {
                max = Math.max(max, num);
            }
        }

        return max;
    }

    // Minimum Element
    static int findMin(int[][] arr) {

        int min = Integer.MAX_VALUE;
        for (int[] row : arr) {
            for (int num : row) {
                min = Math.min(min, num);
            }
        }
        return min;
    }

    // Search Element
    static boolean search(int[][] arr, int target) {

        for (int[] row : arr) {
            for (int num : row) {
                if (num == target)
                    return true;
            }
        }

        return false;
    }

    // Row Sum
    static void rowSum(int[][] arr) {

        int rowNo = 0;
        for (int[] row : arr) {

            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            System.out.println("Row " + rowNo + " = " + sum);
            rowNo++;
        }
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2},
                {},
                {3, 4, 5},
                {6},
                {7, 8, 9, 10}
        };

        System.out.println("Jagged Array:");
        printJaggedArray(arr);

        System.out.println("\nSum = " + sum(arr));
        System.out.println("Maximum = " + findMax(arr));
        System.out.println("Minimum = " + findMin(arr));
        System.out.println("\nRow Sum:");
        rowSum(arr);

        int target = 7;
        System.out.println("\nSearch " + target + ": " + search(arr, target));
    }
}