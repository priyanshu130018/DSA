/**
 Square Root of a Number

 Approach 1: Newton's Method
 - Time Complexity: O(log(log x))
 - Space Complexity: O(1)

 Approach 2: Binary Search
 - Time Complexity: O(log x)
 - Space Complexity: O(1)
 */

public class Square_Root {

    public static int mySqrt(int x) {
        // Approach 1: Newton's Method

        if (x < 2) {
            return x;
        }

        long guess = x;

        while (guess * guess > x) {
            guess = (guess + x / guess) / 2;
        }

        return (int) guess;


        /*
        // Approach 2: Binary Search

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            }
            else if ((long) mid * mid < x) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
        */
    }

    public static void main(String[] args) {

        int x = 25;
        System.out.println("Number: " + x);

        System.out.println("Square Root: " + mySqrt(x));
    }
}