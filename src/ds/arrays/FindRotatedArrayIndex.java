package ds.arrays;

public class FindRotatedArrayIndex {

    static int findIndexByIteration(int[]inp){
        int n = inp.length;

        int low = 0,high=n-1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (mid > low && inp[mid] < inp[mid - 1]) {
                return mid - 1;
            }
            if (mid < high && inp[mid] > inp[mid + 1]) {
                return mid;
            }
            if (inp[low] >= inp[mid]) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int findIndexByRecursion(int[]nums, int low, int high){
        if(high == low){
            return -1;
        }

        int mid = low + (high - low)/2;

        if(mid > low && nums[mid] < nums[mid -1]){
            return mid -1;
        }
        if(mid < high && nums[mid] > nums[mid + 1]){
            return mid;
        }
        if(nums[low] >= nums[mid]){
            return findIndexByRecursion(nums, low, mid-1);
        } else {
            return findIndexByRecursion(nums, mid + 1, high);
        }
    }

    static int findIndexOptimal(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
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
        return index;
    }

    public static void main(String[] args) {
        int[] inp = {3,4,5,6,2};

        System.out.println(findIndexByIteration(inp));
        System.out.println(findIndexByRecursion(inp,0,inp.length-1));
        System.out.println(findIndexOptimal(inp));
    }
}
