package algo.strings;

/**
 * https://leetcode.com/problems/rotate-string/
 */
public class RotateString extends KMPAlgorithm {

    /**
     * Complexity : N^2
     * Space : 1
     */
    static boolean rotateStringBrute(String s, String goal) {
        String finalStr = s+s;

        return finalStr.contains(goal);
    }

    static boolean rotateStringOptimal(String s, String goal){
        String finalStr = s+s;
        return kmpAlgo(finalStr, goal);
    }


    public static void main(String[] args) {
        String str = "abcde";
        String goal = "cdeab";

        System.out.println("rotateStringBrute : "+rotateStringBrute(str, goal));
        System.out.println("rotateStringOptimal : "+rotateStringOptimal(str, goal));
    }
}
