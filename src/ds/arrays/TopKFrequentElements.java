package ds.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static int[] topKFrequentBrute(int[] nums, int k) {
        int[] ans = new int[k];
//        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (a, b) ->map.get(a) - map.get(b));

        for(int key : map.keySet()){
            System.out.println("adding "+ key);
            heap.add(key);
            if(heap.size() > k) {
                System.out.println("head : "+ heap.peek());
                heap.poll();
            }
        }

//        System.out.println("heap :: "+ heap);

        for (int i=k-1;i>=0;i--){
            ans[i] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3};
        int k = 1;

        List<Integer> ans = Arrays.stream(topKFrequentBrute(nums, k)).boxed().collect(Collectors.toList());
        System.out.println("frequent elements brute : "+ ans);
    }
}
