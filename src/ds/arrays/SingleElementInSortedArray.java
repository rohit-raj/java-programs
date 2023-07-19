package ds.arrays;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray {

    static int findSingleElementBrute(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i] != nums[i+1]) return nums[i];
            } else if(i == n-1){
                if(nums[i] != nums[i-1]) return nums[i];
            } else {
                if(nums[i] != nums[i+1] && nums[i] != nums[i-1]) return nums[i];
            }
        }
        return 0;
    }

    static int findSingleElementBetter(int[] nums){
        int n = nums.length;

        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }

    static int findSingleElementOptimal(int[] nums){
        int n = nums.length;

        if(n == 1) return nums[0];

        if(nums[0] != nums[1]) return nums[0];

        if(nums[n-2] != nums[n-1]) return nums[n-1];

        int low = 1;
        int high = n-2;

        while (low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid-1] == nums[mid]){
                if((mid%2)==0) high = mid-1;
                else low = mid+1;
            } else if(nums[mid] == nums[mid+1]){
                if((mid%2)==0) low = mid+1;
                else high = mid-1;
            } else
                return nums[mid];
        }
        return nums[low];
    }


    static int findSingleMoreOptimal(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];

        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1;
        int high = n-2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }

            if(((mid%2)==1 && nums[mid-1] == nums[mid]) || ((mid%2)==0 && nums[mid] == nums[mid+1]))
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    static int findElement(int[] input, int low, int high){
//        int low = 0;
//        int high = input.length-1;
        if(low <= high) {
            int mid = low + (high - low) / 2;

            if (input[mid] == input[mid - 1]) {
                if ((mid+1 - low) % 2 == 0) {
                    return findElement(input, mid+1, high);
                } else {
                    return findElement(input, low, mid-1);
                }
            } else {
                if ((mid+1 - low) % 2 == 0) {
                    return findElement(input, low, mid - 1);
                } else {
                    return findElement(input, mid+1, high);
                }
            }
        }
        return input[high];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,5,5,6,6,7,7,8,8};

        System.out.println("findDuplicateBrute : "+ findSingleElementBrute(nums));
        System.out.println("findSingleElementBetter : "+ findSingleElementBetter(nums));
        System.out.println("findSingleElementOptimal : "+ findSingleElementOptimal(nums));
        System.out.println("findElement : "+ findElement(nums, 0, nums.length-1));
        System.out.println("findSingleMoreOptimal : "+ findSingleMoreOptimal(nums));
    }
}
