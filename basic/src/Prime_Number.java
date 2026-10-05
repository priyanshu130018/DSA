/**
 Check whether a number is prime

 Approach: Divisor Check up to Square Root
 - Time Complexity: O(sqrt(n))
 - Space Complexity: O(1)
 */

public class Prime_Number {

    public static boolean isPrime(int n) {

        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 29;
        System.out.println("Number: " + n);

        if (isPrime(n)) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}