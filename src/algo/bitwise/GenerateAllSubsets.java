package algo.bitwise;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {

    /**
     * In this problem, i & (1<<bit)) will always be non zero 8 times and for those 8 times, we pick the numbers from
     * the input array.
     * now good part is that all these non zeros occur in groups.
     *
     *
     * Complexity is a concern as this runs for 2^n * n times.
     * should not be applied in case when n is crossing 16 or 17 max.
     *
     */
    static void generate(int[] nums){
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();
        int x = (1<<n)-1;
        for(int i=0;i<=x;i++){
            List<Integer> ls = new ArrayList<>();
            for(int bit=0;bit<n;bit++){
                System.out.println("(i & (1<<bit)) : "+ (i & (1<<bit)));
                if((i & (1<<bit)) != 0){
                    ls.add(nums[bit]);
                }
            }
            System.out.println(ls);
            list.add(ls);
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};

        generate(nums);

    }
}
