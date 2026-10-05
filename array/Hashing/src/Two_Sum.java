/**
 Find two numbers whose sum equals the target and return their indices.

 Approach: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Two_Sum {

    public static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}

