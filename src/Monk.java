import java.util.*;
import java.lang.*;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-welcome-problem/
 */
public class Monk {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        int [] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int res = a[i] + b[i];
            System.out.println(res);
        }
    }
}
