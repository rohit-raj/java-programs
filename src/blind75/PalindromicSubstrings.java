package blind75;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    static boolean isPalindrome(String str){
        int n = str.length();
        int left = 0;
        int right = n-1;
        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static int countSubstringsBrute(String str){
        int n = str.length();
        if(isPalindrome(str)){
            return n*(n+1)/2;
        } else {
            return n;
        }
    }

    static int countSubstringsOptimal(String str){
        int res = 0;
        int n = str.length();

        for(int i=0;i<n;i++){
            int odd = iterateFromMiddle(str, i, i);
            int even = iterateFromMiddle(str, i, i+1);
            res +=odd;
            res +=even;
        }

        return res;
    }

    static int iterateFromMiddle(String str, int left, int right){
        int count = 0;
        while (left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "pooop";

//        System.out.println("countSubstringsBrute : "+countSubstringsBrute(str));
        System.out.println("countSubstringsOptimal : "+countSubstringsOptimal(str));
    }
}
