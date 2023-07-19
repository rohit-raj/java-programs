package blind75;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 */
public class ValidPalindrome {

    static boolean isPalindrome(String str){
        int n = str.length();
        int left = 0;
        int right = n-1;
        while (left < right){
            if(!Character.isLetterOrDigit(str.charAt(left))){
                left++;
            } else if(!Character.isLetterOrDigit(str.charAt(right))){
                right--;
            } else {
                if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str= "A man, a plan, a canal: Panama";

        System.out.println("isPalindrome :: "+isPalindrome(str));

    }
}
