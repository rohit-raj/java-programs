import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/making-elements-distinct-sorted-array-minimum-increments/
 */
public class MinSum {
    static int minimumSorted(int arr[], int n) {
        int sum = arr[0], prev = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] <= prev) {
                prev = prev + 1;
                sum = sum + prev;
            } else {
                sum = sum + arr[i];
                prev = arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Arrays.sort(a);
        System.out.println(minimumSorted(a, a.length));

    }
}
