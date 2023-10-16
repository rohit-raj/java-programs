package ds.arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Approach :
 * 1. If the lists are sorted then merge the lists into a single list using the merge logic of merge sort.
 * 2. If the lists are not sorted then implement merge sort
 * 3. Find the median
 */

public class MedianOfTwoSortedArrays {
    static int[] mergeSorted(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int[] output = new int[arr1Length+arr2Length];

        int i=0,j=0, k=0;

        while (i < arr1Length  && j < arr2Length){
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

        while (i < arr1Length){
            output[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2Length) {
            output[k] = arr2[j];
            j++;
            k++;
        }

        return output;
    }

    static double median (int[] input) {
        if(input.length%2 != 0){
            return (double) input[input.length/2];
        }
        int elem1 = input[(input.length-1)/2];
        int elem2 = input[input.length/2];
        return (double)(elem1 + elem2)/2;
    }

    static double findMedianOptimal(int[] num1, int[] num2){
        if(num1.length > num2.length){
            return findMedianOptimal(num2, num1);
        }
        int n1 = num1.length;
        int n2 = num2.length;

        int low = 0, high=n1;

        while (low <= high){
            int cut1 = low + (high-low)/2;
            int cut2 = (n1+n2+1)/2-cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : num1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : num2[cut2-1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : num1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : num2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if((n1+n2)%2 == 0){
                    return (double)(Math.max(left1,left2) + Math.min(right1, right2))/2;
                }
                return Math.max(left1,left2);
            } else if(left1 > right2){
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2};

        int[] res = mergeSorted(arr1, arr2);

        System.out.println("median1 : " + median(res));
        System.out.println("median2 : " + findMedianOptimal(arr1, arr2));

    }
}
