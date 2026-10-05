/**
 Find the maximum number of fruits that can be collected with at most two types of fruits.

 Approach: Sliding Window + HashMap
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Fruit_Into_Baskets {

    public static int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(
                    fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1
            );

            while (map.size() > 2) {

                int leftFruit = fruits[left];

                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] fruits = {1, 2, 1, 2, 3, 2, 2};

        System.out.println("Fruits : " + Arrays.toString(fruits));

        System.out.println("Maximum Fruits : " + totalFruit(fruits));
    }
}
