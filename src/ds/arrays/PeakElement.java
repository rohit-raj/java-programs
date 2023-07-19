package ds.arrays;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement {

    public int findPeakElementBrute(int[] nums) {
        int n = nums.length;

//        if(n==1) return nums[0];

        for(int i=0;i<n;i++){
            if((i==0 || nums[i] > nums[i-1]) && (i==n-1 || nums[i] > nums[i+1])) {
                return i;
            }

        }
        return -1;
    }

    public int findPeakElementOptimal(int[] nums){
        int n = nums.length;

        if(n==1) return 0;

        if(nums[0] > nums[1]) return 0;

        if(nums[n-1] > nums[n-2])  return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(low == high){
                return mid;
            }
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            } else if(nums[mid-1] < nums[mid]){
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(10);

        int[] nums = new int[size];
        for(int i = 0; i < size; i++) {
            nums[i] = random.nextInt(50);
        }

//        Arrays.sort(nums);
//        nums = new int[]{37, 44, 30, 38, 10};
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        System.out.println("**********************");

        PeakElement pe = new PeakElement();

        System.out.println("findPeakElementBrute : "+ pe.findPeakElementBrute(nums));
        System.out.println("findPeakElementOptimal : "+ pe.findPeakElementOptimal(nums));

    }
}
