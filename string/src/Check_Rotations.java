/**
 Check whether one string is a rotation of another string

 Approach: String Concatenation + Search
 Time Complexity: O(n)
 Space Complexity: O(n)
 */

public class Check_Rotations {

    public static boolean isRotation(String s1, String s2) {
        // Approach: String Concatenation + Search

        if (s1.length() != s2.length()) {
            return false;
        }

        String combined = s1 + s1;

        return combined.contains(s2);
    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "cdab";

        boolean result = isRotation(s1, s2);

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Is Rotation: " + result);
    }
}