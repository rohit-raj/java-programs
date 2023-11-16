package algo.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public static void backTrack(int[] cost, int index, int[] temp, int[] ans){

    }

    public static int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i=cost.length-1;i>=0;i--){
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
            System.out.println(i+" : cost : "+ Arrays.stream(cost).boxed().collect(Collectors.toList()));
        }
        return Math.min(cost[0], cost[1]);
    }


    public static void main(String[] args) {
        int[] s = {10,15,20};

        System.out.println("minCostClimbingStairs : "+ minCostClimbingStairs(s));
    }
}