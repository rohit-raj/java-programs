package algo.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static boolean checkInclusionBetter(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1Count = new int[26];


        int s1Len = s1.length();
        int s2Len = s2.length();

        for(int i=0;i<s1Len;i++){
            s1Count[s1.charAt(i)-'a']++;
        }

        for (int j=0;j<s2Len-s1Len+1;j++){
            int[] s2Count = new int[26];
            for (int k=j;k<j+s1Len;k++){
                s2Count[s2.charAt(k)-'a']++;
            }
            if(matches(s1Count, s2Count) == 26) return true;

        }
        return false;
    }


    public static int matches(int[] s1Count, int[] s2Count){
        int count=0;
        for(int i=0;i<26;i++){
            if(s1Count[i]==s2Count[i]) count++;
        }
//        System.out.println("count = "+ count);
        return count;
    }

    public static boolean checkInclusionOptimal(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int n=s1.length();
        int m=s2.length();
        int[] s1Freq = new int[26];
        for(int i=0;i<n;i++){
            s1Freq[s1.charAt(i)-'a']++;
        }

        int[] s2Freq = new int[26];
        for (int i=0;i<m;i++){
            s2Freq[s2.charAt(i)-'a']++;
            if(i>=n){
                s2Freq[s2.charAt(i-n)-'a']--;
            }
            if(Arrays.equals(s1Freq, s2Freq)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";

        System.out.println("checkInclusionBetter : "+checkInclusionBetter(s1, s2));
        System.out.println("checkInclusionOptimal : "+checkInclusionOptimal(s1, s2));

    }
}
