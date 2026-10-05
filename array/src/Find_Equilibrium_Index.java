/**
 Find equilibrium index from the given array
 Equilibrium index: (Sum of elements on the left = Sum of elements on the right)

 Approach: Prefix Sum
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Prefix Sum Optimized
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Find_Equilibrium_Index {

    public static int findEqIndex(int[] arr) {
        // Approach: Prefix Sum

        /**
        [2,4,-4]    [4,2,8,6]   [4,-4,1]
        i=0 leftSum = 0           rightSum = totalSum-a[0],
        i=1 leftSum = a[0]        rightSum = totalSum-leftSum-a[1],
        i=2 leftSum = a[0]+a[1]   rightSum = totalSum-leftSum-a[1]
        */

        int leftSum = 0, rightSum = 0, totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.length; i++){
            if (i > 0) {
                leftSum += arr[i-1];
            }
            rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }
        }



        /*
        // Approach: Prefix Sum Optimized

         int totalSum = 0, leftSum = 0;;
         for (int num : arr) {
             totalSum += num;
         }
         for (int i = 0; i < arr.length; i++) {

             //rightSum
             totalSum -= arr[i];
             if (leftSum == totalSum) {
                  return i;
             }
             leftSum += arr[i];
         }
         */
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {8, 5, 2, 3, 3};
        System.out.println("Array:" + Arrays.toString(arr));

        int res = findEqIndex(arr);
        if(res == -1) {
            System.out.println("No Equilibrium index");
        }
        else {
            System.out.println("Equilibrium index: " + res);
        }
    }
}

