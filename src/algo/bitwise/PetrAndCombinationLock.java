package algo.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * https://codeforces.com/problemset/problem/1097/B
 *
 * Complexity is really bad with bitwise as it taken 2^n * n
 */
public class PetrAndCombinationLock {

    static boolean canTheLockGetOpen(int[] nums){
        int n = nums.length;
        int x = 1<<n;
        boolean flag = false;
        for(int i=0;i<x;i++){
            int sum = 0;
            List<Integer> ansList = new ArrayList<>();
            for(int bit=0;bit<n;bit++){
                if((i & (1<<bit)) != 0){
                    ansList.add(nums[bit]);
                    sum += nums[bit];
                } else {
                    ansList.add(-1*nums[bit]);
                    sum -= nums[bit];
                }
            }
            if(sum%360 == 0){
                System.out.println("ans list: "+ansList);
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(14);

        int[] input = new int[size];
        for(int i=0;i<size;i++){
            input[i] = random.nextInt(360);
        }

        System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
        System.out.println("==================Output=================");
        System.out.println("can the lock be opened with given input : "+ canTheLockGetOpen(input));

    }
}
