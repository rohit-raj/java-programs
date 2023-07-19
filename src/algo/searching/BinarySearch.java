package algo.searching;

public class BinarySearch {
    static int binarySearchRecursion(int[] nums, int low, int high, int key){
        if(high < low){
            return -1;
        }
        int mid = low + (high - low)/2;

        if(nums[mid] == key){
            return mid;
        } if(key < nums[mid]){
            return binarySearchRecursion(nums, 0, mid -1, key);
        }
        return binarySearchRecursion(nums, mid + 1, high, key);
    }


    public static void main(String[] args) {
        int inp [] = {4,5,6,7,8,9,10};
        int k = 5;
        int pos = binarySearchRecursion(inp, 0, inp.length -1, k);
        int pos2 = binarySearchIterative(inp, 0, inp.length -1, k);
        System.out.println("position1 : "+ pos);
        System.out.println("position2 : "+ pos2);

    }

    static int binarySearchIterative(int[] nums, int low, int high, int key){
        while (low <= high) {
            int mid = low + (high-low)/2;

            if(key == nums[mid]) {
                return mid;
            } else if(key < nums[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
