package algo.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 */
public class SubSet2 {

    static List<List<Integer>> subsetsWithoutDupBetter(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        int n = nums.length;
        int x = (1<<n)-1;

        for(int i=0;i<=x;i++){
            List<Integer> list = new ArrayList<>();
            for(int bit=0;bit<n;bit++){
                if((i&(1<<bit)) !=0){
                    list.add(nums[bit]);
                }
            }
            result.add(list);
        }

        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;
    }

    static void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++) {
            if (i>index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(i + 1, nums, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }

    static List<List<Integer>> subsetsWithoutDupRecursive(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println("subsetsWithoutDupBetter : "+ subsetsWithoutDupBetter(nums));
        System.out.println("subsetsWithoutDupRecurs : "+ subsetsWithoutDupRecursive(nums));
    }
}
