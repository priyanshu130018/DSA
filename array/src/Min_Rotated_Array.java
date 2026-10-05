/**
 Find minimum element in rotated sorted array

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Min_Rotated_Array {

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int mid = left + (right-left)/2;

            
            if(arr[mid] > arr[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return arr[left];
    }
    public static void main(String[] args) {

        int[] arr = {6,7,0,1,2,3,4,5};
        System.out.println("Rotated Array: " + Arrays.toString(arr));

        int res = findMin(arr);
        System.out.println("Min Value: " + res);
    }
}
