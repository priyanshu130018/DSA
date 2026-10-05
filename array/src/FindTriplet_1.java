/**
 Find triplets that sum to zero

 Approach:
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 */

import java.util.*;

public class FindTriplet_1 {

    public static List<List<Integer>> findTriplet(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    result.add(Arrays.asList( arr[i], arr[left], arr[right] ));
                    left++; right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println("Array: " + Arrays.toString(arr));

        List<List<Integer>> res = findTriplet(arr);
        System.out.println("Triplets: " + res);
    }
}
