package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    static void helper(int index, int target, int[] candidates, List<Integer> tempAns, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0)
                ans.add(new ArrayList<>(tempAns));
            return;
        }

        if(candidates[index] <= target) {
            int item = candidates[index];
            tempAns.add(item);
            helper(index, target-item, candidates, tempAns, ans);
            tempAns.remove(tempAns.size()-1);
        }
        helper(index+1, target, candidates, tempAns,ans);
    }

    static List<List<Integer>> sumRecursion(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        System.out.println("sumRecursion : "+ sumRecursion(candidates, target));
    }
}
