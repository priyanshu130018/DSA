/**
 Find the length of the largest subarray whose sum is zero

 Approach: Prefix Sum + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Max_Subarray_Sum_0{

    public static int maxLen(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(
                        maxLength,
                        i - map.get(prefixSum)
                );
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Array: " + Arrays.toString(arr));

        int result = maxLen(arr);
        System.out.println("Largest Zero Sum Subarray Length: " + result);
    }
}
