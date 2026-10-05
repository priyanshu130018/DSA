/**
 Find the first negative number in every window of size k.

 Approach: Sliding Window + Deque
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.*;

public class First_Negative {

    public static List<Integer> firstNegative(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Store negative element indices
            if (arr[i] < 0) {
                deque.offerLast(i);
            }

            // Window is ready
            if (i >= k - 1) {

                if (!deque.isEmpty()) {
                    result.add(arr[deque.peekFirst()]);
                }
                else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Window Size : " + k);

        System.out.println("First Negative : " + firstNegative(arr, k));
    }
}
