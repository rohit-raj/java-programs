package algo.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {

    public static int fibonacciMemoization(int n, int[] ans){
        if(ans[n] != 0){
            return ans[n];
        }

        if(n<=1){
            ans[n] = n;
            return n;
        }

        int a = fibonacciMemoization(n-1, ans);
        int b = fibonacciMemoization(n-2, ans);
        ans[n] = a+b;
        return a+b;
    }

    public static int[] fibo(int n){
        int[] ans = new int[n+1];
        fibonacciMemoization(n, ans);
        return ans;
    }


    public static int[] fibonacciTabulation(int n){
        int[] ans = new int[n+1];
        ans[0]=0;
        ans[1]=1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans;
    }

    public static int fibonacciTabulationOfN(int n){
        int prev = 1;
        int prev2 = 0;
        for(int i=2;i<=n;i++){
            int ans = prev+prev2;
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 5;
        int [] ans = fibo(n);
        List<Integer> list = Arrays.stream(ans).boxed().collect(Collectors.toList());
        System.out.println("list : "+ list);

        int[] ans2 = fibonacciTabulation(n);
        List<Integer> list2 = Arrays.stream(ans2).boxed().collect(Collectors.toList());
        System.out.println("list2 : "+ list2);


        System.out.println("ans : "+ fibonacciTabulationOfN(n));

    }
}
