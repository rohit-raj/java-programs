package algo.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rohit on 14/09/20.
 */
public class containDupTwo {

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int val = map.getOrDefault(x, -1);
             if(val == -1) {
                 map.put(x, i);
             } else {
                 if (k >= (i - val)) {
                     result = true;
                 } else {
                     map.replace(x, i);
                 }
             }
        }
        return result;

    }

    static boolean containsNearbyDuplicateByMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }

    public static void main(String[] args) {
        int inp [] = {99,99};
        System.out.println(containsNearbyDuplicate(inp, 2));
        System.out.println(containsNearbyDuplicateByMap(inp, 2));
    }
}
