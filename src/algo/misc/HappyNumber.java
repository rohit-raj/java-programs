package algo.misc;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static int getNextNumber(int n){
        int sum = 0;
        while (n!=0){
            int rem = n%10;
            sum += rem*rem;
            n = n/10;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n!=1 && !visited.contains(n)){
            visited.add(n);
            n = getNextNumber(n);
        }
        return n ==1;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println("isHappy : "+ isHappy(n));
    }
}
