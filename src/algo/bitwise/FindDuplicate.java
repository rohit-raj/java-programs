package algo.bitwise;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicate {

    public static int findDuplicateBrute(int[] nums) {
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
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        System.out.println("findDuplicateBrute : "+ findDuplicateBrute(nums));

    }
}
