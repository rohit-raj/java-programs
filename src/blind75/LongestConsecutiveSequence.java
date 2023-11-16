package blind75;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int maxLength = 0;
        int[] numsFromSet = set.stream().mapToInt(Integer::intValue).toArray();
        for(int num:numsFromSet){
            if(!set.contains(num-1)){
                int currLen = 1;
                int item = num;
                while(set.contains(item+1)){
                    currLen++;
                    item++;
                }
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(" ans : "+ lcs.longestConsecutive(nums));
    }
}
