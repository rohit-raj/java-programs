package ds.trie;

import ds.arrays.MaximumXorOfTwoNumbers;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXorOfTwoNumbersTrie {

    public int findMaximumXORBetter(int[] nums){
        MaximumXorOfTwoNumbers mx = new MaximumXorOfTwoNumbers();
        return mx.findMaximumXORBetter(nums);
    }



    public int findMaximumXorTrie2(int[] nums){
        IntTrieNode root = new IntTrieNode();
        int max = 0;
        for(int num : nums){
            int currXor = 0;
            IntTrieNode node = root, xorNode = root;
            for(int i=31;i>=0;i--){
                int bit = (num >> i) &1;
                if(!node.containsKey(bit)){
                    node.put(bit, new IntTrieNode());
                }
                node = node.get(bit);

                int toggledBit = 1-bit;

                if(xorNode.containsKey(toggledBit)){
                    currXor = currXor | (1<<i);
                    xorNode = xorNode.get(toggledBit);
                } else {
                    xorNode = xorNode.get(bit);
                }
            }
            max = Math.max(max, currXor);
//            System.out.println();
        }
        return max;
    }


    public IntTrieNode createTrie(IntTrieNode root, int[] nums){
        for(int num : nums){
            IntTrieNode node = root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(!node.containsKey(bit)){
                    node.put(bit, new IntTrieNode());
                }
                node = node.get(bit);
            }
        }
        return root;
    }

    public int getMax(IntTrieNode root, int num){
        IntTrieNode node = root;
        int xorSum = 0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit)){
                xorSum |= (1<<i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return xorSum;
    }

    public int findMaximumXorTrie1(int[] nums){
        IntTrieNode root = new IntTrieNode();
        root = createTrie(root, nums);

        int max = 0;
        for(int num : nums){
            max = Math.max(max, getMax(root, num));
        }
        return max;
    }

    public int findMaximumXOROptimal(int[] nums) {
        int maxXorSum = 0, xorSum = 0;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int maxBit = 0;
        while (maxVal != 0) {
            maxBit++;
            maxVal >>= 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = maxBit - 1; i >= 0; i--) {
            set.clear();
            xorSum |= (1 << i);//11111
            int temp = maxXorSum | (1<<i);
            System.out.println("maxXorSum : "+ maxXorSum + " : xorSum : "+ xorSum + " : temp : "+ temp);
            for (int num : nums) {
                int setElement = num & xorSum;
                System.out.println(num + " & "+xorSum+ " = "+ setElement + " setElement ^ temp : "+ (setElement ^ temp));
                set.add(setElement);
                if (set.contains(setElement ^ temp)) {
                    maxXorSum = temp;
                    break;
                }
            }
            //+ " : prefix : "+ Integer.toBinaryString(setElement)
            System.out.println("set : "+set+ " max val : "+ maxXorSum);
        }
        return maxXorSum;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5};
        MaximumXorOfTwoNumbersTrie mx = new MaximumXorOfTwoNumbersTrie();
//        IntTrieNode root = new IntTrieNode();
        long startTime = System.nanoTime();
        int max = mx.findMaximumXOROptimal(nums);//149864 //105625
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println("max :: "+ max + " : totalTime : "+totalTime);
    }
}
