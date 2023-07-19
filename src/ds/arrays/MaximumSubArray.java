package ds.arrays;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {

    static int maximumSubArraySumNaive(int[] inp) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < inp.length; i++){
            for(int j=i;j<inp.length;j++){
                int sum = 0;
                for(int k= i; k<=j;k++){
                    sum += inp[k];
                }
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;
    }

    static int maximumSubArraySumBetter(int[] inp){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < inp.length; i++){
            int sum = 0;
            for(int j=i;j<inp.length;j++){
                sum += inp[j];
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;
    }

    static int maximumSubArraySumOptimal(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
//            System.out.println("i = " + i+ " :: nums[i] :: "+nums[i]+" :: sum plus nums[i]::"+oldSum + " + "+nums[i]+ "= "+sumPlus+" :: sum :: " +sum+ " maxSum : "+ maxSum);
        }
        return maxSum;
    }

    static int maximumSubArraySumKadanes(int[] inp){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i=0;i<inp.length;i++){
            if(sum == 0) ansStart = i;
            sum += inp[i];
//            maxSum = Math.max(maxSum, sum);
            if(maxSum < sum){
                maxSum = sum;
                ansEnd = i;
            }
            if(sum < 0) sum = 0;
        }
//        System.out.println("Start : "+ansStart+" : End : "+ansEnd);
        return maxSum;
    }


    public static void main(String[] args) {
        int inp [] = {-1,1,-3,4,-1,2,1,-5,4};
//        int inp [] = {-2,-1,-3,-4,-1,-2,-1,-5,-4,9};
//        int inp [] = {5,4,-1,7,8};

        System.out.println("maximumSubArraySumNaive :: "+ maximumSubArraySumNaive(inp));
        System.out.println("maximumSubArraySumBetter :: "+ maximumSubArraySumBetter(inp));
        System.out.println("maximumSubArraySumOptimal :: "+ maximumSubArraySumOptimal(inp));
        System.out.println("maximumSubArraySumKadanes :: "+ maximumSubArraySumKadanes(inp));


    }
}
/*
-2+1-3+4-1+2+1-5+4 = 1
-2+1-3+4-1+2+1-5 = -3
-2+1-3+4-1+2+1 = 2
-2+1-3+4-1+2 = 1
-2+1-3+4-1 = -1
-2+1-3+4 = 0
-2+1-3 = -4
-2+1 = -1
-2 = -2


1-3+4-1+2+1-5+4 = 3
1-3+4-1+2+1-5 = -1
1-3+4-1+2+1 = 4
1-3+4-1+2 = 3
1-3+4-1 = 1
1-3+4 = 2
1-3 = -2
1 = 1



-2,1,-3,4,-1,2,1,-5,4
1,-3,4,-1,2,1,-5,4
-3,4,-1,2,1,-5,4
4,-1,2,1,-5,4
-1,2,1,-5,4
2,1,-5,4
1,-5,4
-5,4
4


*/

