package blind75;

import java.util.Arrays;
import java.util.HashMap;
/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    static int[] twoSumNaive(int[] inp, int target){
        int sum = 0;
        int[] ans = new int[2];
        ans[0]=ans[1]=-1;
        for(int i=0;i<inp.length;i++){
            for(int j=i+1;j<inp.length;j++){
                if(inp[i]+inp[j] == target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }

            }
        }
        return ans;
    }

    static int[] twoSumBetter(int[] inp, int target){
        int[] ans = new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inp.length;i++){
            if(map.containsKey(inp[i])){
                ans[0]=map.get(inp[i]);
                ans[1]=i;
                return ans;
            } else {
                map.put(target-inp[i], i);
            }
        }
        return ans;
    }

    /**
     * The below is 2 pointer approach using greedy.
     * This will not be able to give you the indexes correctly
     * but will give you if the sum of 2 numbers in the array are equal to the target
     * @param inp
     * @param target
     * @return
     */
    static String twoSumOptimal(int[] inp, int target){
        Arrays.sort(inp);
        int low = 0, high=inp.length-1;
        int[] ans = new int[2];
        ans[0]=ans[1]=-1;
        while(low < high){
            int sum = inp[low]+inp[high];
            if(sum == target){
                return "yes";
            } else if( sum < target){
                low++;
            } else {
                high--;
            }
        }
        return "no";
    }

    public static void main(String[] args) {
        int[] inp = {3,2,4};//,6,5,8,11};
        int target = 6;

        int[] res1 = twoSumNaive(inp, target);
//        printArray(res1);

        int[] res2 = twoSumBetter(inp, target);
//        printArray(res2);

        String res3 = twoSumOptimal(inp, target);
        System.out.println(res3);
    }

    static void printArray(int[] inp){
        for (int value : inp) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
