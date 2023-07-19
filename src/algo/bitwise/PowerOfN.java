package algo.bitwise;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowerOfN {

    static double myPow(double x, long n) {
        if(n == 0) return 1.0;
        if(n < 0) {
            n = -1*n;
            x = 1.0/x;
        }

        double res = 1;

        while (n != 0) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if (n % 2 == 1) {
                res = res * x;
                n -= 1;
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x = x * x;
            n = n / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -2147483648;
        System.out.println(x +" to the power "+n+" = "+myPow(x,n));
    }
}
