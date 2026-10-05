/**
 Determine whether a number is a happy number by repeatedly replacing it with the sum of squares of its digits.

 Approach: HashSet
 - Time Complexity: O(log n)
 - Space Complexity: O(log n)
 **/

import java.util.*;

public class Happy_Number {

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1) {

            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            n = sumOfSquares(n);
        }

        return true;
    }

    private static int sumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println("Number: " + n);
        System.out.println("Is Happy Number: " + isHappy(n));
    }
}
