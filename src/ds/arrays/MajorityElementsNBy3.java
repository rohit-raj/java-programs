package ds.arrays;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/majority-element-ii/
public class MajorityElementsNBy3 {

    static List<Integer> majorityElementBrute(int[] nums){
        Set<Integer> ans2 = new HashSet<>();
        int n= nums.length;
        int mini = (int)(n / 3) + 1;
        for (int value : nums) {
            int localCount = 0;
            for (int num : nums) {
                if (value == num) {
                    localCount++;
                }
                if (localCount == mini) {
                    ans2.add(value);
                }
            }
        }

        return new ArrayList<>(ans2);
    }

    static List<Integer> majorityElementBetter(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int mini = (int)(n / 3) + 1;

        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);

            if(map.get(num) == mini){
                ans.add(num);
            }
        }
        return ans;

    }

    static List<Integer> majorityElementOptimal(int[] nums){
        int ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE, count1=0, count2=0;

        List<Integer> ans = new ArrayList<>();
        for(int value : nums){
            if(count1 ==0 && value != ele2 ){
                count1 = 1;
                ele1 = value;
            }
            else if(count2 == 0 && value != ele1){
                count2 = 1;
                ele2 = value;
            }
            else if(value == ele1){
                count1++;
            }
            else if(value == ele2){
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (int value : nums){
            if(value == ele1){
                count1++;
            }
            if(value == ele2){
                count2++;
            }
        }

        int mini = (int)(nums.length / 3) + 1;

        if(count1 >= mini) ans.add(ele1);
        if(count2 >= mini) ans.add(ele2);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] inp = {2,2,1,1,1,2,2};
        System.out.println("Brute : "+ majorityElementBrute(inp));
        System.out.println("Better : "+ majorityElementBetter(inp));
        System.out.println("Optimal : "+ majorityElementOptimal(inp));
    }
}
