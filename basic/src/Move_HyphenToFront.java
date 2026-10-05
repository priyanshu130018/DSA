/**
 Move Hyphens to Front

 Approach: StringBuilder
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 */

public class Move_HyphenToFront {

    public static String moveHyphen(String s) {

        StringBuilder hyphens = new StringBuilder();
        StringBuilder chars = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '-') {
                hyphens.append('-');
            } else {
                chars.append(s.charAt(i));
            }
        }

        return hyphens.append(chars).toString();
    }

    public static void main(String[] args) {

        String s = "hel-o";
        System.out.println("Given string: " + s);

        String res = moveHyphen(s);
        System.out.println("New String: " + res);
    }
}