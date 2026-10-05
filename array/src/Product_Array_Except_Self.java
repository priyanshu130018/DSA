/**
 Product of Array Except Self

 Approach: Two-pass Prefix/Suffix Product
 - Time Complexity: O(n)
 - Auxiliary Space: O(1)
 - Space Complexity: O(n)
 **/

import java.util.Arrays;

public class Product_Array_Except_Self {

    public static int[] prodNum(int[] arr) {
        // Two-pass Prefix/Suffix Product

        int[] result = new int[arr.length];

        int prefix = 1;

        // Product of elements to the left
        for (int i = 0; i < arr.length; i++) {
            result[i] = prefix;
            prefix *= arr[i];
        }

        int suffix = 1;

        // Product of elements to the right
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        System.out.println("Arrays: " + Arrays.toString(arr));

        int[] result = prodNum(arr);
        System.out.println("Product of Array Except Self: " + Arrays.toString(result));
    }
}
