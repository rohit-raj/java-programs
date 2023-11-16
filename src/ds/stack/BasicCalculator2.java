package ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {

    public static int calculate(String s) {
        s=s+'+'; // if we add this + at the last then no need to call the compute again at the end
//        if(s.isEmpty() || s == null) return 0; // no point inhaving this as we have added + at end
        int currNum = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        char operation = '+';
        for(char c : s.toCharArray()){
            if (Character.isWhitespace(c)) {
                continue;
            } else if(Character.isDigit(c)){
                currNum = currNum*10 + c-'0';
            } else {
                compute(stack, currNum, operation);
                operation = c;
                currNum = 0;
            }
        }
//        compute(stack, currNum, operation); commented as s=s+'+ no execution will happen inside for loop
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void compute(Stack<Integer> stack, int currNum, char operator){
        if(operator == '-'){
            stack.push(-currNum);
        } else if(operator == '+'){
            stack.push(currNum);
        } else if(operator == '*'){
            stack.push(stack.pop()*currNum);
        } else if(operator == '/'){
            stack.push(stack.pop()/currNum);
        }
    }



    public static void main(String[] args) {

        String n = "4 * 3 / 5";

        System.out.println("answer : "+ calculate(n));
    }


}
