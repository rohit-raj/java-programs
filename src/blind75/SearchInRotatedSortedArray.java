package blind75;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray {
    static int findPivot(int[] nums, int low, int high){
        //if 1 element
        if(high < low){
            return -1;
        }
        //if 1 element
        if(high == low){
            return low;
        }

        int mid = low + (high - low)/2;


        if(mid > low && nums[mid] < nums[mid - 1]){
            return mid -1;
        }
        if(mid < high && nums[mid] > nums[mid + 1]){
            return mid;
        }
        if(nums[low] >=nums[mid]){
            return findPivot(nums,low, mid-1);
        }
        return findPivot(nums, mid+1, high);

    }

    static int findPivotOptimal(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]) {
                return low;
            } else if(nums[low] <= nums[mid]){
                low = mid+1;
            } else if(nums[low] > nums[mid]) {
                high = mid;
            } else {
                low = -1;
            }
        }
        return low;
    }
    static int search(int[]nums, int target){
        int high = nums.length -1;

//        int pivot = findPivot(nums, 0, high);
        int pivot = findPivotOptimal(nums);
        System.out.println("pivot : "+ pivot);

        if(pivot <= 0){
            if(nums[pivot] == target){
                return pivot;
            }
            //perform normal binary search as the array is not rotated
            return binarySearch(nums, 0, high, target);
        }

        if(nums[0] <= target){
            return binarySearch(nums, 0, pivot-1, target);
        }
        return binarySearch(nums, pivot+1, high, target);
    }
    static int binarySearch(int[] nums, int low, int high, int target){
        if(high < low){
            return -1;
        }

        int mid = low + (high - low)/2;

        if(nums[mid] == target){
            return mid;
        } if(target < nums[mid]){
            return binarySearch(nums, low, mid-1, target);
        }
        return binarySearch(nums, mid+1, high, target);

    }


    /**
     * https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
     *
     * This is more optimal as there is no iteration required for finding pivot.
     */
    static int search2(int arr[], int target) {
        int low = 0, high = arr.length - 1; //<---step 1

        while (low <= high) { //<--- step 2
            int mid = (low + high) >> 1; //<----step 3
            if (arr[mid] == target)
                return mid; // <---step 4

            if (arr[low] <= arr[mid]) { //<---step 5
                if (arr[low] <= target && arr[mid] >= target)
                    high = mid - 1; //<---step 6
                else
                    low = mid + 1; //<---step 7
            } else { //<---step 7
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1; //<---step 8
    }

    public static void main(String[] args) {
        int inp [] = {4,5,6,7,0,1,2,3};

        int k = 1;
        int pos = search2(inp, k);
        System.out.println("position : "+ pos);

    }

}
