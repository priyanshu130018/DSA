/**
 Find the minimum eating speed needed to finish all banana piles within the given hours.

 Approach: Binary Search
 - Time Complexity: O(n log m)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Koko_Eating_Bananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(
            int[] piles,
            int h,
            int speed) {

        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Piles: " + Arrays.toString(piles));
        System.out.println("Hours: " + h);

        int result = minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed: " + result);
    }
}
