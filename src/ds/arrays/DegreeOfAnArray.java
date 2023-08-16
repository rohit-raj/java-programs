package ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array
 */
public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(!map.containsKey(a)){
                map.put(a, new int[]{i,i,1});
                if(max == 0) max = 1;
                if (end == 0) end = 1;
            }
            else {
                int x[] = map.get(a);
                x[1] = i;
                x[2]++;
                if(x[2]>max){
                    max = x[2];
                    end=i-x[0]+1;
                } else if(x[2]==max){
                    end=Math.min(end,i-x[0]+1);
                }
            }
        }
        return end;
    }


    public static void main(String[] args) {
        int[] inp = {1,2,2,3,1,4,2};

        System.out.println("findShortestSubArray : " + findShortestSubArray(inp));
    }
}
