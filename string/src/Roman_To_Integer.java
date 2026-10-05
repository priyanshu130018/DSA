/**
 Convert a Roman numeral to an integer

 Approach 1: Enhanced Switch + Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach 2: HashMap + Traversal
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 */

public class Roman_To_Integer {

    // Approach 1: Using Switch
    private static int value(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int curVal = value(s.charAt(i));

            if (i < s.length() - 1) {
                int nextVal = value(s.charAt(i + 1));

                if (curVal < nextVal)
                    ans -= curVal;
                else
                    ans += curVal;
            } else {
                ans += curVal;
            }
        }

        return ans;
    }


    /*
    // Approach 2: HashMap + Traversal

    public static int convertRomanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        for (int i = 0; i < s.length(); i++) {
            int curVal = map.get(String.valueOf(s.charAt(i)));

            if (i < s.length() - 1 &&
                    curVal < map.get(String.valueOf(s.charAt(i + 1)))) {
                ans -= curVal;
            }
            else ans += curVal;
        }

        return ans;
    }
    */



    public static void main(String[] args) {

        String s = "MCMXCIV"; // 1000 + 900 + 90 + 4
        System.out.println("Roman: " + s);

        int ans = romanToInt(s);
        System.out.println("Integer: " + ans);
    }
}
