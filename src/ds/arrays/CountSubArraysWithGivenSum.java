package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenSum {

    static int add(int[] nums, int start, int end){
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
    static int countSubArraysBrute(int[] nums, int sum){
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int currentSum = add(nums, i, j);
                if(currentSum == sum){
                    count ++;
                }
            }
        }
        return count;
    }


    static int countSubArraysBetter(int[] nums, int sum){
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int currentSum = 0;
            for(int j=i;j<n;j++){
                currentSum+=nums[j];
                if(currentSum == sum){
                    count ++;
                }
            }
        }
        return count;
    }

    static int countSubArraysOptimal(int[] nums, int sum){
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int prevSum = 0;
        for(int i=0;i<n;i++){
            prevSum += nums[i];
            int remove = prevSum-sum;
            count += preSumMap.getOrDefault(remove, 0);
            preSumMap.put(prevSum, preSumMap.getOrDefault(prevSum, 0) + 1);

        }
        return count;
    }
    public static void main(String[] args) {
        int[] inp = {1,2,1,3,0,2,4,2,3,1,1,1,1};
        int k = 6;

        System.out.println("countSubArraysBrute :: "+ countSubArraysBrute(inp, k));
        System.out.println("countSubArraysBetter :: "+ countSubArraysBetter(inp, k));
        System.out.println("countSubArraysOptimal :: "+ countSubArraysOptimal(inp, k));

    }
}
