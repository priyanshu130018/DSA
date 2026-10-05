/**
 Reverse an integer number

 Approach: Digit Extraction
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */

public class Reverse_Integer {

    public static int reverse(int num) {

        int rev = 0;

        if (num < 0) {
            return -1;
        }

        while (num > 0) {
            int rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }

        return rev;
    }

    public static void main(String[] args) {

        int num = 156;
        System.out.println("Number: " + num);

        int res = reverse(num);
        System.out.println("After Reverse: " + res);
    }
}