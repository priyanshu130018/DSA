/**
 Find the maximum profit from a single buy and sell transaction

 Approach: One Pass Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Buy_Sell_Stock_1 {

    public static int bestTimeBuySell(int[] prices) {
        // Approach: One Pass Traversal

        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for (int val : prices) {
            if (val < buy) {
                buy = val;
            }
            profit = Math.max(profit, val - buy);
        }

        /*
        buy = Math.min(buy, val);
        profit = Math.max(profit, val - buy);
        */

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Given prices of stock: " + Arrays.toString(prices));
        int res = bestTimeBuySell(prices);
        System.out.println("Max Profit: " + res);
    }
}
