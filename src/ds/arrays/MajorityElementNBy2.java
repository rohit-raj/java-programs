package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/majority-element/
public class MajorityElementNBy2 {

    static int majorityElementNaive(int[] inp){
        int count = 0;
        int value = -1;
        for (int i = 0; i < inp.length; i++) {
            int localCount = 0;
            for (int j = i; j < inp.length; j++) {
                if(inp[i] == inp[j]){
                    localCount++;
                }
                if(count < localCount){
                    value = inp[i];
                    count = localCount;
                }
            }
        }
//        System.out.println("value : "+ value + " : count : "+ count);
        return count > inp.length/2 ? value : -1;
    }

    static int majorityElementBetter(int[] inp){
        int count = 1;
        int value = inp[0];
        int localCount = 1;
        Arrays.sort(inp);
        for(int i=0;i<inp.length-1;i++){
            if(inp[i] == inp[i+1]){
                localCount++;
            } else {
                localCount = 1;
            }
            if(localCount > count){
                count = Math.max(count, localCount);
                value = inp[i];
            }

        }
//        System.out.println("value : "+ value + " : count : "+ count);
        return count > inp.length/2 ? value : -1;
    }

    static int majorityElementBetter2(int[] inp){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< inp.length;i++){
            if(map.containsKey(inp[i])){
                int value = map.get(inp[i]);
                map.replace(inp[i], value+1);
            } else {
                map.put(inp[i], 1);
            }
        }
        int element = 0;
        int count = 0;
        for (int key : map.keySet()) {
            int keyCount = map.get(key);
//            System.out.println("key :: "+ key+ " : value : "+keyCount);
            if(count < keyCount){
                count = keyCount;
                element = key;
            }
        }
        return count > inp.length/2 ? element : -1;
    }

    static int majorityElementOptimal(int[] inp){
        int count = 0;
        int element=inp[0];

        for (int value : inp) {
            if (count == 0) {
                count = 1;
                element = value;
            } else if (value == element) {
                count++;
            } else {
                count--;
            }
        }
        int localCount = 0;
        for (int i : inp) {
            if (i == element) localCount++;
        }

        return localCount > inp.length/2 ? element : -1;
    }
    public static void main(String[] args) {
        int[] inp = {2,2,1,1,1,2,2};
        System.out.println("Naive : "+ majorityElementNaive(inp));
        System.out.println("Better : "+ majorityElementBetter(inp));
        System.out.println("Better2 : "+ majorityElementBetter2(inp));
        System.out.println("Optimal : "+ majorityElementOptimal(inp));
    }
}
