package algo.strings;


/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeAlternatively {

    public static String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        char[] chars = new char[word1.length() + word2.length()];
        int k = 0;
        while(i < word1.length() && j < word2.length()){
            chars[k++] = word1.charAt(i++);
            chars[k++] = word2.charAt(j++);
        }

        while(i<word1.length()){
            chars[k++] = word1.charAt(i++);
        }

        while(j<word2.length()){
            chars[k++] = word2.charAt(j++);
        }

        return new String(chars);
    }

    public static String mergeAlternately2(String word1, String word2) {
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }

        while(j<word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }


    public static void main(String[] argv) {
        String word1 = "abc", word2 = "pqrst";

        long startTime = System.nanoTime();
        String ans = mergeAlternately(word1, word2);
        long endTime = System.nanoTime();
        System.out.println(" ans : " + ans + " time : " + (endTime-startTime));

        long startTime2 = System.nanoTime();
        String ans2 = mergeAlternately(word1, word2);
        long endTime2 = System.nanoTime();
        System.out.println(" ans : " + ans2 + " time : " + (endTime2-startTime));
    }
}




