package algo.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    List<int[]> stack;
    int top;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.add(new int[]{val, val});
        } else {
            int min = stack.get(stack.size()-1)[1];
            stack.add(new int[]{val, Math.min(min, val)});
        }
        top = val;
    }

    public void pop() {
        stack.remove(stack.size()-1);
        if(!stack.isEmpty()){
            top = stack.get(stack.size() - 1)[0];
        }
    }

    public int top() {
        return top;
    }

    public int getMin() {
        return stack.get(stack.size()-1)[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
