/**
 Count the frequency of each distinct element in the given array.

 Approach: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Count_Frequencies {

    public static Map<Integer, Integer> countFrequency(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        Map<Integer, Integer> result = countFrequency(arr);
        System.out.println("Frequencies: " + result);
    }
}
