/**
 Find all possible paths for a rat to move from the top-left to the bottom-right of a maze.

 Approach: Backtracking
 - Time Complexity: O(4^(n^2))
 - Space Complexity: O(n^2)
 **/

import java.util.*;

public class Rat_In_Maze {

    public static List<String> findPaths(int[][] maze) {

        List<String> res = new ArrayList<>();

        int n = maze.length;

        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return res;
        }

        boolean[][] visited = new boolean[n][n];

        backtrack(maze, 0, 0, "", visited, res);

        return res;
    }

    private static void backtrack(
            int[][] maze,
            int row,
            int col,
            String path,
            boolean[][] visited,
            List<String> res) {

        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(maze, row + 1, col, visited)) {
            backtrack(
                    maze,
                    row + 1,
                    col,
                    path + "D",
                    visited,
                    res
            );
        }

        // Left
        if (isSafe(maze, row, col - 1, visited)) {
            backtrack(
                    maze,
                    row,
                    col - 1,
                    path + "L",
                    visited,
                    res
            );
        }

        // Right
        if (isSafe(maze, row, col + 1, visited)) {
            backtrack(
                    maze,
                    row,
                    col + 1,
                    path + "R",
                    visited,
                    res
            );
        }

        // Up
        if (isSafe(maze, row - 1, col, visited)) {
            backtrack(
                    maze,
                    row - 1,
                    col,
                    path + "U",
                    visited,
                    res
            );
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(
            int[][] maze,
            int row,
            int col,
            boolean[][] visited) {

        int n = maze.length;

        return row >= 0 &&
                row < n &&
                col >= 0 &&
                col < n &&
                maze[row][col] == 1 &&
                !visited[row][col];
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> paths = findPaths(maze);

        System.out.println("Maze:");

        for (int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Possible Paths: " + paths);
    }
}
