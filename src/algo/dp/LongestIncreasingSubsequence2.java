package algo.dp;

import ds.segmentTree.SegmentTree;

public class LongestIncreasingSubsequence2 {

    public static int lengthOfLIS(int[] nums, int k) {
        SegmentTree root = new SegmentTree(1, 100000);
        int res = 0;
        for (int num : nums) {
            int preMax = root.rangeMaxQuery(root, num - k, num - 1);
            root.update(root, num, preMax + 1);
            res = Math.max(res, preMax + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,1,4,3,4,5,8,15};
        int k = 3;

        System.out.println("length : "+ lengthOfLIS(nums, k));
    }
}
