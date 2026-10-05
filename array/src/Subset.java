/**
 Power set: Generate all possible subsets for given array
 It set must not contain duplicate subsets

 Approach: Backtracking
 - Time Complexity: O()
 - Space Complexity: O()
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static List<List<Integer>> subsets(int[] arr) {
        // Approach: Backtracking

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : arr) {

            List<List<Integer>> newSubsets = new ArrayList<>();

            for (int j = 0; j < output.size(); j++) {

                List<Integer> curr = output.get(j);
                List<Integer> temp = new ArrayList<>(curr);

                temp.add(num);
                newSubsets.add(temp);
            }

            for (int k = 0; k < newSubsets.size(); k++) {
                output.add(newSubsets.get(k));
            }
        }

        return output;
    }

    public static void main(String[] args) {

        int[] arr = {7, 9, 3, 4};
        System.out.println("Array: " + Arrays.toString(arr));

        List<List<Integer>> res = subsets(arr);
        System.out.println("All possible subset: " + res);
    }
}
