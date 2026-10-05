/**
 Find all elements that appear more than n/3 times in the given array
 Return an empty list if no such element exists
 There can be at most two elements

 Approach: Boyer-Moore Voting Algorithm
 Same element: count++
 Different element: count--
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Majority_Element_2 {

    public static List<Integer> countEle(int[] arr) {
        // Approach: Boyer-Moore Voting Algorithm
        // for n=7 => 3+3+1

        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int count1=0, count2=0;

        // find elements and count
        for (int val: arr) {
            if (val == num1) count1++;

            else if (val == num2) count2++;

            else if (count1 == 0) {
                num1 = val;
                count1 = 1;
            }
            else if (count2 == 0) {
                num2 = val;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // verify
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == num1) count1++;

            else if (num == num2) count2++;
        }
        if (count1 > n/3) {
            res.add(num1);
        }
        if (num2 != num1 && count2 > n/3) {
            res.add(num2);
        }

        return res;

        /*
        // Approach: HashMap

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 3) {
                res.add(entry.getKey());
            }
        }

        return res;
        */
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Array:" + Arrays.toString(arr));

        List<Integer> res = countEle(arr);
        if (res.isEmpty())
            System.out.println("Not found!");
        else
            System.out.println("Elements that appear more than n/3 times: " + res);

    }
}

