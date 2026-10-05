/**
 Find leader element from the given array
 Leader: Element which is >= to all elements to its right
 Last element is always a leader

 Approach: Right-to-Left Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Find_Leader {

    public static List<Integer> findLeader(int[] arr) {

        // Approach: Right-to-Left Traversal

        List<Integer> res = new ArrayList<>();

        int leader = arr[arr.length - 1];
        res.add(leader);

        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i] >= leader){
                leader = arr[i];
                res.add(leader);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {8, 5, 2, 3, 3};
        System.out.println("Array:" + Arrays.toString(arr));

        List<Integer> res = findLeader(arr);
        System.out.println("Leaders in the array: " + res);
    }
}
