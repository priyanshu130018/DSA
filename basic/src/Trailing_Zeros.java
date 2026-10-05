/**
 Find how many zeros are at the end of factorial of n (n!)

 Approach: Count Factors of 5
 - Time Complexity: O(log₅ n)
 - Space Complexity: O(1)
 */

public class Trailing_Zeros {

    public static int findTrailingZero(int num) {

        int res = 0;

        for (int i = 5; i <= num; i = i * 5) {
            res += num / i;
        }

        return res;
    }

    public static void main(String[] args) {

        int num = 45;

        System.out.println("Given number: " + num);

        int result = findTrailingZero(num);

        System.out.println("Trailing zeros: " + result);
    }
}