/**
 Given a word where letters can repeat, find the minimum number of pushes to type word

 Approach: Greedy + Frequency Counting + Sorting
 - Time Complexity: O(n + 26 log 26) ≈ O(n)
 - Space Complexity: O(1)
 */
import java.util.Arrays;

public class Min_Push_2 {

    public static int minimumPushes(String word) {
        //Approach: Greedy + Frequency Counting + Sorting

        int[] freq = new int[26];

        for(int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);

        int minPush = 0;
        int index = 0;
        for(int i = freq.length-1; i >= 0; i--) {

            if(freq[i] == 0) break;

            minPush += freq[i] * ((index/8) + 1);
            index++;
        }
        return minPush;
    }

    public static void main(String[] args) {

        String word = "aabbccddeeffgghhiiiiii";
        System.out.println("Strings: " + word);

        int res = minimumPushes(word);
        System.out.println(res);
    }
}
