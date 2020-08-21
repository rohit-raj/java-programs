package algo.strings;

/**
 * Created by rohit on 21/08/20.
 *
 * tested on inputs
 * 1111*0 = 0
 * 12*12 = 144
 * 123456789*987654321 = 121932631112635269
 */
public class StringMultiplication {
    private String multiply(String num1, String num2) {
        if((num1.charAt(0) == 0 && num1.length() == 1) || (num2.charAt(0) == 0 && num2.length() == 1))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();

        int [] res = new int[len1 + len2];

        for(int i = len1-1; i >=0; i--) {
            for(int j = len2-1; j >=0; j--) {
                res[i+j+1] = res[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i+j] = res[i+j] + res[i+j+1]/10;
                res[i+j+1] = res[i+j+1]%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : res) {
            if(!(sb.length() == 0 && p ==0)) sb.append(p);
        }
        return sb.length() ==0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        StringMultiplication sm = new StringMultiplication();
        String num1 = "123456789";
        String num2 = "987654321";
        String res = sm.multiply(num1, num2);
        System.out.println(num1+ " * " + num2 + " = " + res);
    }
}
