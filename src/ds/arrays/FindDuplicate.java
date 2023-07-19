package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicate {

    public static int findDuplicateBrute(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static int findDuplicateBetter(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<n;i++) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
        }

        for(int key : map.keySet()){
            if(map.get(key) > 1) return key;
        }
        return 0;
    }

    public static int findDuplicateOptimal(int[] nums){
        int slow=0, fast=0;
        int check = 0;
        while( true ) {
            slow = nums[slow];
            System.out.println("slow : "+slow+" : nums[fast] : "+nums[fast]+" : fast : "+nums[nums[fast]]);
            fast = nums[ nums[fast] ];
            if( slow == fast ) {
                break;
            }
        }
        while( true ) {
            slow = nums[slow];
            check = nums[check];
            System.out.println("slow : "+slow+" : check : "+check);
            if( slow == check ) {
                break;
            }
        }
        return check;
    }

    public static int findDuplicateOptimal2(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[Math.abs(nums[i])-1]>0)
            {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
            else{
                return Math.abs(nums[i]);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,3,2,1};
//        System.out.println("findDuplicateBrute : "+findDuplicateBrute(nums));
//        System.out.println("findDuplicateBetter : "+findDuplicateBetter(nums));
        System.out.println("findDuplicateOptimal2 : "+findDuplicateOptimal2(nums));
    }
}
