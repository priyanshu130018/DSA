/**
 Count the number of subarrays whose XOR equals the given target K.

 Approach: Prefix XOR + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Count_Subarrays_With_XOR_K {

    public static int countSubarrays(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : arr) {

            prefixXor ^= num;

            int required = prefixXor ^ k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(
                    prefixXor,
                    map.getOrDefault(prefixXor, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("K: " + k);

        int result = countSubarrays(arr, k);

        System.out.println("Number of Subarrays: " + result);
    }
}

