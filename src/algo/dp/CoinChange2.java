package algo.dp;

/**
 * https://leetcode.com/problems/coin-change-ii/
 */
public class CoinChange2 {

    public static int calculateCoinChangeBrute(int[] coins, int amount, int idx){
        if(amount == 0) return 1;
        if(idx >= coins.length) return 0;

        int dontPick = calculateCoinChangeBrute(coins, amount, idx+1);
        int pick = 0;
        if(coins[idx] <= amount){
            pick = calculateCoinChangeBrute(coins, amount-coins[idx], idx);
        }
        return pick + dontPick;
    }

    public static long calculateCoinChangeBetter(int[] coins, int target){
        long[] dp = new long[target+1];

        for(int i=0;i<=target;i++){
            if(i%coins[0] == 0){
                dp[i] = 1;
            }
        }

        for(int idx=1;idx<coins.length;idx++){
            long[] cur = new long[target+1];
            for(int T=0;T<=target;T++){
                long notTaken = dp[T];
                long taken =0;

                if(coins[idx] <= T){
                    taken = cur[T-coins[idx]];
                }
                cur[T] = taken+notTaken;
            }
            dp = cur;
        }
        return dp[target];
    }

    public static int calculateCoinChangeOptimal(int[] coins, int amount){
        if(coins.length == 0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println("ansBrute : "+calculateCoinChangeBrute(coins, amount, 0));
        System.out.println("ans : "+calculateCoinChangeBetter(coins, amount));
        System.out.println("ans : "+calculateCoinChangeOptimal(coins, amount));
    }
}
