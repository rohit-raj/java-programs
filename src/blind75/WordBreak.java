package blind75;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/editorial/
 */
public class WordBreak {
    static boolean breakWordBrute(String s, List<String> wordDict){
        int n = s.length();
        HashSet<String> words = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * Bottom-Up Dynamic Programming
     */
    static boolean breakWordOptimal(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i=0;i<n;i++){
            for(String word : wordDict){
                int wordLength = word.length();
                if(i < wordLength-1){
                    continue;
                }

                if((i == wordLength-1) || dp[i-wordLength]){
                    if(s.substring(i-wordLength+1, i+1).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];

    }

    /**
     * Higlhy optimal
     */

    public static boolean wordBreakOptimal2(String s, List<String> wordDict){
        Boolean[] dp = new Boolean[s.length()+1];
        return solution(s, wordDict, 0, dp);
    }

    public static boolean solution(String s, List<String> wordDict, int len, Boolean[] dp){
        if(len == s.length()){
            return true;
        }

        if (dp[len] !=null) return dp[len];

        for(String word : wordDict){
            if(s.startsWith(word, len)){
                if(solution(s, wordDict, len+word.length(), dp)){
                    dp[len] = true;
                }

            }
        }
        return dp[len] == false;
    }

    static boolean solve(String s, List<String> wordDict, int length, Boolean[] dp){
        if(length == s.length()){
            return true;
        }

        if(dp[length] != null){
            return dp[length];
        }

        for(String word : wordDict){
            if (s.startsWith(word, length)) {
                if (solve(s, wordDict, length + word.length(), dp))
                    return dp[length] = true;
            }
        }
        return dp[length] = false;
    }

    static boolean breakWordRewcursive(String s, List<String> wordDict){
        Boolean[] dp = new Boolean[s.length()+1];
        return solve(s, wordDict, 0, dp);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordList = {"leet","code"};
        List<String> wordDict = Arrays.asList(wordList);

        System.out.println("breakWordBrute : "+breakWordBrute(s, wordDict));
        System.out.println("breakWordOptimal : "+breakWordOptimal(s, wordDict));
        System.out.println("breakWordRewcursive : "+breakWordRewcursive(s, wordDict));
    }
}
