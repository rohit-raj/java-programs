package ds.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    public static int[] sortUsingMapAndList(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            ans.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(ans,  (a, b) ->
            (map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b))
        );

        return ans.stream().mapToInt(i->i).toArray();

    }

    // Optimal
    public static int[] sortUsingMapAndArray(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[][] arr= new int[map.size()][2];
        int idx = 0;

        for(int key : map.keySet()){
            arr[idx][0] = key;
            arr[idx++][1] = map.get(key);
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[1]>b[1]) return 1;
            if(a[1]<b[1]) return -1;
            if(a[0]>b[0]) return -1;
            return 1;
        });
        idx = 0;
        for(int i=0;i<arr.length;i++){
            while (arr[i][1]-- > 0) {
                nums[idx++] = arr[i][0];
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        List<Integer> ans = Arrays.stream(sortUsingMapAndList(nums)).boxed().collect(Collectors.toList());
        System.out.println("isHappy : "+ ans);
    }
}
