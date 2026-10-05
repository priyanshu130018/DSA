/**
 Count distinct elements in every window of size k.

 Approach: Sliding Window + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.*;

public class Count_Distinct_Element {

    public static List<Integer> countDistinct(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (i >= k) {

                int left = arr[i - k];

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
            }

            if (i >= k - 1) {
                result.add(map.size());
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Window Size : " + k);

        System.out.println("Distinct Counts : " + countDistinct(arr, k));
    }
}
