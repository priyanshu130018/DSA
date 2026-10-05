/**
 Find whether a given word exists in a 2D character grid by moving up, down, left, or right.

 Approach: Backtracking
 - Time Complexity: O(m * n * 4^L)
 - Space Complexity: O(L)
 **/

public class Word_Search {

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == word.charAt(0)) {

                    if (backtrack(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean backtrack(
            char[][] board,
            String word,
            int row,
            int col,
            int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
                backtrack(board, word, row + 1, col, index + 1) ||
                        backtrack(board, word, row - 1, col, index + 1) ||
                        backtrack(board, word, row, col + 1, index + 1) ||
                        backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        System.out.println("Word: " + word);
        System.out.println("Word Exists: " + exist(board, word));
    }
}
