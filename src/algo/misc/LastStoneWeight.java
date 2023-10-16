package algo.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    public static int lastStoneWeightBrute(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        if(n==1) return stones[0];

        while (stones[n-2]>0){
            int diff = stones[n-1]-stones[n-2];
            stones[n-2] = 0;
            stones[n-1] = diff;
            Arrays.sort(stones);
        }
        return stones[n-1];
    }

    public static int lastStoneWeightOpt(int[] stones) {
        int n = stones.length;
        if(n==1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) pq.offer(stone);

        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            int diff = Math.max(a,b)-Math.min(a,b);
            if(diff>0) pq.offer(diff);
        }
        int weight = 0;
        if(!pq.isEmpty()) weight = pq.poll();
        return weight;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};

//        System.out.println("last weight : "+ lastStoneWeightBrute(stones));
        System.out.println("last weight2 : "+ lastStoneWeightOpt(stones));
    }
}
