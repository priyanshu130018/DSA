/**
 Search in rotated sorted array
 Given a rotated sorted array and a target value, return the target's index, or -1 if it doesn't exist

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */
import java.util.Arrays;

public class Search_Rotated_Array {

    public static int findEle(int[] arr, int k) {

        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if (arr[mid] == k) return mid;

            // Left half is sorted
            if(arr[left] <= arr[mid]) {
                if (arr[left] <= k && k < arr[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] < k && k <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {6,7,0,1,2,3,4,5};
        int k = 7;
        System.out.println("Rotated Array: " + Arrays.toString(arr));
        System.out.println("Target: " + k);

        int index = findEle(arr, k);
        if (index == -1) {
            System.out.println("Not Found");
        }
        else{
            System.out.println("Found at " + index);
        }
    }
}
