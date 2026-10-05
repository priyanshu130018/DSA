/**
 Armstrong Number
 Check whether a number is equal to the sum of its digits raised to the number of digits

 Approach: Digit Extraction + Power Sum
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */

public class Armstrong_Number {

    public static boolean isArmstrong(int num) {

        int original = num;
        int digits = 0;
        int sum = 0;

        int temp = num;

        // Count digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;

        // Calculate sum of digits raised to number of digits
        while (temp > 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, digits);
            temp /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {

        int num = 153;
        System.out.println("Number: " + num);

        if (isArmstrong(num)) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}