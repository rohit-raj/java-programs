package algo.strings;

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 */
public class LargestOddNumber {

    static String largestOddNumber(String num){
        int n = num.length();
        for (int i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2 !=0) return num.substring(0,i+1);
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "200";


        System.out.println("largestOddNumber : "+largestOddNumber(num));
    }


}
