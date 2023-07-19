package ds.arrays;

import java.util.*;

//https://leetcode.com/problems/4sum/
public class FourSum {

    static List<List<Integer>> fourSumBrute(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    for(int l=k+1;l<n;l++){
                        int sum = nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum == target){
                            List<Integer> ans1 = new ArrayList<>();
                            ans1.add(nums[i]);
                            ans1.add(nums[j]);
                            ans1.add(nums[k]);
                            ans1.add(nums[l]);

                            Collections.sort(ans1);
                            if(!ans.contains(ans1))
                                ans.add(ans1);
                        }
                    }
                }
            }
        }
        return ans;
    }

    static List<List<Integer>> fourSumBetter(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                HashSet<Integer> set = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int sumRequired = target - sum;

                    if(set.contains(sumRequired)) {
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[k]);
                        ans1.add(sumRequired);

                        Collections.sort(ans1);
                        if(!ans.contains(ans1))
                            ans.add(ans1);
                    } else {
                        set.add(nums[k]);
                    }
                }
            }
        }

        return ans;
    }

    static List<List<Integer>> fourSumOptimal(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n-1;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j<n;j++){
                if(j != (i+1) && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum < target){
                        k++;
                    } else if(sum > target) {
                        l--;
                    } else {
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[k]);
                        ans1.add(nums[l]);
                        if (!ans.contains(ans1))
                            ans.add(ans1);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println("Brute : "+ fourSumBrute(nums, target));
        System.out.println("Better : "+ fourSumBetter(nums, target));
        System.out.println("Optimal : "+ fourSumOptimal(nums, target));
    }
}
