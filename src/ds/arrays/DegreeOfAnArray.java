package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static class Values {
        int count;
        int start;
        int end;
        public Values(int _count){
            count = _count;
        }
        public Values(int _count, int _start, int _end){
            count = _count;
            start = _start;
            end = _end;
        }
    }
    public static int degree(List<Integer> arr){
        Map<Integer, Values> map = new HashMap<>();

        int maxOccurence = 0;
        int degree = Integer.MAX_VALUE;

        for(int i=0;i<arr.size();i++){
            if(!map.containsKey(arr.get(i))){
                map.put(arr.get(i), new Values(1, i, i));
            } else {
                int count = map.get(arr.get(i)).count+1;
                Values value = map.get(arr.get(i));
                value.count = count;
                value.end = i;
                map.put(arr.get(i), value);
            }
            maxOccurence = Math.max(maxOccurence, map.get(arr.get(i)).count);

        }

        System.out.println(maxOccurence);
        for (int key : map.keySet()){
            Values value = map.get(key);
            System.out.println("key "+ key+ ", count : "+ value.count+ ", start : "+ value.start+", end : "+value.end);

            int count = value.count;

            if(count == maxOccurence){
                degree = Math.min(degree, (value.end-value.start+1));
            }
        }

        return degree;
    }


    public static void main(String[] args) {
        int[] inp = {1,2,1,3,4,2};

//        System.out.println("findShortestSubArray : " + findShortestSubArray(inp));
        System.out.println("degree : " + degree(Arrays.stream(inp).boxed().collect(Collectors.toList())));
    }
}
