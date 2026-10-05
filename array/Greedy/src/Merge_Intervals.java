/**
 Merge all overlapping intervals and return the non-overlapping intervals.

 Approach: Greedy + Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Merge_Intervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println("Intervals: " + Arrays.deepToString(intervals));

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals: " + Arrays.deepToString(result));
    }
}
