/**
 Find the maximum profit from multiple buy and sell transactions

 Approach: Greedy Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

import java.util.Arrays;

public class Buy_Sell_Stock_2 {

    public static int bestTimeBuySell(int[] prices) {
        // Approach: Greedy Traversal

        int curProfit = 0;
        int totalProfit = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {

                curProfit = prices[i+1] - prices[i];
                totalProfit += curProfit;
            }

        }
        return totalProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Given prices of stock: " + Arrays.toString(prices));

        int res = bestTimeBuySell(prices);
        System.out.println("Max Profit: " + res);
    }
}
