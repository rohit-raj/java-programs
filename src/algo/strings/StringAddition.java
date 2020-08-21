package algo.strings;

/**
 * Created by rohit on 21/08/20.
 */
public class StringAddition {
    static String digitPadding (String a, String b) {
        int size = Math.abs(a.length() - b.length());
        for (int i = 1; i <= size; i++)
            b = "0" + b;
        return b;
    }

    String addNumbers(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2) {
            b = digitPadding(a, b);
        } else if( len2 > len1) {
            a = digitPadding(b, a);
        }

        int len = a.length();
        System.out.println("len : "+len+" : str1 : "+ a + " : str2 : "+ b);
        int [] res = new int[len + 1];

        for(int i = len-1; i >= 0; i--) {
            res[i+1] = res[i+1] + ((a.charAt(i) - '0') + (b.charAt(i) - '0'));
            System.out.println("i :: "+i+" :: res[i+1] : "+res[i+1]);
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

    public static void main(String[] args) {
        StringAddition sAdd = new StringAddition();
        String num1 = "0";
        String num2 = "0";
        String res = sAdd.addNumbers(num1, num2);
        System.out.println(num1+ " + " + num2 + " = " + res);
    }
}

/*
java.lang.StringIndexOutOfBoundsException: String index out of range: 1
  at line 48, java.base/java.lang.StringLatin1.charAt
  at line 709, java.base/java.lang.String.charAt
  at line 28, Solution.addStrings
  at line 54, __DriverSolution__.__helper__
  at line 87, __Driver__.main
 */
