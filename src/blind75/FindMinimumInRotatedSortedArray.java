package blind75;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public int findMinBrute(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public int findMinOptimal(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]) {
                break;
            }

            if(nums[low] <= nums[mid]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    static int findMinAndIndexOptimal(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                index = low;
                low = mid+1;
            } else {
                ans = Math.min(ans, nums[mid]);
                index = mid;
                high = high-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fn = new FindMinimumInRotatedSortedArray();
        int[] nums = {4,5,6,1,2};

//        System.out.println("findMinBrute : "+ fn.findMinBrute(nums));

        System.out.println(fn.findMinOptimal(nums));
    }
}
