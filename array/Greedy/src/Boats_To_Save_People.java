/**
 Find the minimum number of boats needed to rescue all people when each boat can carry at most two people.

 Approach: Greedy + Two Pointer
 - Time Complexity: O(n log n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Boats_To_Save_People {

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {

        int[] people = {3, 2, 2, 1};
        int limit = 3;

        System.out.println("People: " + Arrays.toString(people));
        System.out.println("Boat Limit: " + limit);

        int result = numRescueBoats(people, limit);

        System.out.println("Minimum Boats: " + result);
    }
}
