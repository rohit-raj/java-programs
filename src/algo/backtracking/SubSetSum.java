package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/subset-sums2234
 *
 * Given a list arr of N integers, print sums of all subsets in it.
 *
 * Input:
 * N = 2
 * arr[] = {2, 3}
 * Output:
 * 0 2 3 5
 */
public class SubSetSum {

    static List<Integer>subsetSumsBetter(int[] nums){
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int x = (1<<n)-1; // total elements to be generated = 2^n-1
        for(int i=0;i<=x;i++){
            int sum = 0;
            for(int bit=0;bit<n;bit++){
                if((i & (1<<bit)) != 0){
                    sum+=nums[bit];
                }
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        return ans;
    }

    static void helper(int index, int sum, int[] nums, List<Integer> ans){
        if(index == nums.length){
            ans.add(sum);
            return;
        }
        sum+=nums[index];
        helper(index+1, sum, nums, ans);
        sum-=nums[index];
        helper(index+1, sum, nums, ans);
    }

    static List<Integer> subsetSumsRecursive(int[] nums){
        List<Integer> ans = new ArrayList<>();

        helper(0,0, nums, ans);
        Collections.sort(ans);
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {5,1,2};
        System.out.println("subsetSumsBetter : "+ subsetSumsBetter(nums));
        System.out.println("subsetSumsRecursive : "+ subsetSumsRecursive(nums));
    }
}
