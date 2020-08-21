package algo.misc;

/**
 * Created by Rohit on 18/08/20.
 * Karatsuba is the fastest algorithm for multiplying numbers
 * O(n^1.59)
 * formula
 * (10^len)*(x1y1) + (10^(len/2))*[a1a2 - (x1y1 + x2y2)] + x2y2
 */
class KaratsubaAlgo {
    String multiply (String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2) {
            b = digitPadding(a, b);
        } else if( len2 > len1) {
            a = digitPadding(b, a);
        }

        int len = a.length();

        if(len == 0) return "0";
        if(len == 1) {
            int res = (a.charAt(0) -'0')* (b.charAt(0) - '0');
            return res+"";
        }

        String x1 = a.substring(0,len/2);
        String x2 = a.substring(len/2, len);

        String y1 = b.substring(0,len/2);
        String y2 = b.substring(len/2, len);

        String a1 = add(x1, x2);
        String a2 = add(y1, y2);

        String x1y1 = multiply(x1, y1);

        String x2y2 = multiply(x2, y2);

        String a1a2 = multiply(a1, a2);

        String commonAdd = add(x1y1, x2y2);

        String sub = subtract(a1a2, commonAdd);

        double m = (double) len;
        String op1 = power(2*Math.ceil(m/2), x1y1);
        String op2 = power(Math.ceil(m/2), sub);
        String op3 = add(op1, op2);
        return add(op3, x2y2);


        //formula
        //(10^len)*(x1y1)   +   (10^(len/2))*[a1a2 - (x1y1 + x2y2)]   +  x2y2
        //----------------     ----------------------------------       -----
        //      p                              q                          r

    }

    static String add(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2) {
            b = digitPadding(a, b);
        } else if( len2 > len1) {
            a = digitPadding(b, a);
        }

        int len = a.length();
//        System.out.println("len : "+len+" : str1 : "+ a + " : str2 : "+ b);
        int [] res = new int[len + 1];

        for(int i = len-1; i >= 0; i--) {
            res[i+1] = res[i+1] + ((a.charAt(i) - '0') + (b.charAt(i) - '0'));
//            System.out.println("i :: "+i+" :: res[i+1] : "+res[i+1]);
            res[i] = res[i] + res[i+1]/10;
            res[i+1] = res[i+1]%10;
//            System.out.println("xx : "+res[i+1]);
        }
        StringBuilder sb = new StringBuilder();
        for(int p : res) {
            if(!(sb.length() == 0 && p ==0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    static String subtract(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2) {
            b = digitPadding(a, b);
        } else if( len2 > len1) {
            a = digitPadding(b, a);
        }

        int len = a.length();
        int [] res = new int[len];

        for(int i = len-1; i >= 0; i--) {
            int x = res[i] + a.charAt(i) - '0';
            int y = b.charAt(i)- '0';
            if(x < y) {
                x += 10;
                res[i-1] = -1;
            }
            res[i] = x - y;
        }
        StringBuilder sb = new StringBuilder();
        for(int p : res) {
            if(!(sb.length() == 0 && p ==0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    static String digitPadding (String a, String b) {
        int size = Math.abs(a.length() - b.length());
        for (int i = 1; i <= size; i++)
            b = "0" + b;
        return b;
    }

    static String power(double n, String number) {
        for (int i = 0; i < n; i++) {
            number += "0";
        }
        return number;
    }

    public static void main(String[] args) {
        KaratsubaAlgo ksAlgo = new KaratsubaAlgo();

        String m = "123";
        String n = "321";
        System.out.printf("multiple of " + m + " * " + n + " = " + ksAlgo.multiply(m, n));
    }
}
