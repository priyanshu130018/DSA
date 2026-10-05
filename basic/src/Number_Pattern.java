/**
 Number Patterns

 Pattern 1: Decreasing Number Triangle
 Pattern 2: Right-Aligned Decreasing Number Triangle
 Pattern 3: Decreasing Number Sequence Triangle
 Pattern 4: Left-Aligned Decreasing Number Triangle
 Pattern 5: Increasing Number Pyramid

 - Time Complexity: O(n²)
 - Space Complexity: O(1)
 */

public class Number_Pattern {

    // Pattern 1: Decreasing Number Triangle
    public static void pattern1(int n) {
        /**
         1 1 1 1 1
         2 2 2 2
         3 3 3
         4 4
         5
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Pattern 2: Right-Aligned Decreasing Number Triangle
    public static void pattern2(int n) {
        /**
         5 5 5 5 5
         4 4 4 4
         3 3 3
         2 2
         1
         */

        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    // Pattern 3: Decreasing Number Sequence Triangle
    public static void pattern3(int n) {
        /**
         1 2 3 4 5
         1 2 3 4
         1 2 3
         1 2
         1
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Pattern 4: Left-Aligned Decreasing Number Triangle
    public static void pattern4(int n) {
        /**
         5 5 5 5 5
         4 4 4 4
         3 3 3
         2 2
         1
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < n - i + 1; k++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    // Pattern 5: Increasing Number Pyramid
    public static void pattern5(int n) {
        /**
         1 2 3 4 5
         2 3 4
         3
         */

        for (int i = n; i > 0; i--) {

            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }

            int start = n - i + 1;
            int end = start + (2 * i - 2);

            for (int k = start; k <= end; k++) {
                System.out.print(k + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Pattern 1:");
        pattern1(5);

        System.out.println("\nPattern 2:");
        pattern2(5);

        System.out.println("\nPattern 3:");
        pattern3(5);

        System.out.println("\nPattern 4:");
        pattern4(5);

        System.out.println("\nPattern 5:");
        pattern5(3);
    }
}