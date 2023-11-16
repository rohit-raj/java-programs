package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class SubSets {

    //using bit
    public static List<List<Integer>> subsetsUsingBit(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int x = 1<<n;
        for(int i=0;i<x;i++){
            List<Integer> sub = new ArrayList<>();
            for(int bit=0;bit<n;bit++){
                if((i &(1<<bit)) !=0) {
                    sub.add(nums[bit]);
                }
            }
            ans.add(sub);
        }
        return ans;
    }


    //using dp and recursion
    //VVI
    public static void subSetsUsingDp(int[] nums, int idx, List<Integer> tempAns, List<List<Integer>> ans){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        tempAns.add(nums[idx]);
        subSetsUsingDp(nums, idx+1, tempAns, ans);
        tempAns.remove(tempAns.size()-1);
        subSetsUsingDp(nums, idx+1, tempAns, ans);
    }

    public static List<List<Integer>> subSetsUsingDp(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempAns = new ArrayList<>();
        subSetsUsingDp(nums, 0, tempAns, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums= {1,2,3};

        System.out.println("subSets : "+ subsetsUsingBit(nums));
        System.out.println("subSets : "+ subSetsUsingDp(nums));
    }

}
