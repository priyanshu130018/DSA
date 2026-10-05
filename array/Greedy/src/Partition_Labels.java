/**
 Partition a string into as many parts as possible so that each character appears in at most one part.

 Approach: Greedy + Last Index
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Partition_Labels {

    public static List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<>();

        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(
                    end,
                    lastIndex[s.charAt(i) - 'a']
            );

            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";

        System.out.println("String: " + s);

        List<Integer> result = partitionLabels(s);

        System.out.println("Partition Sizes: " + result);
    }
}
