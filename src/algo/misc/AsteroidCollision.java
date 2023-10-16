package algo.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/asteroid-collision/
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek()>0 && asteroid<0)){
                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                stack.push(asteroid);
            }
        }

        System.out.println("sta ck : "+ stack);

        int[] ans = new int[stack.size()];

        for(int i=ans.length-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {};

        AsteroidCollision ac = new AsteroidCollision();

        List<Integer> res = Arrays.stream(ac.asteroidCollision(asteroids)).boxed().collect(Collectors.toList());
        System.out.println("res : "+ res);
    }
}
