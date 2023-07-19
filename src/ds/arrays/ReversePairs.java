package ds.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reverse-pairs/
 */
public class ReversePairs {
    static int pairsBrute(int[] nums){
        int res = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                if(nums[i]-nums[j] > nums[j]){
                    res++;
                }
            }
        }
        return res;
    }

    static void merge(int[] nums, int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = nums[low+i];
        }

        for (int j=0;j<n2;j++){
            R[j] = nums[mid+1+j];
        }

        int i=0,j=0,k=low;

        while (i<n1 && j<n2){
            if(L[i] < R[j]){
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            nums[k] = L[i];
            i++;
            k++;
        }
        while (j<n2){
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    static int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            while(j <= high && nums[i] > 2*(long)nums[j])
                j++;
            count+= j-(mid+1);
        }
        return count;
    }

    static int divide(int[] nums, int low, int high){
        int count = 0;
        if(low < high){
            int mid = low + (high - low)/2;
            count += divide(nums, low, mid);
            count += divide(nums, mid+1, high);
            count += countPairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return count;
    }

    static int pairsOptimal(int[] nums){
        int res = divide(nums, 0, nums.length-1);
//        printArray(nums);
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println("pairsBrute : "+ pairsBrute(nums));
        System.out.println("pairsOptimal : "+ pairsOptimal(nums));
    }

    static void printArray (int[] array) {
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
}
