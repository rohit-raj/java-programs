package ds.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/editorial/
//https://www.youtube.com/watch?v=oO5uLE7EUlM&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=14

public class LongestConsecutiveSequence {

    static boolean arrayContains(int[] nums, int item){
        for (int num : nums) {
            if (num == item) return true;
        }
        return false;
    }
    static int longestConsecutiveNaive(int[] nums) {
        int maxLength = 0;

        for (int num : nums) {
            int item = num;
            int length = 1;
            while (arrayContains(nums, item + 1)) {
                item = item + 1;
                length += 1;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    static int longestConsecutiveBetter(int[] nums){
        Arrays.sort(nums);

        int maxLength = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int currentLength = 0;

        for (int item : nums) {
            if (item - 1 == lastSmaller) {
                currentLength++;
                lastSmaller = item;
            } else if (lastSmaller != item) {
                currentLength = 1;
                lastSmaller = item;
            } //else case is lastSmaller == item, which means it is a duplicate case so do nothing

            maxLength = Math.max(maxLength, currentLength);

        }
        return maxLength;
    }

    static int longestConsecutiveOptimal(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLength = 0;

        int[] numsFromSet = set.stream().mapToInt(Integer::intValue).toArray();
        for(int num : numsFromSet){
            if(!set.contains(num-1)) {
                int currentLength = 1;
                int item = num;
                while (set.contains(item + 1)) {
                    currentLength++;
                    item++;
                }
                maxLength = Math.max(currentLength, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,102,101,1,3,104,2,103, 100, 1, 1, 2, 3, 3, 4, 2,5,6};
        System.out.println("longestConsecutiveNaive : "+ longestConsecutiveNaive(nums));
        System.out.println("longestConsecutiveBetter : "+ longestConsecutiveBetter(nums));
        System.out.println("longestConsecutiveOptimal : "+ longestConsecutiveOptimal(nums));
    }
}
