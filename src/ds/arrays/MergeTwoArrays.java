package ds.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeTwoArrays {

    static int[] mergeSortedBrute(int[] arr1, int m, int[] arr2, int n) {
        int[] output = new int[m+n];

        int i=0,j=0, k=0;

        while (i < m  && j < n){
            if(arr1[i] <= arr2[j]){
                output[k] = arr1[i];
                i++;
            }
            else {
                output[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < m){
            output[k] = arr1[i];
            k++;
            i++;
        }

        while (j < n) {
            output[k] = arr2[j];
            j++;
            k++;
        }

        return output;
    }

    /**
     * complexity : O(n-m) + O(NlogN)
     */
    static int[] mergeSortedBetter (int[] arr1, int m, int[] arr2, int n){
        for(int i = 0;i<n;i++){
            arr1[i+n] = arr2[i];
        }
        Arrays.sort(arr1);
        return arr1;
    }

    /**
     * Complexity O(N) + O(N)
     */
    static int[] mergeSortedOptimal(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(arr1[i] > arr2[j]){
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }

        while(j>=0){
            arr1[k] = arr2[j];
            j--;
            k--;
        }

        return arr1;
    }

    static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    static void merge(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1,3,4,5,0,0,0,0};
        int[] arr2 = {6,7,8,9};
        int m = 4;
        int n = arr2.length;

//        int [] res = ;

//        printArray("mergeSortedBrute : ", mergeSortedBrute(arr1, m, arr2, n));
//        printArray("mergeSortedBetter : ", mergeSortedBetter(arr1, m, arr2, n));
        arr1 = new int[]{1,3,4,5,0,0,0,0};//reinit was required as this is in-place
//        printArray("mergeSortedOptimal : ", mergeSortedOptimal(arr1, m, arr2, n));

        long[] arr3 = {1, 4, 8, 10};
        long[] arr4 = {2, 3, 9};
        int n1 = 4, m1 = 3;
        merge(arr3, arr4, n1, m1);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n1; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m1; i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();


    }

    static void printArray (String message, int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(message + list);
    }
}
