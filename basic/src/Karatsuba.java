public class Karatsuba {
    public static long karatsuba(long x, long y) {
        if (x < 10 || y < 10) return x * y;

        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        int half = n / 2;
        long pow = (long) Math.pow(10, half);
        long a = x / pow;
        long b = x % pow;
        long c = y / pow;
        long d = y % pow;

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long abcd = karatsuba(a + b, c + d);

        long ad_bc = abcd - ac - bd;

        return (long)(ac*Math.pow(10,2*half) + ad_bc*Math.pow(10,half) + bd);
    }
    public static void main(String[] args) {
        long x=1234,y=5678;
        System.out.println("Result="+karatsuba(x,y));
    }
}
