/**
 Find all duplicate element from array

 Approach: Negative Index Marking
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Cycle Sort (array must be continuous)
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class All_Duplicate_Element {

    public static List<Integer> findAllDuplicates(int[] arr) {
        // Approach: Negative Index Marking

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int value = Math.abs(arr[i]);
            int index = value - 1;

            // add duplicates into array list
            if (arr[index] < 0) {
                ans.add(index + 1);
            }
            // mark visited (negative)
            else {
                arr[index] = -arr[index];
            }
        }

        return ans;




        /*
        // Approach: Cycle Sort

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        while (i < arr.length) {
            int crtIndex = arr[i] - 1;

            if (arr[i] != arr[crtIndex]) {

                int temp = arr[i];
                arr[i] = arr[crtIndex];
                arr[crtIndex] = temp;
            }
            else i++;
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                ans.add(arr[i]);
            }
        }

        return ans;
        */




        /*
        // Approach: HashMap

        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 2) {
                ans.add(e.getKey());
            }
        }
        return ans;
        */
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Array: " + Arrays.toString(arr));

        List<Integer> res = findAllDuplicates(arr);
        System.out.println("Duplicate elements: " + res);
    }
}
