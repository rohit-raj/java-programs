package algo.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backTrack(0, 0, n, "", ans);
        return ans;
    }

    public void backTrack(int open, int close, int n, String str, List<String> ans){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }

        if(open < n){
            backTrack(open+1, close, n, str+'(', ans);
        }
        if(close < open){
            backTrack(open, close+1, n, str+')', ans);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gn = new GenerateParenthesis();

        List<String> ans = gn.generateParenthesis(3);
        System.out.println("ans : "+ ans);
    }
}
