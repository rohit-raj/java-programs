package algo.misc;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInStream {
    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargestElementInStream(int k, int[] nums){
        this.k = k;

        heap = new PriorityQueue<>();

        for(int num : nums){
            heap.offer(num);
        }

        while (heap.size() > this.k){
            heap.poll();
        }
    }

    public int add(int num){
        heap.offer(num);
        while (heap.size() > this.k){
            heap.poll();
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInStream kles = new KthLargestElementInStream(3, new int[]{4, 5, 8, 2});

        System.out.println(kles.add(3));
        System.out.println(kles.add(5));
        System.out.println(kles.add(10));
        System.out.println(kles.add(9));
        System.out.println(kles.add(4));
    }

}
