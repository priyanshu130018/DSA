/**
 Find all unique combinations of candidates that sum to the target.

 Approach: Backtracking
 - Time Complexity: O(n^(T/m))
 - Space Complexity: O(T/m)
 where
 T = target
 m = minCandidate
 **/

import java.util.*;

public class Combination_Sum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private static void backtrack(
            int[] candidates,
            int target,
            int index,
            List<Integer> current,
            List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);

            // Same element can be used multiple times
            backtrack(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    res
            );

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println("Candidates: " + Arrays.toString(candidates));
        System.out.println("Target: " + target);

        List<List<Integer>> res = combinationSum(candidates, target);

        System.out.println("Combinations: " + res);
    }
}
