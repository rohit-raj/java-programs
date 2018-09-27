package algo.arrays;

import java.util.HashSet;

class PairsWithAGivenSum {
    static void findPairs(int inp[], int sum){
        int n = inp.length;
        HashSet<Integer> s = new HashSet<Integer>();

        for(int i = 0; i < n; i++){
            int temp = sum - inp[i];

            if(temp >= 0 && s.contains(temp)){
                System.out.println("Pair with given sum : " + sum + " is (" + inp[i] + ", " + temp + ")");
            }
            System.out.println(inp[i]);
            s.add(inp[i]);
        }
    }
    public static void main(String[] args) {
        int inp[] = {1,2,3,4,5,6,7,8,9,10};
        int x = 12;
        findPairs(inp, x);
    }
}