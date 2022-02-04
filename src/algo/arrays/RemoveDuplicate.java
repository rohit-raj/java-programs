package algo.arrays;

/**
 * Created by rohit on 25/09/20.
 * Remove duplicate in a sorted array
 * if the array is not sorted then better to sort it and then remove the duplicate
 * better to have a fast pointer and slow pointer
 */
public class RemoveDuplicate {
    static int removeDuplicates1(int[] nums) {
        if(nums.length == 0) return 0;
        int dummy = nums[0]-1;
        int count = 0;
        int slowPtr = 0;
        for(int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
            if(nums[slowPtr] == nums[fastPtr]) {
                nums[fastPtr] = dummy;
            } else {
                slowPtr = fastPtr;
                count++;
            }
        }
        return count;
    }

    static int removeDuplicates2 (int[] nums) {
        if(nums.length == 0) return 0;
        int slowPtr = 0;

        for(int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
            if(nums[slowPtr] == nums[fastPtr]) {
                nums[slowPtr] = nums[fastPtr];
            } else {
                slowPtr++;
                nums[slowPtr] = nums[fastPtr];
            }
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        int inp [] = {0,0,1,1,1,1,2,2,3};
        System.out.println("removeDuplicates 1");
        for(int x : inp) {
            System.out.print(x+" ");
        }
        removeDuplicates1(inp);
        System.out.println();
        for(int x : inp) {
            if(x > inp[0])
                System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("removeDuplicates 2");
        int inp2 [] = {0,0,1,1,1,1,2,2,3};
        for(int x : inp2) {
            System.out.print(x+" ");
        }
        int len = removeDuplicates2(inp2);
        System.out.println();
        for(int i= 0; i <= len; i++) {
            System.out.print(inp2[i]+" ");
        }

    }
}
