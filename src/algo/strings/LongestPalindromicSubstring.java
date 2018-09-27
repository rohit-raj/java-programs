package algo.strings;

class LongestPalindromicSubstring {
    static void longestPalinSubstr(String str){
        int n = str.length();

        boolean table [][] = new boolean[n][n];

        int maxLength = 1;
        /* All substring of length 1 are palindrome, hence true*/
        for(int i = 0; i < n; ++i){
            table[i][i] = true;
        }

        /*Check for string of length 2, if palindrome then make it true*/
        int start = 0;
        for(int i = 0; i < n-1; ++i){
            if(str.charAt(i) == str.charAt(i+1)){
                table[i][i+1] = true;
                start = 1;
                maxLength = 2;
            }
        }

        /*Checking for substr greater than 2*/
        for(int i = 3; i <= n; ++i){
            for(int j = 0; j < n-i+1; ++j){
                int k = i+j -1;
                if(table[j+1][k-1] && str.charAt(j) == str.charAt(k)){
                    table[j][k] = true;

                    if(i > maxLength){
                        start = j;
                        maxLength = i;
                    }
                }
            }
        }

        System.out.println("Longest palindrome substring is: "+ str.substring(start, (start+maxLength)));
        System.out.println("length of substring : "+ maxLength);

    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";

        longestPalinSubstr(str);
    }
}