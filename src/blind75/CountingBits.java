package blind75;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {


    static int[] countingBitsBrute(int n){
        int[] ans = new int[n+1];
        for(int i=1;i<=n;i++){
            int count = 0;
            int num = i;
            while(num !=0){
                if((num &1) ==1)count++;
                num= num>>1;
            }
            ans[i] = count;
        }
        return ans;
    }

    // Uses DP and bit operation
    // O(n)
    static int[] countingBitsOptimal(int n){
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + i % 2;
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 5;

        System.out.println("Brute : "+Arrays.stream(countingBitsBrute(n)).boxed().collect(Collectors.toList()));
        System.out.println("Optimal : " +Arrays.stream(countingBitsOptimal(n)).boxed().collect(Collectors.toList()));
    }
}
