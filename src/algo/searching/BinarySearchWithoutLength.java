package algo.searching;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BinarySearchWithoutLength {

    public static boolean find(int[] nums, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;

        while(low < high){
            int mid = low + (high-low)/2;
            try {
                if (nums[mid] == target) return true;
                else if(nums[mid] > target) high = mid-1;
                else low = mid+1;
            } catch (Exception ex){
                //if(ex.equals(java.lang.IndexOutOfBoundsException))
                high = mid-1;
            }
        }
        return false;
    }

    public static int findArraySize(Object[] arr) {
        int size = 1;
        while (getElementAtIndex(arr, size - 1) != null) {
            size *= 2;
        }
        return binarySearch(arr, size / 2, size);
    }

    public static Object getElementAtIndex(Object[] arr, int index) {
        try {
            return arr[index];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static int binarySearch(Object[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            Object element = getElementAtIndex(arr, mid);
            if (element == null) {
                return binarySearch(arr, low, mid);
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("find : "+ find(nums, 8));

        Object[] myArray = {1, 2, 3, 4};
        int size = findArraySize(myArray);
        System.out.println("Array size: " + size);
    }


}

// refyne
// 5: vp/engineer/cto
// technicals : 2 + tech managerial