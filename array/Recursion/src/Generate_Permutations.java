/**
 Generate all permutations of the given array.

 Approach: Recursion + Backtracking
 - Time Complexity: O(n * n!)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Generate_Permutations {

    public static void permute(int[] arr, int index, List<List<Integer>> res) {

        // Base Case
        if (index == arr.length) {
            List<Integer> current = new ArrayList<>();

            for (int num : arr) {
                current.add(num);
            }

            res.add(current);
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Choose
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            permute(arr, index + 1, res);

            // Undo
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();

        permute(arr, 0, result);

        System.out.println(result);
    }
}
