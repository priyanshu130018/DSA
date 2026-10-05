/**
 Count the number of vowels and consonants in a given string

 Approach: Single Traversal
 Time Complexity: O(n)
 Space Complexity: O(1)
 */

public class Count_Vowels_Consonants {

    public static int[] countVowelsAndConsonants(String str) {
        // Approach: Single Traversal

        int vowels = 0;
        int consonants = 0;

        for (char ch : str.toCharArray()) {

            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }
        }

        return new int[] {vowels, consonants};
    }

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println("String: " + str);
        System.out.println("Length: " + str.length());

        int[] result = countVowelsAndConsonants(str);
        System.out.println("No of Vowels: " + result[0]);
        System.out.println("No of Consonants: " + result[1]);
    }
}