package ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if(token.equals("+")){
                stack.add(stack.pop() + stack.pop());
            } else if(token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b-a);
            } else if(token.equals("*")){
                stack.add(stack.pop() * stack.pop());
            } else if(token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b/a);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        int ans = rpn.evalRPN(tokens);
        System.out.println("ans :: "+ ans);
    }
}
