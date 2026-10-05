/**
 Convert an integer to Roman numeral

 Approach 1: Arrays + Greedy
 - Time Complexity: O(1)
 - Space Complexity: O(1)

 Approach 2: Digit Lookup Tables
 - Time Complexity: O(1)
 - Space Complexity: O(1)

 Approach 3: TreeMap + Greedy
 - Time Complexity: O(log k) per floorKey lookup
 where
 k = 13 (effectively O(1))

 - Space Complexity: O(1)
 */


public class Integer_To_Roman {

    public static String convertIntToRoman(int val) {
        // Approach 1: Array + Greedy

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] roman = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (val >= values[i]) {
                ans.append(roman[i]);
                val -= values[i];
            }
        }
        return ans.toString();




        /*
        // Approach 2: Digit Lookup Tables
        // Valid only for the standard Roman numeral range (1–3999)

        String[] thousands = {"", "M", "MM", "MMM"};

        String[] hundreds = {
                "", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM"
        };

        String[] tens = {
                "", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC"
        };

        String[] ones = {
                "", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX"
        };

        return thousands[val / 1000]
                + hundreds[(val % 1000) / 100]
                + tens[(val % 100) / 10]
                + ones[val % 10];
        */




        /*
        // Approach 3: TreeMap + Greedy

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder ans = new StringBuilder();
        while (val > 0) {
            int curVal = map.floorKey(val);
            ans.append(map.get(curVal));
            val -= curVal;
        }

        return ans.toString();
        */
    }

    public static void main(String[] args) {

        int val = 3888; // MMMDCCCLXXXVIII
        System.out.println("Integer: " + val);

        String ans = convertIntToRoman(val);
        System.out.println("Roman: " + ans);
    }
}
