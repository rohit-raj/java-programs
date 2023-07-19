package algo.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static int lengthOfLongestSubstringBrute(String str){
        int n = str.length();

        if(n == 0){
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();

            for(int j=i;j<n;j++){
                if(set.contains(str.charAt(j))){
                    maxLen = Math.max(maxLen, j-i);
                    break;
                }
                set.add(str.charAt(j));
            }
        }
        return maxLen;
    }


    static int lengthOfLongestSubstringOptimal(String str){
        int n = str.length();

        if(n == 0){
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>();

        int left = 0;
        for(int right=0;right<n;right++){
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                maxLen = Math.max(maxLen, right-left+1);
            } else {
                while (set.contains(str.charAt(right))){
                    set.remove(str.charAt(left));
                    left++;
                }
                set.add(str.charAt(right));
            }
        }
        return maxLen;

    }
    public static void main(String[] args) {
        String str = "abcabcdqb";


        System.out.println("lengthOfLongestSubstringBrute : "+ lengthOfLongestSubstringBrute(str));
        System.out.println("lengthOfLongestSubstringOptimal : "+ lengthOfLongestSubstringOptimal(str));
    }
}
