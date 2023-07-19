package blind75;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * https://www.youtube.com/watch?v=QfZvw8_jz1w : Optimal
 */
class LongestPalindromicSubstring {

    static boolean checkPalin(int left, int right, String str){
        while (left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static String longestPalinSubstrBrute(String str){
        for (int length = str.length(); length > 0; length--) {
            for (int start = 0; start <= str.length() - length; start++) {

                if (checkPalin(start, start + length-1, str)) {
                    return str.substring(start, start + length);
                }
            }
        }
        return "";
    }

    static String longestPalinSubstrBetter(String str){
        int n = str.length();

        boolean table [][] = new boolean[n][n];

        int end = 1;
        /* All substring of length 1 are palindrome, hence true*/
        for(int i = 0; i < n; ++i){
            table[i][i] = true;
        }

        /*Check for string of length 2, if palindrome then make it true*/
        int start = 0;
        for(int i = 0; i < n-1; ++i){
            if(str.charAt(i) == str.charAt(i+1)){
                table[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }

        /*Checking for substr greater than 2*/
        for(int i = 2; i < n; ++i){
            for(int j = 0; j < n-i; ++j){
                int k = j+i;
                if(table[j+1][k-1] && str.charAt(j) == str.charAt(k)){
                    table[j][k] = true;
                    start = j;
                    end = k;
                }
            }
        }

//        System.out.println("Longest palindrome substring is: "+ str.substring(start, (start+end)));
//        System.out.println("length of substring : "+ end);
        return str.substring(start, end+1);

    }

    static String longestPalinSubstrOptimal(String str){
        int n = str.length();
        int start = 0, end = 0;

        for(int i=0;i<n;i++){
            int odd = iterateFromMiddle(str, i, i);
            int even = iterateFromMiddle(str, i, i+1);

            int len = Math.max(odd, even);

            if(len > (end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return str.substring(start, end+1);
    }

    static int iterateFromMiddle(String str, int left, int right){
        while(left>=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
//        String str = "cbdyrtchbabadqesrb";
        String str = "cababaqqab";

        System.out.println("longestPalinSubstrBrute : "+ longestPalinSubstrBrute(str));
        System.out.println("longestPalinSubstrBetter : "+ longestPalinSubstrBetter(str));
        System.out.println("longestPalinSubstrOptimal : "+ longestPalinSubstrOptimal(str));
    }
}