/**
 Select the maximum number of non-overlapping activities that can be performed.

 Approach: Greedy + Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Activity_Selection {

    public static int maxActivities(int[] start, int[] end) {

        int n = start.length;

        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = -1;

        for (int[] activity : activities) {

            if (activity[0] >= lastEnd) {
                count++;
                lastEnd = activity[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println("Start Times: " + Arrays.toString(start));
        System.out.println("End Times: " + Arrays.toString(end));

        int result = maxActivities(start, end);

        System.out.println("Maximum Activities: " + result);
    }
}
