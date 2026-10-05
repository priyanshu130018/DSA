/**
 GCD of two numbers
 GCD: Greatest number that divides two numbers exactly

 Approach: Euclidean Algorithm
 - Time Complexity: O(log(min(a, b)))
 - Space Complexity: O(1)
 where a, b are given number
 */

public class GCD {

    public static int gcd(int a, int b) {

        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }

    public static void main(String[] args) {

        int a = 48;
        int b = 18;
        System.out.println("Num 1: " + a);
        System.out.println("Num 2: " + b);

        System.out.println("GCD: " + gcd(a, b));
    }
}