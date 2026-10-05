/**
 Check whether the number is a palindrome

 Approach: Reverse the Number
 - Time Complexity: O(log n)
 - Space Complexity: O(1)
 */
public class Check_Palindrome {

    public static int checkPali(int num) {
        int rev = 0;

        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }

        return rev;
    }

    public static void main(String[] args) {

        int num = 121;
        System.out.println("Number: " + num);

        int rev = checkPali(num);
        if (num == rev) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not Palindrome!");
        }
    }
}
