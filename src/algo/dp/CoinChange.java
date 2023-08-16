package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change
 */
public class CoinChange {

    public int sol(int[] coins, int amount){
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
            for (int j=0;j<coins.length;j++) {
                if(i-coins[j]>=0){
                    dp[i]= Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
            System.out.println("dp["+i+"] = "+ dp[i]);
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];

    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("coinChange : "+ noOfCoinsChange(coins, amount));
    }
}
