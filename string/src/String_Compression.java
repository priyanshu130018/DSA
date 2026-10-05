/**
 Compress consecutive repeated characters by storing each character followed by its count

 Approach: Two Pointers
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

public class String_Compression {

    public static int compress(char[] chars) {

        // Approach: Two Pointers
        int i = 0, j = 0;
        while (i < chars.length) {

            char curr = chars[i];
            int count = 0;

            // Count consecutive same characters
            while (i < chars.length && chars[i] == curr) {
                i++;
                count++;
            }

            chars[j++] = curr;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[j++] = ch;
                }
            }
        }

        return j;
    }

    public static void main(String[] args) {

        char[] chars = {'a','a','b','b','c','c','c'};
        int size = compress(chars);

        System.out.println("Compressed Length: " + size);
        System.out.print("Compressed Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}