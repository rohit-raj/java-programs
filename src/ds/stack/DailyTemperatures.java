package ds.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {



    public static int[] dailyTemperaturesBrute(int[] temperatures) {
        int n = temperatures.length;
        if(n == 1){
            return new int[0];
        }
        int[] ans = new int[n];
        for(int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (temperatures[j]>temperatures[i]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] dailyTemperaturesOptimal(int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        java.util.Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevDay = stack.pop();
                ans[prevDay] = i-prevDay;
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] inp = {73,74,75,71,69,72,76,73};
        int[] inp = {30,40,50,60};
        List<Integer> ans = Arrays.stream(dailyTemperaturesBrute(inp)).boxed().collect(Collectors.toList());
        List<Integer> ans2 = Arrays.stream(dailyTemperaturesOptimal(inp)).boxed().collect(Collectors.toList());
        System.out.println("ans :: "+ ans);
        System.out.println("ans2 :: "+ ans2);
    }
}
