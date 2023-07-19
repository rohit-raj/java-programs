package ds.arrays;

//https://leetcode.com/problems/permutations/
//https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Permutations {

    //Naive using recursion
    static void recurPermuteNaive(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermuteNaive(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    static List<List<Integer>> permuteNaive(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermuteNaive(nums, ds, ans, freq);
        return ans;
    }

    public static void main(String[] args) {
        int[] inp = {1,2,3};
        printArray(permuteNaive(inp));
        printArray(permute(inp));
    }

    static List<List<Integer>> permute(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }

    static void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permuteHelper(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    static void printArray (List<List<Integer>> mainList) {
        String s1 = Arrays.toString(mainList.toArray());
        System.out.println(s1);
    }
}
