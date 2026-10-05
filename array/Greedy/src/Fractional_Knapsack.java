/**
 Maximize the total value in a knapsack by taking whole or fractional items within the given capacity.

 Approach: Greedy + Sorting
 - Time Complexity: O(n log n)
 - Space Complexity: O(n)
 **/

import java.util.*;

public class Fractional_Knapsack {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static double fractionalKnapsack(
            int[] values,
            int[] weights,
            int capacity) {

        int n = values.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, (a, b) ->
                Double.compare(
                        (double) b.value / b.weight,
                        (double) a.value / a.weight
                )
        );

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {

            if (remainingCapacity == 0) {
                break;
            }

            if (item.weight <= remainingCapacity) {

                totalValue += item.value;
                remainingCapacity -= item.weight;

            } else {

                totalValue +=
                        ((double) item.value / item.weight)
                                * remainingCapacity;

                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Weights: " + Arrays.toString(weights));
        System.out.println("Capacity: " + capacity);

        double result =
                fractionalKnapsack(values, weights, capacity);

        System.out.println("Maximum Value: " + result);
    }
}
