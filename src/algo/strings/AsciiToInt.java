package algo.strings;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class AsciiToInt {
    public static int myAtoi(String str) {
        int sign = 1;
        int result = 0;
        int i = 0;

        if(str.length() == 0) return 0;

        while(i < str.length() && str.charAt(i) == ' ') i++;

        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = str.charAt(i++) == '+' ? 1 : -1;

        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(result > Integer.MAX_VALUE/10 ||
                    (result == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > Integer.MAX_VALUE %10)) {
                return (sign ==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result *10 + (str.charAt(i++) - '0');
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println("atoi :: "+ myAtoi("words with 987"));
    }
}
