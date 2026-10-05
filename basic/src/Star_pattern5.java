/**
 Star Patterns

 Pattern 1: Hourglass
 Pattern 2: Sandglass

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Star_pattern5 {

    // Pattern 1: Hourglass Pattern
    public static void printHourglassPattern(int n) {
        /**
        * * * * *
         * * * *
          * * *
           * *
            *
           * *
          * * *
         * * * *
        * * * * *
         **/

        // Upper half
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < n - i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower half
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Pattern 2: Sandglass Pattern
    public static void printSandglassPattern(int n) {
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

        System.out.println("Hourglass Pattern:");
        printHourglassPattern(5);
        System.out.println();

        System.out.println("Sandglass Pattern:");
        printSandglassPattern(5);
        System.out.println();
    }
}