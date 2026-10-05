/**
 Assign cookies to children to satisfy the maximum number of children.

 Approach: Greedy + Two Pointer
 - Time Complexity: O(n log n + m log m)
 - Space Complexity: O(1)
 **/

import java.util.*;

public class Assign_Cookies {

    public static int findContentChildren(int[] children, int[] cookies) {

        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        int cookie = 0;

        while (child < children.length && cookie < cookies.length) {

            if (cookies[cookie] >= children[child]) {
                child++;
            }

            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {

        int[] children = {1, 2, 3};
        int[] cookies = {1, 1};

        System.out.println("Children: " + Arrays.toString(children));
        System.out.println("Cookies: " + Arrays.toString(cookies));

        int result = findContentChildren(children, cookies);

        System.out.println("Maximum Satisfied Children: " + result);
    }
}
