package ds.arrays;

import ds.trie.MaximumXorOfTwoNumbersTrie;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXorOfTwoNumbers {

    public int findMaximumXORBetter(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

//    public int findMaximumXOROptimal(int[] nums){
//        MaximumXorOfTwoNumbersTrie trie = new MaximumXorOfTwoNumbersTrie(nums);
//        return findMaximumXORBetter(nums);
//    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        MaximumXorOfTwoNumbers mx = new MaximumXorOfTwoNumbers();
        long startTime = System.nanoTime();
        int max = mx.findMaximumXORBetter(nums);
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println("max :: "+ max + " : totalTime : "+totalTime);

    }
}
