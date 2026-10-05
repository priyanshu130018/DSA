/**
 Determine whether a partially filled 9 × 9 Sudoku board is valid.
 Only the filled cells need to be validated according to Sudoku rules.

 Approach: Hashing (Row + Column + Box)
 - Time Complexity: O(81) ≈ O(1)
 - Space Complexity: O(1)
 */

public class Valid_Sudoku {

    public static boolean isValidSudoku(char[][] board) {
        // Approach: Hashing (Row + Column + Box)

        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '1';

                int boxIndex = (i / 3) * 3 + (j / 3);

                row[i][num]++;
                col[j][num]++;
                box[boxIndex][num]++;

                if (row[i][num] > 1)
                    return false;

                if (col[j][num] > 1)
                    return false;

                if (box[boxIndex][num] > 1)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Is Valid Sudoku: " + isValidSudoku(board));
    }
}