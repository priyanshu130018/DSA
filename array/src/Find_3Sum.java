/**
 Find any three numbers whose sum equals the target from the given array
 Return an empty list if no such triplet exists

 Approach: HashSet
 - Time Complexity: O(n²)
 - Space Complexity: O(n)

 Approach: Two Pointer (If Array is sorted)
 - Time Complexity: O(n log n + n²) ≈ O(n²)
 - Space Complexity: O(1)

 **/

import java.util.*;

public class Find_3Sum {

    public static List<Integer> find3Sum(int[]arr, int target){
        //  Approach: HashSet

        if (arr.length < 3) return new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {

            int remaining = target - arr[i];

            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < arr.length; j++) {

                int required = remaining - arr[j];

                if (set.contains(required)) {
                    return Arrays.asList(arr[i], required, arr[j]);
                }

                set.add(arr[j]);
            }
        }
        return new ArrayList<>();



        /*
        // Approach: Two Pointer

        if (arr.length < 3) return new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    return Arrays.asList(arr[i], arr[left], arr[right]);
                }
                else if (sum < target) left++;
                else right--;
            }
        }

        return new ArrayList<>();
        */
    }


    public static void main(String[] args) {

        int target = 9;
        int[] arr = {1, 1, 2, 7};

        System.out.println("\nArray : " + Arrays.toString(arr));
        System.out.println("Target : " + target);

        System.out.println("Triplet : " + find3Sum(arr, target));
    }
}