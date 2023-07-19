package ds.arrays;

//https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class RearrangeArrayElementsBySign {

    static int[] rearrangeArrayNaive(int[] nums){
        int n = nums.length;

        int[] posArr = new int[n/2];
        int[] negArr = new int[n/2];
        int j = 0,k=0;
        for (int num : nums) {
            if (num > 0) {
                posArr[j++] = num;
            } else {
                negArr[k++] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = posArr[i / 2];
            } else {
                nums[i] = negArr[i / 2];
            }
        }

        // or

//        for (int i = 0; i < n / 2; i++) {
//            nums[2 * i] = posArr[i];
//            nums[2 * i + 1] = negArr[i];
//        }

        return nums;
    }

    static int[] rearrangeArrayNaiveOptimal(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int j=0;//keep track of positive number
        int k=0;//keep track of negative number
        /*for(int i=0;i<n;i++){
            if(nums[i] >= 0){
                ans[j*2] = nums[i];
                j++;
            } else {
                ans[k*2+1]=nums[i];
                k++;
            }
        }
*/
        //or
        int posIndex=0,negIndex=1;
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                ans[negIndex] = nums[i];
                negIndex+=2;
            } else {
                ans[posIndex]=nums[i];
                posIndex+=2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};

        int[] res;
        res = rearrangeArrayNaive(nums);
        printArray(res, false);
        int[] res1 = rearrangeArrayNaiveOptimal(nums);
        printArray(nums, false);
    }

    static void printArray (int[] array, boolean b) {
        if(b) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(i + ",\t");
            }
            System.out.println();
        }
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
