/**
 Count the number of distinct elements present in the given array.

 Approach: HashSet
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Count_Distinct_Elements {

    public static int countDistinct(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        System.out.println("Array: " + Arrays.toString(arr));

        int result = countDistinct(arr);

        System.out.println("Number of Distinct Elements: " + result);
    }
}
