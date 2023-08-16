package algo.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public static int jumpBetter(int[] nums, int idx, int[] dp){
        if(idx== nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int ans =(int) (1e7);
        int jumps = nums[idx];
        int k = idx+1;
        while(jumps-->0 && k<nums.length){
            int r = 1+ jumpBetter(nums,k, dp);
            k++;
            ans = Math.min(ans,r);
        }
        dp[idx]=ans;
        return ans;
    }

    public static int jumpBetter(int[] nums){
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return jumpBetter(nums, 0, dp);
    }

    public static int jumpOptimal(int[] nums){
        int n = nums.length;
        int res = 0;
        int l = 0, r=0;

        while (r < n-1){
            int farthest = 0;
            for(int i =l;i<=r;i++){
                farthest = Math.max(farthest, nums[i]+i);
            }
            l=r+1;
            r=farthest;
            res+=1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2,3,0,1,4};

        System.out.println("jump : "+ jumpBetter(nums));
        System.out.println("jump : "+ jumpOptimal(nums));
    }
}
