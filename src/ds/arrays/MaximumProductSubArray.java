package ds.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * DP
 */
public class MaximumProductSubArray {

    static int maxProductBrute(int[] nums){
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){

            for(int j=i;j<n;j++){
                int currProd = 1;
                for(int k=i;k<=j;k++){
                    currProd *= nums[k];
                }
                maxProd = Math.max(currProd, maxProd);
            }

        }
        return maxProd;
    }

    static int maxProductBetter(int[] nums){
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int currProd = 1;
            for (int j=i;j<n;j++){
                currProd *= nums[j];
                maxProd = Math.max(currProd, maxProd);
            }
        }
        return maxProd;
    }

    static int maxProductOptimal(int[] nums){
        int n = nums.length;
        int ans = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for(int i=1;i<n;i++){
            int temp = maxProd;
            maxProd = Math.max(nums[i], Math.max(temp*nums[i], minProd*nums[i]));
            minProd = Math.min(nums[i], Math.min(temp*nums[i], minProd*nums[i]));
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }


    public static void main(String[] args) {
//        int inp [] = {2,3,-2,4};
        int inp [] = {-2,-1,-3,-4,-1,-2,-1,-5,-4,9};
//        int inp [] = {5,4,-1,7,8};

        System.out.println("maxProductBrute :: "+ maxProductBrute(inp));
        System.out.println("maxProductBetter :: "+ maxProductBetter(inp));
        System.out.println("maxProductOptimal :: "+ maxProductOptimal(inp));


    }
}
