/**
 Find any two numbers whose sum equals the target from the given array.
 Return an empty list if no such pair exists.

 Approach: HashSet
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Two Pointer (If Array is sorted)
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 If Array is unsorted

 **/

import java.util.*;

public class Find_2Sum{

    public static List<Integer> find2Sum(int[] arr, int target) {
        // Approach: HashSet

        if (arr.length < 2) return new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {

            int complement = target - num;

            if (set.contains(complement)) {
                return Arrays.asList(complement, num);
            }

            set.add(num);
        }

        return new ArrayList<>();



        /*
        // Approach: Two Pointer (If Array is sorted)

        if (arr.length < 2) return new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return Arrays.asList(arr[left], arr[right]);
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return new ArrayList<>();
        */
    }

    public static void main(String[] args) {

        int target = 10;
        int[] arr = {9, 7, 1, 5};

        System.out.println("\nUnsorted Array : " + Arrays.toString(arr));
        System.out.println("Target : " + target);

        System.out.println("Pair : " + find2Sum(arr, target));
    }
}
