/**
 Check if a subarray with a given XOR exists.

 Approach: Prefix XOR
 - Time complexity: O(n)
 - Space complexity: O(n)
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Check_XOR {

    public static boolean hasSubarrayWithXOR(int[] nums, int target) {
        // Approach: Prefix XOR

        Set<Integer> set = new HashSet<>();
        int prefixXOR = 0;

        set.add(0);

        for (int num : nums) {
            prefixXOR ^= num;

            if (set.contains(prefixXOR ^ target)) {
                return true;
            }

            set.add(prefixXOR);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int target = 6;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target XOR: " + target);

        boolean result = hasSubarrayWithXOR(arr, target);

        System.out.println("Subarray exists: " + result);
    }
}