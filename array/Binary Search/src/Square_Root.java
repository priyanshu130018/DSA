/**
 Find the integer square root of a given number.

 Approach: Binary Search
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 **/

public class Square_Root {

    public static int squareRoot(int n) {

        if (n < 2) {
            return n;
        }

        int low = 1;
        int high = n;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 25;

        int result = squareRoot(n);

        System.out.println("Square Root = " + result);
    }
}
