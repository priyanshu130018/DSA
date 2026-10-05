/**
 Find a duplicate element from the given array

 Approach: Using HashSet
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Frequency Array
 - Time Complexity: O(n)
 - Space Complexity: O(k)

 Approach: Floyd's Algorithm
 Only when every number in the array can be used as an index
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Find_Duplicate_Element {

    public static int findDuplicate(int[] arr) {
        // Approach: HashSet

        Set<Integer> set = new HashSet<>();

        for(int val : arr) {
            if(set.contains(val)) {
                return val;
            }
            set.add(val);
        }

        return -1;



        /*
        // Approach: Frequency Array

        if (arr == null || arr.length == 0) return -1;

        int max = 0;
        for (int num : arr) {
            if (num > max)
                max = num;
        }

        // Create frequency array of size max + 1
        int[] freq = new int[max+1];

        for (int num : arr) {
            freq[num]++;

            if (freq[num] > 1) {
                return num;
            }
        }
        return -1;
        */




        /*
        // Approach: Floyd's Algorithm

        int slow = 0;
        int fast = 0;

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
        */
    }

    public static void main(String[] args) {

        int[] arr = {2,5,9,6,9,3,8,9,7,1};
        System.out.println("Array:" + Arrays.toString(arr));

        int res = findDuplicate(arr);
        if(res == -1)
            System.out.println("No Duplicate element");
        else
            System.out.println("Duplicate element: " + res);
    }
}

