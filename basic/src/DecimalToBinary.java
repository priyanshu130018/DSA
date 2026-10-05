/**
 Convert a decimal number into binary

 Approach: Repeated Division by 2
 - Time Complexity: O(log n)
 - Space Complexity: O(log n)
 */

public class DecimalToBinary {

    public static String convert(int n) {
        String val = "";

        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            val = rem + val;
        }

        return val;
    }

    public static void main(String[] args) {

        int n = 100;
        System.out.println("Decimal: " + n);

        String val = convert(n);
        System.out.println("Binary: " + val);
    }
}