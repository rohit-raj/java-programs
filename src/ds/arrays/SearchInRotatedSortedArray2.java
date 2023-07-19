package ds.arrays;

public class SearchInRotatedSortedArray2 {

    static boolean search(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int inp [] = {1,0,1,1,1};

        int k = 0;
        boolean pos = search(inp, k);
        System.out.println("found ? : "+ pos);

    }
}
