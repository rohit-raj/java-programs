package algo.strings;

public class CheckPalindrome {

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

    public static void main(String[] args) {
        String str = "ppo";


        System.out.println("isPalindrome : "+ isPalindrome(str));
    }
}
