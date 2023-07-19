package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static void helper(int index, String s, List<String> temp, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i< s.length();i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                helper(i+1, s, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(0, s, temp, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println("partition : "+ partition(s));
    }
}
