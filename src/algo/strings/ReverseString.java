package algo.strings;

/**
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        int st = 0;
        int e = s.length-1;
        while(st < e) {
            char temp = s[e];
            s[e] = s[st];
            s[st] = temp;
            st++;
            e--;
        }
    }
}
