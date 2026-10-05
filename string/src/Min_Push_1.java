/**
 Given a word with unique letters, find the minimum number of pushes to type word

 Approach: Greedy Algorithm
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

public class Min_Push_1 {

    public static int minimumPushes(String word) {
        // Approach: Greedy Algorithm

        int minPush = 0;
        for(int i = 0; i < word.length(); i++) {
            minPush += i/8 + 1;
        }
        return minPush;
    }

    public static void main(String[] args) {

        String word = "abcdefghizyxwvuts";
        System.out.println("Strings: " + word);

        int res = minimumPushes(word);
        System.out.println(res);
    }
}
