/**
 Find the length of the longest consecutive sequence in an unsorted array.

 Approach: HashSet
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Longest_Consecutive_Seq {

    public static int longestSeq(int[] arr) {
        // Approach: HashSet

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int len = 0;
        for (int num : set) {

            // Start counting only from the first element of a sequence
            if (!set.contains(num-1)) {
                int start  = num;
                int count = 1;

                while (set.contains(start + 1)) {
                    start++;
                    count++;
                }
                len = Math.max(len, count);
            }
        }
        return len;


        /*
        // Approach: Sorting

        if (arr == null || arr.length == 0) return 0;

        Arrays.sort(arr);

        int count = 1, len = 0;
        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i] == arr[i+1])
                continue;

            if (arr[i] + 1 == arr[i+1]) {
                count++;
            }
            else count = 1;

            len = Math.max(len, count);
        }
        return len;
        */

    }

    public static void main(String[] args) {

        int[] arr = {0,3,7,2,15,8,4,6,0,1};
        System.out.println("Array: " + Arrays.toString(arr));

        int res = longestSeq(arr);
        System.out.println("Length of longest consecutive sequence: " + res);
    }
}


