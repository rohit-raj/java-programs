package ds.arrays;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {

    static boolean canSplit(int[] nums, int mid, int k){
        int subArrays = 1;
        int currSum = 0;

        for(int num : nums){
            currSum += num;
            if(currSum > mid){
                subArrays++;
                 currSum = num;
            }
        }
        return subArrays<= k;
    }

    /**
     * Binary Search method
     */
    public static int splitArrayOptimal(int[] nums, int k){
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int result = -1;

        while (low <= high){
            int mid = low+(high-low)/2;
            if(canSplit(nums, mid, k)){
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;
    }

    static boolean check(int[] nums, int m, int mid) {
        int sum = 0;
        int numOfSubarrays = 1;

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > mid) {
                numOfSubarrays ++;
                sum = nums[i];
            }
        }

        return numOfSubarrays <= m;
    }

    static int splitArray(int[] nums, int m) {
        int low = 0, high = 0;

        for (int n: nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] nums = {7,2,5,10,8};
        int[] nums = {1,4,4};
        int k = 3;

        System.out.println("splitArrayOptimal : "+splitArrayOptimal(nums, k));
        System.out.println("splitArray : "+splitArray(nums, k));
    }
}
