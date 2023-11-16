package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static boolean canJumpBrute(int[] nums, int idx) {
        if(idx == nums.length-1) return true;
        if(nums[idx]==0) return false;
        int totalJumps = idx+nums[idx];

        for (int jump=idx+1;jump<=totalJumps;jump++){
            if(jump < nums.length && canJumpBrute(nums, jump))
                return true;

        }
        return false;
    }

    public static boolean canJumpBetter(int[] nums, int idx, int[] dp){
        if(idx == nums.length-1) return true;
        if(nums[idx]==0) return false;
        if(dp[idx] !=-1) return dp[idx] !=0;

        int totalJumps = idx+nums[idx];

        for (int jump=idx+1;jump<=totalJumps;jump++){
            if(jump < nums.length && canJumpBetter(nums, jump, dp)) {
                dp[idx] = 1;
                return true;
            } else {
                dp[idx] = 0;
            }

        }
        return false;
    }

    public static boolean canJumpBetter(int[] nums){
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return canJumpBetter(nums, 0, dp);
    }


    /**
     * This is one of the best greedy approach :
     * if we are at the last position, check whether the value will help me get past or equal to the goal
     * if yes then we shif the goal towards 0. i.e making it
     */
    public static boolean canJumpOptimal(int[] nums){
        int n = nums.length;
        if(n==1 && nums[0]==0) return true;

        int goal = n-1;
        for(int i=n-1;i>=0;i--){
            if (i+nums[i]>=goal)
                goal=i;
        }
        return goal == 0;
    }


    /**
     * https://www.youtube.com/watch?v=muDPTDrpS28
     */
    public static boolean canJumpOptimal2(int[] nums){
       int maxDistance = 0;
       for(int i=0;i<nums.length;i++){
           if(i>maxDistance) return false;
           maxDistance = Math.max(maxDistance, nums[i]+i);
           if(maxDistance > nums.length){
               return true;
           }
       }
       return true;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2,3,1,1,4};

        System.out.println("jump : "+ canJumpBrute(nums, 0));
        System.out.println("jump : "+ canJumpBetter(nums));
        System.out.println("jump : "+ canJumpOptimal(nums));
    }
}
