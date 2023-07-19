package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */

public class FindRepeatingAndMissingNumber {
    static int[] findBrute(int[] nums){
        int n = nums.length;
        int repeating = -1;
        int missing = -1;
        int totalSum = n*(n+1)/2;
        int foundSum = 0;
        for(int i=0;i<n;i++){
            foundSum+=nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    repeating = nums[i];
                }
            }
        }


        missing = totalSum + repeating - foundSum;

        return new int[]{repeating, missing};
    }

    static int[] findBrute2(int[] nums){
        int n = nums.length;
        int repeating = -1;
        int missing = -1;

        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(nums[j] == i)
                    count++;
            }
            if(count ==2) repeating =i;
            if(count == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }

    static int[] findBetter(int[] nums){
        int n = nums.length;
        int repeating = -1;
        int missing = -1;

        int[] hash = new int[n+1];
        for (int num : nums) {
            hash[num]++;
        }

        for(int i=1;i<=n;i++){
            if(hash[i]==2){
                repeating = i;
            }
            if(hash[i]==0){
                missing = i;
            }
            //below code is to not execute the loop completely if ans is already found
            if (repeating != -1 && missing != -1)
                break;
        }

        return new int[]{repeating, missing};
    }

    static int[] findOptimal(int[] nums){
        int n = nums.length;
        int repeating = 0;
        int missing = 0;
        int sn = n*(n+1)/2;//sum of n integers
        int s2n = (n*(n+1)*(2*n+1))/6; // sum of square of n integers
        int s = 0;
        int s2 = 0;

        for(int i=0;i<n;i++){
            s+=nums[i];
            s2 += (nums[i]*nums[i]);
        }

        int x = (s2 - s2n)/(s-sn);

        int y = s-sn;

        repeating = (x+y)/2;

        missing = x-repeating;
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,4,6,7,5};

        printArray("brute : ", findBrute(nums));
        printArray("brute2 : ", findBrute2(nums));
        printArray("findBetter : ", findBetter(nums));
        printArray("findOptimal : ", findOptimal(nums));

    }

    static void printArray (String message, int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(message + list);
    }
}
