package ds.arrays;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class SmallestDivisor {

    static int divisionResult(int[] nums, int divisor){
        int result=0;
        for(int i=0;i<nums.length;i++){
            result += Math.ceil((double)nums[i]/(double)divisor);
        }
        return result;
    }

    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }
        return max;
    }

    static int smallestDivisorBrute(int[] nums, int threshold) {
        int divisor = 1;
        while (true) {
            int divRes = divisionResult(nums, divisor);
            if(divRes > threshold){
                divisor++;
            } else
                break;
        }
        return divisor;
    }

    static int smallestDivisorOptimal(int[] nums, int threshold){
        int divisor = 1;
        int maxDivisor = max(nums);
        int ans = Integer.MAX_VALUE;
        while(divisor <= maxDivisor){
            int mid = divisor + (maxDivisor-divisor)/2;
            int divRes = divisionResult(nums, mid);
            if(divRes <= threshold){
                ans = Math.min(ans, mid);
                maxDivisor = mid-1;
            } else {
                divisor = mid+1;
            }
        }
        return divisor;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        int[] nums = {1,1,1,999999999};
        int threshold = 5;

        System.out.println("smallestDivisorBrute : "+ smallestDivisorBrute(nums, threshold));
        System.out.println("smallestDivisorOptimal : "+ smallestDivisorOptimal(nums, threshold));
    }
}
