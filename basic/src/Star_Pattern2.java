/**
 Star Patterns

 Pattern 1: Pyramid
 Pattern 2: Inverted Pyramid
 Pattern 3: Diamond

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Star_Pattern2 {

    // Pattern 1: Pyramid
    public static void printPyramid(int n) {
        /**
                *
              * * *
            * * * * *
          * * * * * * *
        * * * * * * * * *
         **/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Pattern 2: Inverted Pyramid
    public static void printInvertedPyramid(int n) {
        /**
        * * * * * * * * *
          * * * * * * *
            * * * * *
              * * *
                *
         **/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < 2 * (n - i) - 1; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Pattern 3: Diamond
    public static void printDiamond(int n) {
        /**
                *
              * * *
            * * * * *
          * * * * * * *
        * * * * * * * * *
          * * * * * * *
            * * * * *
              * * *
                *
         **/

        // Upper half
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower half
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < 2 * (n - i) - 1; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Pyramid:");
        printPyramid(5);
        System.out.println();

        System.out.println("Inverted Pyramid:");
        printInvertedPyramid(5);
        System.out.println();

        System.out.println("Diamond:");
        printDiamond(5);
        System.out.println();
    }
}