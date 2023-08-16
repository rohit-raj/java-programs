package ds.trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * HARD
 *
 * https://www.youtube.com/watch?v=Q8LhG9Pi5KM
 */

public class MaxXorWithQueries {
    static class IntTrieNode {
        IntTrieNode[] childNode;

        public IntTrieNode(){
            childNode = new IntTrieNode[2];
        }

        boolean containsKey(int ind){
            return childNode[ind]!=null;
        }

        IntTrieNode get(int ind){
            return childNode[ind];
        }

        void put(int ind, IntTrieNode node){
            childNode[ind] = node;
        }
    }

    public IntTrieNode createTrie(IntTrieNode root, int num){
        IntTrieNode node = root;
        for (int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit, new IntTrieNode());
            }
            node = node.get(bit);
        }
        return root;
    }

    public int getMax(IntTrieNode root, int num){
        IntTrieNode node = root;
        int xorSum = 0;
        for(int i=31;i>=0;i--){
            int bit = (num >>i)&1;
            if(node.containsKey(1-bit)){
                xorSum |= (1<<i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return xorSum;
    }

    public int[] maximizeXorOptimal(int[] nums, int[][] queries){
        Arrays.sort(nums);
        int qLen = queries.length;
        int numLen = nums.length;
        int [] ans = new int[qLen];

        int[][] offlineQueries = new int[qLen][3];
        for(int i=0;i<qLen;i++) {
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, (a,b)->{return a[1]-b[1];});

        IntTrieNode root = new IntTrieNode();

        int idx = 0;
        for(int[] query : offlineQueries) {
            int a = query[1];
            while (idx < numLen && nums[idx] <= a){
                root = createTrie(root, nums[idx]);
                idx++;
            }

            int queryInd = query[2];
            int x = query[0];
            if(idx!=0) ans[queryInd] = getMax(root, x);
            else ans[queryInd] = -1;
        }
        return ans;
    }


    // Brute Starts
    public int[] maximizeXorBrute(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int [] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            int x = query[0];
            int a = query[1];

            int maxXor = -1;
            for(int num : nums){
                if(num <= a){
                    maxXor = Math.max(maxXor, (x^num));
                }
            }
            ans[i] = maxXor;
        }
        return ans;
    }
    // Brute Ends

    public static void main(String[] args) {
        int[] nums = {5,2,4,6,6,3};
        int[][] queries = {{12,4},{8,1},{6,3}};


        MaxXorWithQueries mx = new MaxXorWithQueries();

        long startTime1 = System.nanoTime();
//        int[] ansBrute = mx.maximizeXorBrute(nums, queries);
        long endTime1   = System.nanoTime();
        double totalTime1 = endTime1-startTime1;

        long startTime2 = System.nanoTime();
        int[] ansOptimal = mx.maximizeXorOptimal(nums, queries);
        long endTime2   = System.nanoTime();
        double totalTime2 = endTime2-startTime2;


//        List<Integer> brute = Arrays.stream(ansBrute).boxed().collect(Collectors.toList());
        List<Integer> optimal = Arrays.stream(ansOptimal).boxed().collect(Collectors.toList());
//        System.out.println("maximizeXorBrute : "+ brute + " : totalTime : "+totalTime1);
        System.out.println("maximizeXorOptim : "+ optimal + " : totalTime : "+totalTime2);

    }
}
