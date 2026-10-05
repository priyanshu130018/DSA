/**
 Find all prime numbers up to a given number

 Approach: Sieve of Eratosthenes
 - Time Complexity: O(n log(log n))
 - Space Complexity: O(n)
 */

public class Sieve_Of_Eratosthenes {

    public static void sieve(int n) {

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        int n = 30;

        System.out.println("Prime numbers up to " + n + ":");
        sieve(n);
    }
}