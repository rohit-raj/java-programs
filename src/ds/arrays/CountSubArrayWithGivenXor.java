package ds.arrays;

import java.util.*;
//https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
//https://www.youtube.com/watch?v=eZr-6p0B7ME&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=23
public class CountSubArrayWithGivenXor {

    static int xorEd(int[] nums, int start, int end){
        int xorValue = nums[start];
        for(int i = start+1;i <=end;i++){
            xorValue = xorValue^nums[i];
        }
        return xorValue;
    }
    static int countSubArrayBrute(int[] nums, int targetXor){
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xorValue = xorEd(nums, i, j);
                if(xorValue == targetXor){
                    ans++;
                }
            }
        }
        return ans;
    }


    static int countSubArrayBetter(int[] nums, int targetXor){
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int currentXor = 0;
            for(int j=i;j<n;j++){
                currentXor = currentXor^nums[j];
//                System.out.println("currentXor : "+ currentXor);
                if(currentXor == targetXor){
                    ans++;
                }
            }
        }
        return ans;
    }

    static int countSubArrayOptimal(int[] nums, int targetXor){
        int ans=0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prevXor = 0;
        for(int i=0;i<n;i++){
            prevXor = prevXor^nums[i];
            int restXor = targetXor ^ prevXor;

            // the below can be simplified
//            if(map.containsKey(restXor)){
//                ans+= map.get(restXor);
//            }
//            if(map.containsKey(prevXor)) {
////                    map.get(prevXor);
//                map.put(prevXor, map.get(prevXor)+1);
//            } else {
//                map.put(prevXor, 1);
//            }

            //the above can be simplified
            ans+=map.getOrDefault(restXor, 0);
            map.put(prevXor, map.getOrDefault(prevXor, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int xorValue = 4;

        System.out.println("Brute : "+ countSubArrayBrute(nums, xorValue));
        System.out.println("Better : "+ countSubArrayBetter(nums, xorValue));
        System.out.println("Optimal : "+ countSubArrayOptimal(nums, xorValue));


    }
}
