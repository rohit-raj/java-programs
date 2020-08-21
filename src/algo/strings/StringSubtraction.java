package algo.strings;

/**
 * Created by rohit on 21/08/20.
 */
public class StringSubtraction {
    static String digitPadding (String a, String b) {
        int size = Math.abs(a.length() - b.length());
        for (int i = 1; i <= size; i++)
            b = "0" + b;
        return b;
    }

    String subtract(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2) {
            b = digitPadding(a, b);
        } else if( len2 > len1) {
            a = digitPadding(b, a);
        }

        int len = a.length();
        System.out.println("len : "+len+" : str1 : "+ a + " : str2 : "+ b);
        int [] res = new int[len];

        for(int i = len-1; i >= 0; i--) {
            int x = res[i] + a.charAt(i) - '0';
            int y = b.charAt(i) - '0';
//            System.out.println("before :: x : "+x+" : y : "+ y);
            if(x < y) {
                x += 10;
//                int temp = (a.charAt(i-1) - '0') - 1;
                res[i-1] = -1;
            }
            System.out.println("after :: x : "+x+" : y : "+ y+" : res[i] : "+res[i]);
            res[i] = x - y;
        }
        StringBuilder sb = new StringBuilder();
        for(int p : res) {
            if(!(sb.length() == 0 && p ==0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        StringSubtraction sub = new StringSubtraction();
        String num1 = "120";
        String num2 = "28";
        String res = sub.subtract(num1, num2);
        System.out.println(num1+ " - " + num2 + " = " + res);
    }
}
