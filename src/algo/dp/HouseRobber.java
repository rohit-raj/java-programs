package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public static int maxBrute(int[] nums, int idx){
        if(idx==0) return nums[idx];
        if(idx< 0) return 0;

        int pick = nums[idx]+maxBrute(nums, idx-2);
        int notPick = 0+maxBrute(nums, idx-1);
        return Math.max(pick, notPick);
    }

    public static int robBrute(int[] nums) {

        return maxBrute(nums, nums.length-1);
    }

    public static int maxBetter(int[] nums, int idx, int[] dp){
        if(idx == 0)return nums[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx]+maxBetter(nums, idx-2, dp);
        int notPick = 0+maxBetter(nums, idx-1, dp);
        dp[idx] =  Math.max(pick, notPick);
        return dp[idx];
    }

    public static int robBetter(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxBetter(nums, nums.length-1, dp);
    }

    public static int robOptimal(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1) take+=dp[i-2];

            int notTake = 0+dp[i-1];
            dp[i]= Math.max(take, notTake);
        }

        return dp[nums.length-1];
    }

    public static int robMostOptimal(int[] nums){
        int prev = nums[0];
        int last = 0;

        for(int i=1;i<nums.length;i++){
            int take = nums[i] + last;

            int notTake = 0 + prev;
            last = prev;
            prev = Math.max(take, notTake);
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] houses = {2,1,4,9,1,4};

        System.out.println("max : "+robOptimal(houses));
    }
}
