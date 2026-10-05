/**
 Generate all subsets of the given array.

 Approach: Recursion
 - Time Complexity: O(n * 2^n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Generate_All_Subsets {

    public static List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        generate(arr, 0, new ArrayList<>(), res);

        return res;
    }

    public static void generate(
            int[] arr,
            int index,
            List<Integer> current,
            List<List<Integer>> res) {

        // Base Case
        if (index == arr.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(arr[index]);

        generate(arr, index + 1, current, res);

        // Exclude current element
        current.remove(current.size() - 1);

        generate(arr, index + 1, current, res);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        List<List<Integer>> result = subsets(arr);

        System.out.println(result);
    }
}
