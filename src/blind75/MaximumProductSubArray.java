package blind75;

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

    /**
     * intuition is
     * 1. maintain MinProduct and MaxProduct, as there can be a chance that there could be multiple negative values
     * which can result in a max product.
     *
     * maxProduct = maximum of current number and max of current number * max product and current number * min product
     * minProduct = minimum of current number and min of current number * max product and current number * min product
     *
     * temp is used because max product gets replaced
     *
     * final answer is max of final answer and max product
     */
    static int maxProductOptimal(int[] nums){
        int n = nums.length;
        int finalMaxProd = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for(int i=1;i<n;i++){
            int temp = maxProd;
            maxProd = Math.max(nums[i], Math.max(temp*nums[i], minProd*nums[i]));
            minProd = Math.min(nums[i], Math.min(temp*nums[i], minProd*nums[i]));
            finalMaxProd = Math.max(finalMaxProd, maxProd);
        }
        return finalMaxProd;
    }

    /**
     * https://www.youtube.com/watch?v=hnswaLJvr6g&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=28
     */
    static int maxProductOptimal2(int[] nums){
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefixProd = 1;
        int suffixProd = 1;

        for(int i=0;i<n;i++){
            if(prefixProd == 0) prefixProd=1;
            if(suffixProd == 0) suffixProd = 1;

            prefixProd *= nums[i];
            suffixProd *= nums[n-i-1];
            maxProd = Math.max(maxProd, Math.max(prefixProd, suffixProd));
        }
        return maxProd;
    }


    public static void main(String[] args) {
        int inp [] = {2,3,-2,4};
//        int inp [] = {-2,-1,-3,-4,-1,-2,-1,-5,-4,9};
//        int inp [] = {5,4,-1,7,8};

        System.out.println("maxProductBrute :: "+ maxProductBrute(inp));
        System.out.println("maxProductBetter :: "+ maxProductBetter(inp));
        System.out.println("maxProductOptimal :: "+ maxProductOptimal(inp));
        System.out.println("maxProductOptimal2 :: "+ maxProductOptimal2(inp));


    }
}
