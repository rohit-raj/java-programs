package algo.misc;

/**
 * Created by rohit on 19/09/20.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * product of array except self
 */
public class ArrayProduct {
    public int[] product(int [] nums) {
        //rotate number by length
        int n = nums.length;
        int[] output = new int[n];

        if(n<1) return output;

        int product = 1;
        for(int i=0;i<n;i++) {
            product*=nums[i];
            output[i] = product;
        }

        System.out.println("interim : " + Arrays.stream(output).boxed().collect(Collectors.toList()));
        product = 1;
        for(int i=n-1;i>0;i--) {
            output[i] = output[i-1] * product;
            product*=nums[i];
        }
        output[0] = product;
        return output;
    }
    public static void main(String[] args) {
        int [] nums = {1,4,3,6,8};
        ArrayProduct ap = new ArrayProduct();

        int[] res = ap.product(nums);
        System.out.println("res : " + Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
