package ds.arrays;

import java.util.HashMap;

/**
 * Leetcode 540, Single Element in a Sorted Array
 */
public class FindUnique {

    static int findUniqueNaive(int[] inp) {
        for(int i=0;i<inp.length;i++){
            int count=0;
            int elem = inp[i];
            for(int j=0;j<inp.length;j++){
                if(inp[j] == elem){
                    count++;
                }
            }
            if(count == 1){
                return elem;
            }
        }
        return -1;
    }

    static int findUniqueBetter1(int[] inp) {
        int xor = 0;
        for (int value : inp) {
            xor = xor ^ value;
        }
        return xor;
    }

    static int findUniqueBetter2(int[] inp) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] hash = new int[inp[inp.length-1]+1];
        for (int value : inp) {
            hash[value]++;
        }

        for (int i=0;i<hash.length; i++) {
            if (hash[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * An Efficient Solution can find the required element in O(Log n) time.
     * The idea is to use Binary Search. Below is an observation on the input array.
     * All elements before the required have the first occurrence at even index (0, 2, ..)
     * and the next occurrence at odd index (1, 3, ...).
     * And all elements after the required elements have the first occurrence at an odd index
     * and the next occurrence at an even index.
     *
     * Find the middle index, say 'mid'.
     * If 'mid' is even, then compare arr[mid] and arr[mid + 1].
     * If both are the same, then the required element after 'mid' and else before mid.
     *
     * If 'mid' is odd, then compare arr[mid] and arr[mid - 1].
     * If both are the same, then the required element after 'mid' and else before mid.
     * @param inp
     * @return
     */
    static int findUniqueOptimal(int[] inp) {
        int low = 0,high=inp.length-1;
        while(low < high){
            int mid = low+(high-low)/2;

            //if mid is odd then move mid to left
            if(mid %2 == 1){
                mid--;
            }

            //if mid is not equal to mid+1 then element in in left half
            if(inp[mid]!= inp[mid+1]){
                high = mid;
            } else {
                low = mid+2;
            }
        }
        return inp[low];
    }
    public static void main(String[] args) {
        int[] inp = {1,1,2,2,3,3,4,4,5};

        int num = findUniqueOptimal(inp);
        System.out.println(num);
    }

    static void printArray (int[] array, boolean b) {
        if(b) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(i + ",\t");
            }
            System.out.println();
        }
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
