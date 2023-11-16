package algo.strings;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
 */
public class Anagram3 {


    public static int countCharacters(String[] words, String chars) {
        int len = 0;
        for(String word : words){
            if(checkPresence(word, chars)){
                len += word.length();
            }
        }
        return len;
    }

    public static boolean checkPresence(String word, String chars){
        int[] count = new int[26];

        for(int i=0;i<chars.length();i++){
            count[chars.charAt(i) - 'a']++;
        }

        for(int i=0;i<word.length();i++){
            count[word.charAt(i) - 'a']--;
            if(count[word.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String query = "atach";

        System.out.println("solve :: "+ countCharacters(words, query));
    }


}