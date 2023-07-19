package ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 */
public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] inp = {2,7,11,15};
        int[] res =  twoSum(inp, 9);
        printArray(res);
    }

    static void printArray(int[] inp){
        for (int value : inp) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
