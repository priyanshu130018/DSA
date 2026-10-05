/**
 Find the common elements between two arrays

 Approach: HashSet
 - Time Complexity: O(n + m)
 - Space Complexity: O(n)

 Approach: Sorting + Two Pointer
 - Time Complexity: O(m log m + n log n), if arrays are sorted O(n + m)
 - Space Complexity: O(1)
 */

import java.util.*;

public class Common_Element_1 {

    public static List<Integer> commonEle(int[] arr1, int[] arr2) {
        // Approach: Using HashSet

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int val : arr1) {
            set.add(val);
        }

        for (int val : arr2) {
            if (set.contains(val)) {
                ans.add(val);
                set.remove(val);
            }
        }

        return ans;

        /*
        // Approach: Sorting + Two Pointer

        List<Integer> ans = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (i == 0 || arr1[i] != arr1[i - 1]) {
                    ans.add(arr1[i]);
                }
                i++;
                j++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            else j++;

        }

        return ans;
        */
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 4, 6, 7};

        System.out.println("Array1: " + Arrays.toString(arr1));
        System.out.println("Array2: " + Arrays.toString(arr2));

        List<Integer> res = commonEle(arr1, arr2);
        System.out.println("Common elements: " + res);
    }
}