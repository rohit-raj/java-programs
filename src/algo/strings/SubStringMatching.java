package algo.strings;

//import static algo.strings.KMPAlgorithm.createLps;

/**
 * KMP algo
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class SubStringMatching extends KMPAlgorithm {

    static int findSubStringBrute(String str, String subStr){
        int strLen = str.length();
        char[] strArr = str.toCharArray();
        int pos = -1;

        int subStrLen = subStr.length();
        char[] subStrArr = subStr.toCharArray();

        int i=0,j=0;
        while(i<strLen && j<subStrLen){
            if(strArr[i] == subStrArr[j]){
                i++;
                j++;
            } else{ // if(strArr[i] != subStrArr[j])
                i++;
                j=0;
            }
            if(j == subStrLen) {
                pos = i-j;
                break;
            }
        }
        return pos;
    }


    static int findSubStringOptimal(String str, String subStr){
        int strLen = str.length();
        int subStrLen = subStr.length();

        int pos = -1;
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
                pos = i-j;
                break;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        String str = "aaaaaaab";
        String subStr = "aaab";
        System.out.println("findSubStringBrute : "+ findSubStringBrute(str, subStr));
        System.out.println("findSubStringOptimal : "+ findSubStringOptimal(str, subStr));

    }
}
