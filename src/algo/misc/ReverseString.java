package algo.misc;

/**
 * Created by rohit on 15/09/20.
 */
public class ReverseString {
    static void reverseString(char[] s) {
        int st = 0;
        int e = s.length-1;
        System.out.println("e: "+e);
        while(st < e) {
            char temp = s[e];
            s[e] = s[st];
            s[st] = temp;
            st++;
            e--;
        }

        for(char x : s)
            System.out.println(x);
    }

    public static void main(String[] args) {
        char s [] = {'h','e','l','l','o'};
        reverseString(s);
//        System.out.println(reverseString(s));
    }
}
