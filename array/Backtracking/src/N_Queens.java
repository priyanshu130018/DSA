/**
 Find all possible ways to place n queens on an n x n chessboard so that no two queens attack each other.

 Approach: Backtracking
 - Time Complexity: O(n!)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class N_Queens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, res);

        return res;
    }

    private static void backtrack(
            int row,
            char[][] board,
            List<List<String>> res) {

        if (row == board.length) {
            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            res.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                backtrack(row + 1, board, res);

                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> res = solveNQueens(n);

        System.out.println("N: " + n);
        System.out.println("Solutions:");

        for (List<String> board : res) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
