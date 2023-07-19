package algo.bitwise;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 */
public class SumOfXorsOfAllSubsets {
    static int subsetXORSum(int[] nums) {
        int result = 0;
        int n = nums.length;
        int x = 1<<n;
        for(int i=0;i<x;i++){
            int xor = 0;
            for(int bit=0;bit<n;bit++){
                if((i &(1<<bit)) != 0){
                    xor ^= nums[bit];
                }
            }
            result += xor;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(subsetXORSum(nums));
    }
}
