package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {

    static List<Integer> chooseLeadersNaive(int[] nums){
        int n = nums.length;
        List<Integer> leaders = new ArrayList<>();


        for(int i=0;i<n;i++){
            boolean leaderFlag = true;
            for(int j=i+1;j<n;j++){
                if(nums[j] > nums[i]){
                    leaderFlag = false;
                    break;
                }
            }
            if(leaderFlag){
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    static ArrayList<Integer> chooseLeadersOptimal(int[] nums){
        int n = nums.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        int leader = Integer.MIN_VALUE;

        for(int i=n-1; i>=0;i--){
            if(nums[i] >= leader) {
                leader = nums[i];
                leaders.add(nums[i]);
            }
        }

//        Collections.sort(leaders, Collections.reverseOrder());
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
//        List<Integer> res = chooseLeadersNaive(nums);
        ArrayList<Integer> res2 = chooseLeadersOptimal(nums);
//        printArray(res);
        printArray(res2);
    }

    static void printArray(List<Integer> array){
        System.out.println(Arrays.toString(array.toArray()));
    }

}
