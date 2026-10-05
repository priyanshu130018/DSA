/**
 Find the element that appears more than n/2 times in the given array
 Return -1 if no majority element exists
 There can be only one element

 Approach: Boyer-Moore Voting Algorithm
 Same element: count++
 Different element: count--
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)
 */


import java.util.Arrays;

public class Majority_Element_1 {

    public static int findMajorityEle(int[] arr) {
        // Approach: Boyer-Moore Voting Algorithm

        // same element: count++
        // different element: count--
        if (arr == null || arr.length == 0) return -1;

        // find elements and count
        int n = arr.length, count = 0, num = -1;

        for (int val : arr) {
            if (count == 0) num = val;

            if (val == num) count++;

            else count--;
        }

        // verify
        count = 0;
        for (int val : arr) {
            if (val == num) {
                count++;
            }
        }
        return (count > arr.length / 2) ? num : -1;


        /*
        // Approach: Sorting

        Arrays.sort(arr);

        int candidate = arr[arr.length / 2];

        int count = 0;
        for (int val : arr) {
            if (val == candidate)
                count++;
        }

        return (count > arr.length / 2) ? candidate : -1;
        */
    }

    public static void main(String[] args) {

        int[] arr = {4, 4, 4, 2, 4, 3, 4};
        System.out.println("Array:" + Arrays.toString(arr));

        int res = findMajorityEle(arr);
        if (res==-1)
            System.out.println("No Majority element");
        else
            System.out.println("Majority element: " + res);
    }
}

