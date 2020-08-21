package ds.misc;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */

public class SlidingWindow {
    static void printMax(int arr[], int n, int k){
        int j, max;

        for(int i = 0; i <= n-k; i++){
            max = arr[i];
            for(j=1; j<k;j++){
                if(arr[i+j] > max){
                    max = arr[i+j];
                }
            }
            System.out.print(max + " ");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = s.nextInt();
        }
        int k = s.nextInt();

        printMax(a, a.length, k);

    }
}