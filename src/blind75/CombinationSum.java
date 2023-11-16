package blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void generate(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target ==0)
                ans.add(new ArrayList<>(temp));
            return;
        }

        if(candidates[index] <= target){
            int item = candidates[index];
            temp.add(item);
            generate(candidates, target-item, index, temp, ans);
            temp.remove(temp.size()-1);
        }
        generate(candidates, target, index+1, temp, ans);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum cs = new CombinationSum();

        System.out.println("ans : "+ cs.combinationSum(candidates, target));
    }
}
