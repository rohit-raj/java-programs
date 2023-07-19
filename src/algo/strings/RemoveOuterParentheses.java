package algo.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/description/
 */
public class RemoveOuterParentheses {

    static String removeOuterParentheses(String s) {
        int len = s.length();
        if(len <= 2) return "";

        char[] c = s.toCharArray();

        StringBuilder st = new StringBuilder();

        int open = 1;
        for(int i=1;i<len;i++){
            if(c[i] == '('){
                open++;
                if(open > 1) st.append("(");
            } else {
                if(open > 1) st.append(")");
                open--;
            }
        }
        return st.toString();
    }

    static String removeOuterParenthesesOptimal(String s){
        StringBuilder str = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) str.append(c);
            if (c == ')' && opened-- > 1) str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";

        System.out.println("removeOuterParenthesesOptimal : "+ removeOuterParenthesesOptimal(s));
        System.out.println("removeOuterParentheses : "+ removeOuterParentheses(s));
    }
}
