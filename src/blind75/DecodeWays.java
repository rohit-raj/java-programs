package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public static int numDecodingsMemo(String s, int i, int[] dp) {
        if(i==s.length()) return 1;
        if(s.charAt(0) == '0') return 0;

        if(dp[i]!=-1) return dp[i];

        int count = 0;

        count += numDecodingsMemo(s, i+1, dp);
        if(i < s.length()-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
            count += numDecodingsMemo(s, i+2, dp);
        }
        dp[i] = count;
        return dp[i];
    }

    public static int numDecodingsMemo(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodingsMemo(s, 0, dp);
    }


    public static int numDecodingsTabu(String s){
        int[] dp = new int[s.length()+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;

        for(int i=2;i <= s.length();i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String inp = "226";

        System.out.println("numDecodingsMemo : "+ numDecodingsMemo(inp));
        System.out.println("numDecodingsTabu : "+ numDecodingsTabu(inp));

    }
}
