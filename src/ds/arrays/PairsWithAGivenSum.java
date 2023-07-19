package algo.arrays;

import java.util.HashSet;

/**
 * sorted array of numbers, find the pairs that sums to x
 */

class PairsWithAGivenSum {
    static void findPairs(int inp[], int sum){
        int n = inp.length;
        HashSet<Integer> s = new HashSet<Integer>();

        for(int i = 0; i < n; i++){
            int temp = sum - inp[i];

            if(temp >= 0 && s.contains(temp)){
                System.out.println("(" + inp[i] + ", " + temp + ")");
            }
            s.add(inp[i]);
        }
    }

    static void findPrs(int inp[], int sum) {
        boolean res[] = new boolean[inp[inp.length-1]+1];

        for(int i = 0; i < inp.length; i++) {
            int temp = sum - inp[i];
            if(temp >= 0 && temp < res.length && res[temp])
                System.out.println("(" + inp[i] + ", " + temp + ")");

            res[inp[i]] = true;
        }

    }
    public static void main(String[] args) {
        int inp[] = {1,2,3,4,7,8,9,10};
        int x = 12;
        System.out.println("Pair with given sum " + x + " is : ");
        findPairs(inp, x);
        System.out.println("Pair with given sum by other method " + x + " is : ");
        findPrs(inp, x);
    }
}