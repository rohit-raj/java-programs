package algo.strings;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();

        int[] count = new int[26];
        for (String str : strs){
            Arrays.fill(count, 0);
            for(char c : str.toCharArray())count[c-'a']++;

            StringBuilder s = new StringBuilder();
            for(int i=0;i<26;i++){
                s.append("#");
                s.append(count[i]);
            }

            String key = s.toString();
            System.out.println("key : "+ key);

            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());

    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> ans = groupAnagrams(strs);

        System.out.println("ans : "+ ans);
    }
}
