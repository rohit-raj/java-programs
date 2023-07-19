package algo.arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * Not sorted
 */

public class RemoveElement {

    static int removeElements(int[] nums, int val) {
        int slowPtr = 0;
        for(int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
            if(nums[fastPtr] != val) {
                nums[slowPtr] = nums[fastPtr];
                slowPtr++;
            }
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        int inp [] = {0,1,2,2,3,0,4,2};
        System.out.println("removeElements");
        for(int x : inp) {
            System.out.print(x+" ");
        }
        int out = removeElements(inp, 2);
        System.out.println();
        for(int i = 0; i < out; i++) {
            System.out.print(inp[i] +" ");
        }

    }
}
