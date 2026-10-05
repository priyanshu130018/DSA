/**
 Check whether the given parentheses string is valid

 Approach 1: Stack
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach 2: String Replacement
 - Time Complexity: O(n²)
 - Space Complexity: O(n)
 */


import java.util.Stack;

public class Valid_Parentheses {

    public static boolean isValid(String str) {
        // Approach 1: Using Stack

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();



        /*
        // Approach 2: String Replacement

        while (str.contains("()") || str.contains("{}") || str.contains("[]")) {

            str = str.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }
        return str.isEmpty();
        */
    }

    public static void main(String[] args) {

        String str = "{[()]}";
        System.out.println("String: " + str);

        boolean isValid = isValid(str);
        if (isValid) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }
    }
}
