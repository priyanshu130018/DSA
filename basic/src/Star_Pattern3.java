/**
 Star Patterns

 Pattern 1: Hollow Square
 Pattern 2: Hollow Pyramid
 Pattern 3: Hollow Diamond
 Pattern 4: Hollow Star

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Star_Pattern3 {

    // Pattern 1: Hollow Square
    public static void printHollowSquare(int n) {
        /**
         * * * * *
         *       *
         *       *
         * * * * *
         **/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    // Pattern 2: Hollow Pyramid
    public static void printHollowPyramid(int n) {
        /**
            *
           * *
          *   *
         *     *
        * * * * *
        **/

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {

                if (i == n - 1 || k == 0 || k == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    // Pattern 3: Hollow Diamond
    public static void printHollowDiamond(int n) {
        /**
            *
           * *
          *   *
         *     *
        *       *
         *     *
          *   *
           * *
            *
         **/

        // Upper half
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++) {

                if (k == 0 || k == 2 * i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }

        // Lower half
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * (n - i) - 1; k++) {

                if (k == 0 || k == 2 * (n - i) - 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Hollow Square: ");
        printHollowSquare(5);
        System.out.println();

        System.out.println("Hollow Pyramid: ");
        printHollowPyramid(5);
        System.out.println();

        System.out.println("Hollow Diamond: ");
        printHollowDiamond(5);
        System.out.println();
    }
}