/**
 Count the frequency of each element from the given array

 Approach: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Frequency Count Array (Non-negative Integers Only)
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(log n)
 */

import java.util.*;

public class Count_Frequency {

    public static void countEachElement(int[] arr) {
        // Approach: HashMap

        Map<Integer, Integer> map = new HashMap<>();

        for (int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " -> " + e.getValue());
        }



        /*
        Approach: Frequency Count Array (Non-negative Integers Only)

        int max = Integer.MIN_VALUE;
        for(int val: arr){
            if(val>max) max=val;
        }

        int[] freqArr = new int [max+1];
        for (int val : arr) {
            freqArr[val]++;
        }
        for (int i = 0; i < freqArr.length; i++) {
            if(freqArr[i] > 0){
                System.out.println(i + "->" + freqArr[i]);
            }
        }
        */



        /*
        // Approach: sorting

        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                System.out.println(arr[i] + " -> " + count);
                count = 1;
            }
        }
        // Print last element
        System.out.println(arr[arr.length - 1] + " -> " + count);
        */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array:");
        for (int i=0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Given array:" + Arrays.toString(arr));
        System.out.println("Frequency of each element in an array:");
        countEachElement(arr);

        sc.close();
    }
}
