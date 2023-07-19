package algo.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    static void recursiveHelperBrute(int index, int target, int[] candidates, List<Integer> temp, HashSet<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        int item = candidates[index];
        if(item <= target){
            temp.add(item);
            recursiveHelperBrute(index+1, target-item, candidates, temp, ans);
            temp.remove(temp.size()-1);
        }
        recursiveHelperBrute(index+1, target, candidates, temp, ans);
    }

    static List<List<Integer>> combinationSum2Brute(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans = new HashSet<>();
        recursiveHelperBrute(0, target, candidates, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 5;

        System.out.println("combinationSum2Brute : "+ combinationSum2Brute(candidates, target));
        System.out.println("combinationSum2Optimal : "+ combinationSum2Optimal(candidates, target));
    }

    static List<List<Integer>> combinationSum2Optimal(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    static void recursiveHelperOptimal(int index, int target, int[] candidates, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i=index;i<candidates.length;i++){
            int item = candidates[i];
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(item > target)break;

            temp.add(item);
            recursiveHelperOptimal(index+1, target-item, candidates, temp, ans);
            temp.remove(temp.size()-1);
        }
    }

    static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
