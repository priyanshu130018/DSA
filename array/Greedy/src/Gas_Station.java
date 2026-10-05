/**
 Find the starting gas station from which the car can complete the circuit.

 Approach: Greedy Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Gas_Station {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println("Gas: " + Arrays.toString(gas));
        System.out.println("Cost: " + Arrays.toString(cost));

        int result = canCompleteCircuit(gas, cost);

        System.out.println("Starting Station: " + result);
    }
}
