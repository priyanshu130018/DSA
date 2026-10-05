/**
 Find missing number from the array in which all element are unique with size from 0 to n

 Approach: Total Sum formula
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: XOR Method
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Cyclic sort
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Find_Missing_Number {

    public static int missingNumber(int[] arr) {
        // Approach: Total Sum formula

        int n = arr.length;
        int ExpectedSum = (n * (n+1)) / 2;
        int CurrSum = 0;

        for (int val : arr) {
            CurrSum += val;
        }
        return ExpectedSum - CurrSum;



        /*
        // Approach: XOR Method

        int xor = arr.length;
        for (int i = 0; i < arr.length; i++) {
            xor ^= i;
            xor ^= arr[i];
        }

        return xor;
        */



        /*
        // Approach: Cyclic sort

        int i=0;
        while(i < arr.length)
        {
            int index = arr[i];
            if(arr[i] < arr.length && arr[i]!=i)
            {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] =  temp;
            }
            else
            {
                i++;
            }
        }
        for(int j=0; j<arr.length;j++)
        {
            if(arr[j]!=j)
            {
                return j;
            }
        }
        return arr.length;
        */
    }

    public static void main(String[] args) {

        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println("Array:" + Arrays.toString(arr));

        int res = missingNumber(arr);
        System.out.println("Missing no: " + res);
    }
}
