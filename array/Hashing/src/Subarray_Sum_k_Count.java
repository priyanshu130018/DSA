/**
 Find the total number of continuous subarrays whose sum equals k

 Approach: Prefix Sum + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Subarray_Sum_k_Count {

    public static int subarraySum(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once before starting
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {

            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(
                    prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1};
        int k = 2;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("K: " + k);

        int result = subarraySum(arr, k);

        System.out.println("Number of Subarrays: " + result);
    }
}
