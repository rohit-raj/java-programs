package algo.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;
        for(int i=2;i<=n;i++){
            int ans = prev+prev2;
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("total stairs : "+ climbStairs(n));
    }
}
