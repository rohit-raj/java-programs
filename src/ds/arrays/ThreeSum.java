package ds.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    static List<List<Integer>> threeSumBrute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-2; i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] + nums[j]+nums[k] == 0){
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[k]);
                        Collections.sort(ans1);
                        if(!ans.contains(ans1))
                            ans.add(ans1);
                    }
                }
            }
        }
        return ans;
    }

    static List<List<Integer>> threeSumBetter(int[] nums){
        Set<List<Integer>> refined  = new HashSet<>();

        int n = nums.length;
        for(int i=0;i<n-1;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int sumRequired = -(nums[i] + nums[j]);
                if(set.contains(sumRequired)){
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[j]);
                    ans1.add(sumRequired);
                    Collections.sort(ans1);
                    refined.add(ans1);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(refined);
        return ans;

    }

    static List<List<Integer>> threeSumOptimal(int[] nums){
        Set<List<Integer>> refined  = new HashSet<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[j]);
                    ans1.add(nums[k]);
                    ans.add(ans1);
                    refined.add(ans1);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
//        ans = new ArrayList<>(refined);
        List<List<Integer>> res = new ArrayList<>(refined);

        System.out.println("ans : "+ ans);
        System.out.println("res : "+ res);
        return ans;
    }

    static List<List<Integer>> actualRunningSolution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        Set<List<Integer>> refined  = new HashSet<List<Integer>>();

        for (int i = 0 ; i < nums.length-2 ; i++) {
            int sum = nums[i];
            map = new HashMap<Integer, Integer>();
            int target = 0 - sum;
            for (int j = i+1 ; j < nums.length ; j++) {
                if (map.containsKey(target - nums[j])) {
                    al = new ArrayList<Integer>();
                    al.add(nums[i]);
                    al.add(nums[j]);
                    al.add(target - nums[j]);
                    Collections.sort(al);
                    refined.add(al);
                }
                else {
                    map.put(nums[j], 0);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>(refined);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,3,-4, -1, 0, 1};
//        System.out.println("Brute : "+ threeSumBrute(nums));
//        System.out.println("Better : "+ threeSumBetter(nums));
        System.out.println("Optimal : "+ threeSumOptimal(nums));
    }
}
