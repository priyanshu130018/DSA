/**
 Print all subsequences of the given array.

 Approach: Recursion
 - Time Complexity: O(n * 2^n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Print_All_Subsequences {

    public static void printSubsequences(int[] arr, int index, List<Integer> current) {

        // Base Case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Include current element
        current.add(arr[index]);

        printSubsequences(arr, index + 1, current);

        // Exclude current element
        current.remove(current.size() - 1);

        printSubsequences(arr, index + 1, current);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        printSubsequences(arr, 0, new ArrayList<>());
    }
}
