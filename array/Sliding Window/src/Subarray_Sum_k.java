/**
 Find a continuous subarray whose sum is equal to the target
 Return an empty list if no such subarray exists

 Approach: Sliding Window (If all elements are non-negative)
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Subarray_Sum_k {

    public static List<Integer> findSubarray(int[] arr, int sum) {
        // Approach 1: Sliding Window
        // If all elements are non-negative

        List<Integer> subArr = new ArrayList<>();
        int curSum=0, start=0;

        for(int i = 0; i < arr.length; i++){
            curSum += arr[i];

            // shrink window if sum exceeds
            while (curSum > sum && start <= i) {
                curSum -= arr[start];
                start++;
            }

            if(curSum == sum){
                for(int j = start; j <= i; j++){
                    subArr.add(arr[j]);
                }
                return subArr;
            }
        }
        return subArr;

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 7, 5, 12};
        int sum = 15;

        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);

        List<Integer> res = findSubarray(arr, sum);
        System.out.println("Subarray with given sum: " + Arrays.toString(res.toArray()));
    }
}