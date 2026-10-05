/**
 Find the first occurrence of a pattern in a given text

 Approach 1: KMP (Knuth-Morris-Pratt) Algorithm
 - Time Complexity:
   - Best Case: O(n)
   - Worst Case: O(n + m)
 - Space Complexity: O(m)

 Approach 2: Rabin-Karp Algorithm
 - Time Complexity:
   - Best Case: O(n + m)
   - Worst Case: O(n × m)
 - Space Complexity: O(1)

 Approach 3: Naive Pattern Matching
 - Time Complexity:
   - Best Case: O(n)
   - Worst Case: O(n × m)
 - Space Complexity: O(1)

 where
 n = length of the text
 m = length of the pattern
 **/

public class Pattern_Matching {
    public static int patSearch(String str, String pat){
        // Approach 1: KMP (Knuth-Morris-Pratt) algorithm

        int n = str.length();
        int m = pat.length();

        if (m==0) return 0;
        if (m>n) return -1;

        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i<m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len!=0) len = lps[len-1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // KMP Search
        i=0;
        int j=0;
        while (i<n) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            // pattern found
            if (j==m) return i-j;

            // mismatch
            else if (i<n && str.charAt(i) != pat.charAt(j)) {
                if (j!=0) {
                    j = lps[j-1];
                }
                else i++;
            }
        }

        return -1;



        /*
        // Approach 2: Rabin-Karp algorithm

        int n = str.length();
        int m = pat.length();

        int d = 256;
        int q = 101;
        int h = 1;
        for(int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        int p = 0;
        int t = 0;

        // initial hash values
        for(int i = 0; i < m; i++){
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + str.charAt(i)) % q;
        }

        for(int i = 0; i <= n - m; i++){
            // hash matched
            if(p == t){
                int j;
                for(j = 0; j < m; j++){
                    if(str.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if(j == m) return i;
            }

            // calculate next window hash
            if(i < n - m){
                t = (d * (t - str.charAt(i) * h) + str.charAt(i + m)) % q;
                if(t < 0) t += q;
            }
        }
        return -1;
        */



        /*
        // Approach 3: Naive Pattern Matching

        int n=str.length();
        int m=pat.length();
        for(int i=0; i<=n-m;){
            int j;
            for(j=0; j<m; j++){
                if(pat.charAt(j)!=str.charAt(i+j))
                    break;
            }
            // pattern found
            if(j==m) return i;

            // pattern not found (first letter)
            if(j==0) i++;

            // slide the pattern
            else i=i+j;
        }
        return -1;
        */
    }

    public static void main(String[] args) {

        String str = "hello world";
        String pat = "world";

        int res = patSearch(str, pat);
        if (res == -1) {
            System.out.println("Pattern not found");
        } else {
            System.out.println("Pattern found at index " + res);
        }
    }
}
