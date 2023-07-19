package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://takeuforward.org/data-structure/count-inversions-in-an-array/
 */
public class CountInversions {

    static int countBrute(int[] nums){
        int count = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]> nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    static int merge2(int[] nums, int low, int mid, int high){
        int count = 0;
        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i<n1; i++){
            L[i] = nums[low+i];
        }

        for(int j=0; j<n2; j++){
            R[j] = nums[mid+1+j];
        }

        int i=0,j=0,k=low;

        while (i<n1 && j< n2){
            if(L[i] <= R[j]){
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
//                System.out.println("mid : "+ mid + " : low : "+ (low+i)+" : mid-i+1 : "+ (mid-(low+i)+1));
                count+=(mid-(low+i)+1);
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j<n2){
            nums[k] = R[j];
            j++;
            k++;
        }

        return count;
    }

    static int divideSort(int[] nums, int low, int high){
        int count = 0;
        if(low < high){
            int mid = low + (high-low)/2;

            count += divideSort(nums, low, mid);
            count += divideSort(nums, mid+1, high);
            count += merge2(nums, low, mid, high);
        }
        return count;
    }

    static int countOptimal(int[] nums){
        return divideSort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {5,4,6,3,7,1};

//        System.out.println("countBrute : "+ countBrute(nums));
        System.out.println("countOptimal : "+ countOptimal(nums));

    }

    static void printArray (int[] array) {
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
}
