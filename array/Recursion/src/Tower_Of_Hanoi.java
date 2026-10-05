/**
 Move all disks from source rod to destination rod using an auxiliary rod.

 Approach: Recursion
 - Time Complexity: O(2^n)
 - Space Complexity: O(n)
 **/

public class Tower_Of_Hanoi {

    public static void towerOfHanoi(
            int n,
            char source,
            char auxiliary,
            char destination) {

        // Base Case
        if (n == 0) {
            return;
        }

        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Move current disk from source to destination
        System.out.println(
                "Move disk " + n +
                        " from " + source +
                        " to " + destination
        );

        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {

        int n = 3;

        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
