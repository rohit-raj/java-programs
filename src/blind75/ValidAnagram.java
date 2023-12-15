package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /**
     * O(NlogN)
     */
    static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();

        Arrays.sort(sStr);
        Arrays.sort(tStr);

        return Arrays.equals(sStr, tStr);
    }

    /**
     * O(n)
     */
    static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
//            System.out.println("s.charAt(i) : "+ s.charAt(i) + " :: s.charAt(i) - 'a' : " +(s.charAt(i) - 'a'));
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
//            System.out.println("t.charAt(i) : "+ t.charAt(i) + " :: t.charAt(i) - 'a' : " +(t.charAt(i) - 'a'));
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abagram", t = "bagaram";

        System.out.println("isAnagramBetter : "+isAnagramBetter(s, t));
        System.out.println("isAnagramOptimal : "+isAnagramOptimal(s, t));

    }
}
