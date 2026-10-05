/**
 Star Patterns

 Pattern 1: Square
 Pattern 2: Left Triangle
 Pattern 3: Inverted Left Triangle
 Pattern 4: Right Triangle
 Pattern 5: Inverted Right Triangle

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Star_Pattern1 {

    // Pattern 1: Square
    public static void printSquare(int n) {
        /**
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 2: Left Triangle
    public static void printLeftTriangle(int n) {
        /**
         *
         * *
         * * *
         * * * *
         * * * * *
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 3: Inverted Left Triangle
    public static void printInvertedLeftTriangle(int n) {
        /**
         * * * * *
         * * * *
         * * *
         * *
         *
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 4: Right Triangle
    public static void printRightTriangle(int n) {
        /**
                 *
               * *
             * * *
           * * * *
         * * * * *
         */

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Pattern 5: Inverted Right Triangle
    public static void printInvertedRightTriangle(int n) {
        /**
         * * * * *
           * * * *
             * * *
               * *
                 *
         */

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < n - i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Square Pattern:");
        printSquare(5);
        System.out.println();

        System.out.println("Left Triangle:");
        printLeftTriangle(5);
        System.out.println();

        System.out.println("Inverted Left Triangle:");
        printInvertedLeftTriangle(5);
        System.out.println();

        System.out.println("Right Triangle:");
        printRightTriangle(5);
        System.out.println();

        System.out.println("Inverted Right Triangle:");
        printInvertedRightTriangle(5);
        System.out.println();
    }
}