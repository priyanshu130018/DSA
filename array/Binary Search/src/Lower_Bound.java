/**
 Find the first index where the element is greater than or equal to the target.

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

public class Lower_Bound {

    public static int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 5, 7};
        int target = 4;

        int result = lowerBound(arr, target);

        System.out.println("Lower Bound Index = " + result);
    }
}
