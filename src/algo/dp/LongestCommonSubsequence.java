package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public static int subSequenceBrute(String text1, String text2){
        if (text1.length() <=0 || text2.length() <=0) return 0;

        int i = text1.length();
        int j = text2.length();
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return 1 + subSequenceBrute(text1.substring(0,i-1), text2.substring(0, j-1));
        }
        return Math.max(subSequenceBrute(text1.substring(0,i-1), text2), subSequenceBrute(text1, text2.substring(0, j-1)));
    }

    public static int subSequenceMemo(String text1, String text2, int i, int j, int[][] dp){
        if (i <0 || j <0) return 0;

        if(dp[i][j]!= -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] =  1 + subSequenceMemo(text1, text2, i-1, j-1, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(subSequenceMemo(text1, text2, i-1, j, dp), subSequenceMemo(text1, text2, i, j-1, dp));
        return dp[i][j];
    }

    public static int subSequenceMemo(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return subSequenceMemo(text1, text2, m-1, n-1, dp);
    }

    public static int subSequenceTabu(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
//        for(int[] row : dp){
//            Arrays.fill(row, -1);
//        }

        for(int i=0;i<m;i++) dp[i][0] = 0;
        for(int j=0;j<n;j++) dp[0][j] = 0;

        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                } else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "acd";
        String text2 = "aed";

        System.out.println("subSequenceBrute : "+ subSequenceTabu(text1, text2));
    }
}
