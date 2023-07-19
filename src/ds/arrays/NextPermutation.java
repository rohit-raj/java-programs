package ds.arrays;

//https://leetcode.com/problems/next-permutation/
//https://www.youtube.com/watch?v=JDOXKqF60RQ&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=26
public class NextPermutation {
    static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static int[] nextPermutation(int[] nums) {
        int index = -1;
        int n=nums.length;

        for(int i=n-2; i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        //index = 0
//        System.out.println("index"+index);

        if(index == -1){
            reverse(nums, 0, n-1);
            return nums;
        }

        //nums[index]=1
        for(int i=n-1; i>index;i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index+1, n-1);
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};

        printArray(nextPermutation(nums));
    }

    static void printArray(int[] array){
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
