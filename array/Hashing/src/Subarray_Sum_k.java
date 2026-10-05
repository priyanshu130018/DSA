/**
 Find a continuous subarray whose sum is equal to the target
 Return an empty list if no such subarray exists

 Approach: Prefix Sum + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Subarray_Sum_k {

    public static List<Integer> findSubarray(int[] arr, int sum) {
        // Approach : Prefix Sum + HashMap

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> subArr = new ArrayList<>();

        int prefixSum = 0;
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - sum)) {
                int start = map.get(prefixSum - sum) + 1;

                for (int j = start; j <= i; j++) {
                    subArr.add(arr[j]);
                }
                return subArr;
            }
            map.put(prefixSum, i);
        }
        return subArr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 7, 5, 12};
        int sum = 15;

        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);

        List<Integer> res = findSubarray(arr, sum);
        System.out.println("Subarray with given sum: " + Arrays.toString(res.toArray()));
    }
}