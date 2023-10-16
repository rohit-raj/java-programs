package algo.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReorganiseString {

    public static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 50) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static String reorganizeString(String s) {
        int[] indexes = new int[26];

        int max = -1;
        int maxIndex = -1;
        int i;
        for(i=0;i<s.length();i++){
            indexes[s.charAt(i) - 'a']++;
            int index = indexes[s.charAt(i) - 'a'];
            if(max < index){
                max = index;
                maxIndex = s.charAt(i) - 'a';
            }
        }

        int sumOfAllNotMax = i-max;

        System.out.println("arr : "+ Arrays.stream(indexes).boxed().collect(Collectors.toList()));
        System.out.println("max : "+ max+" : maxIndex : "+ maxIndex + " : sumOfAllNotMax : "+ sumOfAllNotMax);

        if(max-sumOfAllNotMax > 1)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        while (max != 0){
            ans[index] = (char) (maxIndex+'a');
            max--;
            indexes[maxIndex]--;
            index+=2;
        }
        System.out.println("String.valueOf(ans) : "+ Arrays.toString(ans));

        for(i=0;i<indexes.length;i++){
            while (indexes[i]>0){
                if(index>=s.length()){
                    index=1;
                }
                ans[index] = (char)(i+'a');
                index+=2;
                indexes[i]--;
            }
        }
        return String.valueOf(ans);
    }

    public static String reorganizeString2(String s) {
        Map<Character, Integer> indexes = new HashMap<>();

        int max = -1;
        char maxChar = '*';
        int i;
        for(i=0;i<s.length();i++){
            int count = indexes.getOrDefault(s.charAt(i), 0);
            indexes.put(s.charAt(i), count+1);

            if(max < count+1){
                max = count+1;
                maxChar = s.charAt(i);
            }
        }

        int sumOfAllNotMax = i-max;

//        System.out.println("arr : "+ indexes);
//        System.out.println("max : "+ max+" : maxChar : "+ maxChar + " : sumOfAllNotMax : "+ sumOfAllNotMax);

        if(max-sumOfAllNotMax > 1)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        while (max != 0){
            ans[index] = maxChar;
            indexes.put(maxChar, indexes.get(maxChar)-1);
            max--;
            index+=2;
        }

        System.out.println("String.valueOf(ans) : "+ Arrays.toString(ans));

        Set<Character> keys = indexes.keySet();
        for(char key : keys){
            int count = indexes.getOrDefault(key, 0);
            System.out.println("key : "+ key+" : count : "+ count+ " : index : "+ index);
            while (count!=0){
                if(index>=s.length()){
                    index = 1;
                }
                if(ans[index] == 0) {
                    ans[index] = key;
                    count--;
                }
                index += 2;
            }
            System.out.println(key + ": String.valueOf(ans) : "+ Arrays.toString(ans));
        }
        return String.valueOf(ans);
    }


    public static void main(String[] args) {
        String searchWord = "aabbcc";//getSaltString();

        //aabcbdba
        /*
            ababacabada
         */

        System.out.println("reorganize : "+searchWord);
        System.out.println("ans : " +reorganizeString2(searchWord));
    }
}
