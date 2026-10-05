/**
 Star Patterns

 Pattern 1: X Pattern
 Pattern 2: Plus Pattern
 Pattern 3: Zig-Zag Pattern

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Star_Pattern4 {

    // Pattern 1: X Pattern
    public static void printXPattern(int n) {
        /**
        *       *
           *   *
             *
           *   *
         *       *
         **/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j || i + j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    // Pattern 2: Plus Pattern
    public static void printPlusPattern(int n) {

         /**
             *
             *
         * * * * *
             *
             *
         **/

        int mid = n / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == mid || j == mid) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }


    // Pattern 3: Zig-Zag Pattern
    public static void printZigZagPattern(int n) {
        /**
         *       *       *
          *   *   *   *
           *       *
         **/

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0 && j % 4 == 0) ||
                        (i == 1 && j % 2 == 1) ||
                        (i == 2 && j % 4 == 2)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("X Pattern:");
        printXPattern(5);
        System.out.println();

        System.out.println("Plus Pattern:");
        printPlusPattern(5);
        System.out.println();

        System.out.println("Zig-Zag Pattern:");
        printZigZagPattern(9);
        System.out.println();
    }
}