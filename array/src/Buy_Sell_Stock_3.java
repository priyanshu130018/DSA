/**
 Find the maximum profit by completing at most two buy and sell transactions

 Approach: Dynamic Programming
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Buy_Sell_Stock_3 {

    public static int bestTimeBuySell(int[] prices) {
        // Approach: Dynamic Programming

        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;

        int profit1 = 0;
        int profit2 = 0;

        for (int price : prices) {

            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);

            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.println("Given prices of stock: " + Arrays.toString(prices));
        int res = bestTimeBuySell(prices);
        System.out.println("Max Profit: " + res);
    }
}