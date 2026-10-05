/**
 LCM of two numbers
 LCM: Smallest number that is divisible by two numbers

 Approach: Using GCD
 - Time Complexity: O(log(min(a, b)))
 - Space Complexity: O(1)
 */

public class LCM {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {

        int a = 12;
        int b = 18;
        System.out.println("Num 1: " + a);
        System.out.println("Num 2: " + b);

        System.out.println("LCM: " + lcm(a, b));
    }
}