package blind75;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

    static boolean isValidBrute(String str){
        Stack<Character> stack = new Stack<>();

        int n = str.length();
        for(char c : str.toCharArray()){
            if((c == '(') || (c == '{') || (c == '[')){
                stack.push(c);
            } else {
                if(stack.empty()){
                    return false;
                }
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                } else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                } else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isValidOptimal(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '{'){
                stack.push('}');
            } else if(c == '['){
                stack.push((']'));
            } else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([)]";

        System.out.println("isValidBrute : "+ isValidBrute(str));
        System.out.println("isValidOptimal : "+ isValidOptimal(str));
    }
}
