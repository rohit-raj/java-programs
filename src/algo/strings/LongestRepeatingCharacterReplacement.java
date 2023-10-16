package algo.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int low = 1;
        int high = s.length();

        int ans = 0;
        while (low <= high){
            int mid = low + (high-low)/2;

            if(canMakeValidSubstring(s, mid, k)) {
                ans = low;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low-1;
    }

    public static boolean canMakeValidSubstring(String s, int subStrLen, int k){
        int[] map = new int[26];
        Arrays.fill(map, 0);
        int maxFreq = 0;
        int start = 0;

        for (int end=0;end<s.length();end++){
            map[s.charAt(end)-'A'] += 1;

            if (end + 1 - start > subStrLen) {
                map[s.charAt(start)-'A'] -= 1;
                start += 1;
            }

            maxFreq = Math.max(maxFreq, map[s.charAt(end)-'A']);
            if(subStrLen - maxFreq <=k){
                return true;
            }
        }
        return false;
    }

    //without binary search method
    public static int characterReplacementOptimal(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            while ( end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ABABBA";
        int k = 2;

//        System.out.println("characterReplacement : "+characterReplacement(s, k));
        System.out.println("characterReplacementOptimal : "+characterReplacementOptimal(s, k));
    }
}
