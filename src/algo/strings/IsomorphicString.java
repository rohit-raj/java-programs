package algo.strings;

import java.util.HashMap;

/**
 * Created by rohit on 03/09/20.
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicString {

    static boolean checkIsomorphic(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if(len1 < 1 || len2 < 1 || (len1 != len2)) {
            return false;
        }

        char [] chars = new char[512];
        HashMap<Character, Character> charSet = new HashMap<Character, Character>();

        for(int i = 0 ;i < len1; i++) {
            int  x = (int)str1.charAt(i);
            char y = str2.charAt(i);
            System.out.println("x :: "+ x);
//            System.out.println("y :: "+ y);
            chars[x] = y;
        }

        /*for(int i = 0 ; i < len2; i++) {
            char y = str2.charAt(i);



        }*/

        /*for(int j = 0 ;j < chars.length; j++) {
            System.out.println("ch :: "+ chars[j]);
        }*/
        return true;
    }

    public static void main(String[] args) {
        String str1 = "add";//"add";
        String str2 = "egg";

        System.out.println("isomorphic : "+ checkIsomorphic(str1, str2));
    }

}
