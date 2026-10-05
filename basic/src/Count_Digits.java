/**
 Count the number of digits in a number

 Approach: Repeated Division by 10
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */

public class Count_Digits {

    public static int countDigits(int num) {
        int count = 0;

        while (num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int num = 12345;

        System.out.println("Number: " + num);
        System.out.println("Number of digits: " + countDigits(num));
    }
}