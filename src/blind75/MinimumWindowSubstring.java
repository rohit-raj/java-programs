package blind75;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int start=0;
        int minLen = s.length();
        int matched = 0;
        int subStrStart = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);

        for(int endWindow=0;endWindow<s.length();endWindow++){
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()){
                if(minLen >= endWindow-start+1){
                    minLen = endWindow-start+1;
                    subStrStart = start;
                }
                char deleted = s.charAt(start++);
                if(map.containsKey(deleted)){
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(subStrStart, subStrStart+minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Min window : "+ minWindow(s, t));
    }
}
