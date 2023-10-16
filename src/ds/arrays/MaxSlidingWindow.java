package ds.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {

    public static int getMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static int[] maxSlidingWindowBrute(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length-k+1;i++){
            ans.add(getMax(nums, i, i+k));
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static int[] maxSlidingWindowOptimal(int[] nums, int k){
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int j=0;

        for (int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if(i>=k-1) ans[j++] = nums[deque.peekFirst()];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        List<Integer> ans1 = Arrays.stream(maxSlidingWindowBrute(nums, k)).boxed().collect(Collectors.toList());
        List<Integer> ans2 = Arrays.stream(maxSlidingWindowOptimal(nums, k)).boxed().collect(Collectors.toList());
        System.out.println("Max window Brute: "+ ans1);
        System.out.println("Max window Optimal: "+ ans2);

    }
}
