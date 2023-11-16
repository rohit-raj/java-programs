package algo.strings;

/**
 * Anagram Based question
 * Given an array of strings and a jumbled query string,
 * check if the query string contains a word which is present in the array or not.
 * return the word if found else return "-".
 *
 * Sample :
 * words = ["baby", "cat", "hello", "how"]
 * query = "tcay"
 * result = "cat"
 * explanation : query contains a word(cat) hence cat is an answer
 *
 * words = ["baby", "cat", "hello", "how"]
 * query = "cay"
 * result = "-"
 * explanation : query does not contain any word which matches completely to any word of the array.
 *
 * words = ["baby", "cat", "hello", "how"]
 * query = "twgtrsiuomhgekjjqozyc"
 * result = "how"
 * explanation : cay is not present in any word.
 */
public class Anagrams2 {

    public static boolean checkPresence(String word, String query){
        int[] chars = new int[26];
        int len = word.length();


        for(int j=0;j<query.length();j++){
            chars[query.charAt(j)-'a']++;
        }
        for(int i=0;i<len;i++){
            chars[word.charAt(i)-'a']--;
            if(chars[word.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static String solve(String[] words, String query){
        for(String word : words){
            if(checkPresence(word, query)){
                return word;
            }
        }
        return "-";
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String query1 = "atach";

        System.out.println("solve :: "+ solve(words, query1));
    }


}
