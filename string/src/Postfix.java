/**
 Evaluate a postfix expression using a stack

 Approach 1: Stack
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 */

import java.util.Stack;

public class Postfix {
    static final long MOD = 1000000007;

    public static int evaluatePostfix(String[] exp) {
        Stack<Long> stack = new Stack<>();

        for (String token : exp) {
            if (isOperator(token)) {
                long b = stack.pop();
                long a = stack.pop();
                long res = 0;

                switch (token) {
                    case "+":
                        res = (a + b) % MOD;
                        break;
                    case "-":
                        res = (a - b) % MOD;
                        if (res < 0) res += MOD;
                        break;
                    case "*":
                        res = (a * b) % MOD;
                        break;
                    case "/":
                        res = (a * modInverse(b, MOD)) % MOD;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Long.parseLong(token) % MOD);
            }
        }

        long ans = stack.pop();

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return (int) (ans % MOD);
        }
        return (int) ans;
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static long modInverse(long a, long m) {
        return modPow(a, m - 2, m);
    }

    private static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] Args){

        String exp = "3 5 + 3 *";
        String[] str=exp.split(" ");
        System.out.println(evaluatePostfix(str));
    }
}
