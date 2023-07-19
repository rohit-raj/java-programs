package algo.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KMPAlgorithm {

    static int[] createLps(String subStr){
        int prevLps = 0, i=1;
        int n = subStr.length();
        int[] lps = new int[n];
        lps[0] = 0;

        while (i<n){
            if(subStr.charAt(i) == subStr.charAt(prevLps)){
                lps[i] = prevLps+1;
                prevLps+=1;
                i+=1;
            } else if(prevLps == 0) {
                lps[i] = 0;
                i+=1;
            } else {
                prevLps = lps[prevLps-1];
            }
        }
        System.out.print("lps = ");
        List<Integer> list = Arrays.stream(lps).boxed().collect(Collectors.toList());
        System.out.println(list);
        return lps;
    }

    static boolean kmpAlgo(String str, String subStr){
        int strLen = str.length();
        int subStrLen = subStr.length();

        // create LPS
        int[] lps = createLps(subStr);

        int i=0,j=0;

        while (i<strLen){
            if(str.charAt(i) == subStr.charAt(j)){
                i++;
                j++;
            } else if(j != 0) {
                j = lps[j - 1];
            } else { //if(j == 0)
                i+=1;
            }
            if(j == subStrLen) {
                break;
            }
        }
        return j == subStrLen;

    }

    /**
     * Find pattern occurrences of a pattern in a string
     */
    static boolean patternOccurrencesOptimal(String str, String subStr){
        int strLen = str.length();
        int subStrLen = subStr.length();
        int count = 0;

        // create LPS
        int[] lps = createLps(subStr);

        int i=0,j=0;

        while (i<strLen){
            if(str.charAt(i) == subStr.charAt(j)){
                i++;
                j++;
            } else if(j != 0) {
                j = lps[j - 1];
            } else {
                i+=1;
            }
            if(j == subStrLen) {
                count++;
                j=lps[j-1];
            }
        }
        System.out.println("count :: "+count);
        return count>0;

    }

    public static void main(String[] args) {
        String str = "aaaaaaabaaab";
        String subStr = "aaab";

        System.out.println(kmpAlgo(str, subStr));
    }
}
