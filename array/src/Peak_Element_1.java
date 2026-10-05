/**
 Find one peak element from the given array
 Peak element: Element which is >= to its adjacent elements

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Peak_Element_1 {

    public static int findPeakEle(int[] arr) {
        // Approach: Binary Search

        if (arr.length == 0) return -1;

        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int mid = left + (right-left)/2;

            if(arr[mid] < arr[mid + 1]){
                left = mid+1;
            }
            else right = mid;
        }
        return arr[left];
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3, 5};
        System.out.println("Array:" + Arrays.toString(arr));

        int res = findPeakEle(arr);
        System.out.println("Peak element: " + res);
    }
}

