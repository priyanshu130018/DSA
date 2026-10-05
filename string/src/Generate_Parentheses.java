/**
 Generate all combinations of well-formed parentheses for n pairs of parentheses

 Approach 1: Backtracking + StringBuilder
 - Time Complexity: O()
 - Space Complexity: O()

 Approach 2: DP
 - Time Complexity: O()
 - Space Complexity: O()
 */

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        extend(res, str, 0, 0, n);
        return res;
    }
    public static void extend(List<String> res, StringBuilder str, int open, int close, int n) {

        if (str.length() == 2*n) {
            res.add(str.toString());
            return;
        }
        if (open < n) {
            str.append("(");
            extend(res, str, open+1, close, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(")");
            extend(res, str, open, close+1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
