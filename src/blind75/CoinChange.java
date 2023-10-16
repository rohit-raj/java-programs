package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change
 */
public class CoinChange {

    public static int sol(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(coin <= amount){
                    dp[i] = Math.min(dp[i], dp[i-coin]);
                }
            }
        }
        return dp[amount];
    }

    public static int coinsBrute(int[] coins, int amount){
        if(amount == 0) return 0;

        int total = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int max = coinsBrute(coins, amount - coin);
            total = Math.min(total, max + 1);
        }
        return total;
    }

    public static int noOfCoinsChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
//            System.out.println("dp["+i+"] = "+ dp[i]);
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];

    }


    public static void main(String[] args) {
        int[] coins = {3,7};
        int amount = 7;

        System.out.println("coinChange : "+ noOfCoinsChange(coins, amount));
    }
}
