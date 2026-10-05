/**
 Find the maximum element in every window of size k.

 Approach: Sliding Window + Deque
 - Time Complexity: O(n)
 - Space Complexity: O(k)
 **/

import java.util.*;

public class Sliding_Window_Maximum {

    public static List<Integer> maxSlidingWindow(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty()
                    && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Window is ready
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Array : " + Arrays.toString(arr));

        System.out.println("Window Size : " + k);

        System.out.println("Maximums : " + maxSlidingWindow(arr, k));
    }
}

