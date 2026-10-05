/**
 Modular Exponentiation
 Find the remainder when a number raised to a power is divided by another number

 Approach: Binary Exponentiation
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */

public class Modular_Exponentiation {

    public static long modPow(long base, long exponent, long mod) {

        long result = 1;
        base = base % mod;

        while (exponent > 0) {

            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exponent = exponent / 2;
        }

        return result;
    }

    public static void main(String[] args) {

        long base = 2;
        long exponent = 10;
        long mod = 1000;

        System.out.println("Result: " + modPow(base, exponent, mod));
    }
}