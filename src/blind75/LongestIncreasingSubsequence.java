package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public static int getLength(int[]nums, int idx, int prevIdx){
        if(idx >= nums.length){
            return 0;
        }
        int len = 0+getLength(nums, idx+1, prevIdx); // not taking the element hence prev idx remains as it
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            int len2 = 1 + getLength(nums, idx+1, idx);
            len = Math.max(len, len2);
        }
        return len;
    }

    //Recursive :: TLE
    public static int length(int[] nums){
        return getLength(nums, 0, -1);
    }


    public static int getLengthMemo(int[]nums, int idx, int prevIdx, int[][]dp){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];

        int len = 0+getLengthMemo(nums, idx+1, prevIdx, dp); // not taking the element hence prev idx remains as it

        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            int len2 = 1 + getLengthMemo(nums, idx+1, idx, dp);
            len = Math.max(len, len2);
        }
        dp[idx][prevIdx+1] = len;
        return dp[idx][prevIdx+1];
    }


    public static int lengthMemo(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return getLengthMemo(nums, 0, -1, dp);
    }


    public static int lengthTabu(int[] nums){
        int n = nums.length;
        int[][]dp = new int[n+1][n+1];
        for(int idx = n-1;idx>=0;idx--){
            for(int prev = idx-1;prev>=-1;prev--){
                int len = 0+dp[idx+1][prev+1];
                if(prev==-1|| nums[idx]>nums[prev]){
                    int len2 = 1+dp[idx+1][idx+1];
                    len = Math.max(len, len2);
                }
                dp[idx][prev+1] = len;
            }
        }
        return dp[0][0];
    }

    public static int lengthTabu2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for(int i=0;i<nums.length;i++){
            for(int prev =0;prev<i;prev++){
                if(nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static List<Integer> printElements(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int lastIndex = 0;

        int max = 1;

        for(int i=0;i<nums.length;i++){
            for(int prev =0;prev<i;prev++){
                if(nums[prev] < nums[i]) {
                    if(dp[i] < 1+dp[prev]) {
                        dp[i] = 1 + dp[prev];
                        hash[i] = prev;
                    }

                }
            }
            if(dp[i]>max){
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[lastIndex]);
        while (hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(nums[lastIndex]);
        }
        Collections.reverse(lis);
        return lis;
    }

    //solution using binary search

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for(int i = 1;i<n;i++){
            int prevItem = ls.get(ls.size()-1);
            System.out.println("nums[i] : " + nums[i] + " :: prev : "+ prevItem); // && nums[i]-prevItem <=3
            if(nums[i] > prevItem) {
                ls.add(nums[i]);
            }else {
                int ind = Collections.binarySearch(ls, nums[i]);
                if(ind < 0) {
                    ind = -1-ind;
                    ls.set(ind, nums[i]);
                }

            }
        }

        return ls.size();
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,4,3,4,5,8,15};

//        System.out.println("length = "+ length(nums));
//        System.out.println("lengthMemo = "+ lengthMemo(nums));
//        System.out.println("lengthTabu = "+ lengthTabu(nums));
//        System.out.println("lengthTabu2 = "+ lengthTabu2(nums));
        System.out.println("lengthOfLIS = "+ lengthOfLIS(nums));


//        System.out.println("elements : " + printElements(nums));
    }
}
