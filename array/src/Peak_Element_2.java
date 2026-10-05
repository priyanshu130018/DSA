/**
 Find all peak elements from the given array

 Approach: Linear Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.*;

public class Peak_Element_2 {

    public static List<Integer> findPeakEleAll(int[] arr) {
        // Approach: Linear Traversal

        List<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            boolean left = (i == 0) || arr[i] >= arr[i-1];
            boolean right = (i == arr.length-1) || arr[i] >= arr[i+1];

            if (left && right) {
                newArr.add(arr[i]);
            }
        }
        return newArr;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3, 5};
        System.out.println("Array:" + Arrays.toString(arr));

        List<Integer> peaks = findPeakEleAll(arr);
        System.out.println("All Peak elements are: " + peaks);
    }
}

