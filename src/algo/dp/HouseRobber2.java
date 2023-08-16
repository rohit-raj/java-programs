package algo.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobber2 {

    public static int robBetter(int[] nums){
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

    public static int rob(int[] nums){
        int n = nums.length;
        if(n==1) return robBetter(nums);

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        if (n - 1 >= 0) System.arraycopy(nums, 0, temp1, 0, n - 1);

        if (n - 1 >= 0) System.arraycopy(nums, 1, temp2, 0, n - 1);

        int ans1 = robBetter(temp1);
        int ans2 = robBetter(temp2);

        return Math.max(ans1, ans2);
    }


    public static int robOptimal(int[] nums, int start, int end){
        int prev = nums[start];
        int last = 0;
        for(int i=start+1;i<end;i++){
            int pick = nums[i]+last;
            int notPick = 0+prev;
            last = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }

    public static int robOptimal(int[] nums){
        int n = nums.length;
        int ans2 = Integer.MIN_VALUE;
        int ans1 = robOptimal(nums, 0, n-1);
        if(n > 1)
            ans2 = robOptimal(nums, 1, n);
        return Math.max(ans1, ans2);
    }


    public static int maxBetterMemo(int[] nums, int idx, int[] dp){
        if(idx == 0)return nums[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx]+maxBetterMemo(nums, idx-2, dp);
        int notPick = 0+maxBetterMemo(nums, idx-1, dp);
        dp[idx] =  Math.max(pick, notPick);
        return dp[idx];
    }

    public static int robBetterMemo(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        if(n==1) return maxBetterMemo(nums, nums.length-1, dp);

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        if (n - 1 >= 0) System.arraycopy(nums, 0, temp1, 0, n - 1);

        if (n - 1 >= 0) System.arraycopy(nums, 1, temp2, 0, n - 1);

        int ans1 = maxBetterMemo(temp1, temp1.length-1, dp);
        int ans2 = maxBetterMemo(temp2, temp2.length-1, dp);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] houses = {2,3,2};

        System.out.println("max : "+rob(houses));
        System.out.println("max : "+robOptimal(houses));
        System.out.println("max : "+robBetterMemo(houses));
    }
}
