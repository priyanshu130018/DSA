/**
 Compute the weights of all uniform substrings in a string and answer the given queries

 Approach: Incremental  Weight + HashSet
 - Time Complexity: O(p + q)
 - Space Complexity: O(n)
 where
 p = length of the first input/string
 q = length of the second input/string
 **/

import java.util.*;

public class Compute_Weight_Substring {

    // Approach: Incremental  Weight + HashSet
    public static Set<Integer> computeWeights(String str) {

        Set<Integer> weights = new HashSet<>();

        char prev = '\0';
        int currentWeight = 0;

        // Compute all weights
        for (char c : str.toCharArray()) {
            int value = c - 'a' + 1;

            if (c == prev) {
                currentWeight += value;
            }
            else currentWeight = value;

            weights.add(currentWeight);
            prev = c;
        }
        return weights;
    }

    public static List<String> checkWeights(String str, int[] queries) {

        Set<Integer> weights = computeWeights(str);
        List<String> result = new ArrayList<>();

        // Answer each query
        for (int q : queries) {
            if (weights.contains(q)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String str = "abbcccdddd";
        int[] queries = {1, 4, 5, 9, 16};

        System.out.println("String: " + str);
        System.out.println("Queries: " + Arrays.toString(queries));

        List<String> result = checkWeights(str, queries);
        System.out.println("Result: " + result);
    }
}