/**
 Perfect Number
 Check whether a number is equal to the sum of all its divisors except itself

 Approach: Divisor Sum
 - Time Complexity: O(sqrt(n))
 - Space Complexity: O(1)
 */

public class Perfect_Number {

    public static boolean isPerfect(int n) {

        if (n <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                sum += i;

                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {

        int n = 28;
        System.out.println("Number: " + n);

        if (isPerfect(n)) {
            System.out.println("Perfect Number");
        } else {
            System.out.println("Not a Perfect Number");
        }
    }
}