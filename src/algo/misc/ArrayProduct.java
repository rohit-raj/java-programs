package algo.misc;

/**
 * Created by rohit on 19/09/20.
 */

import java.util.Arrays;

/**
 * product of array except self
 */
public class ArrayProduct {
    static int product(int [] nums) {
        //rotate number by length
        int [] result = new int[nums.length];
        Arrays.fill(result, 1);

        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];

        }
        return 0;
    }
    public static void main(String[] args) {
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println("area : "+ product(nums));
    }
}
