package algo.bitwise;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicatesInArray {
    static List<Integer> findDuplicateBrute(int[] nums){
        Set<Integer> result = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    result.add(nums[i]);
                }
            }
        }
        return new ArrayList<Integer>(result);
    }

    static List<Integer> findDuplicateOptimal(int[] nums){
        int x = 0;
        Set<Integer> result = new HashSet<>();
        for (int n : nums) {
            if ((x >> n & 1) == 0)
                result.add(n);
            x |= 1 << n;
        }
        return new ArrayList<Integer>(result);
    }

    public static void main(String[] args) {
        int[] nums = {39,31,8,14,14,38,5,15,29,49,18,6,30,47,8,35,2,17,6,10,29,46,41,48,1,36,5,
                28,46,39,7,47,18,42,17,11,36,45,21,33,24,10,24,50,25,16,9,12,11,25};

        // opt : [33,36,5,6,39,7,8,9,42,10,11,14,46,47,16,17,18,50,24,25,29]
        // exp : [14,8,6,29,5,46,39,47,18,17,36,10,24,11,25]
        System.out.println("findDuplicateBrute : "+ findDuplicateBrute(nums));
        System.out.println("findDuplicateOptimal : "+ findDuplicateOptimal(nums));
    }
}
