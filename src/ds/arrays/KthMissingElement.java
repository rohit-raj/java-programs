package ds.arrays;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class KthMissingElement {

    static int findKthPositiveBrute(int[] arr, int k) {
        for (int value : arr) {
            if (value <= k) k++;
            else break;
        }
        return k;
    }


    static int findKthPositiveOptimal(int[] arr, int k){
        //find range in which k lies
        int low = 0;
        int high = arr.length-1;
        int missingNos = 0;
        while (low <= high){
            int mid = low + (high-low)/2;

            missingNos = arr[mid] - (mid+1);
//            System.out.println("low : "+low+" : mid : "+mid+" : high : "+ high+ " : missingNos : "+missingNos);

            if(missingNos < k){
                low = mid+1;
            } else
                high = mid-1;
        }


        /**
         * int more = k-missingNos;
         *
         * missingNos = arr[high] - (high + 1) // at the end of whole iteration, thus not considering mid
         *
         * ans = arr[high] + more
         *
         * ans = arr[high] + k - missingNos;
         *
         * ans = arr[high] + k - (arr[high] - (high + 1))
         * ans =  arr[high] + k - arr[high] + high + 1
         * ans = high + 1 + k; or low + k as high is 1 less than low at the end of while loop
         */
//        System.out.println("low : "+low+" : high : "+ high+ " : missingNos : "+missingNos);
//        System.out.println("start : "+start+" : end : "+end+ " : missingNos : "+missingNos);

        return high+1+k;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;

        System.out.println("findKthPositiveBrute : "+ findKthPositiveBrute(arr, k));
        System.out.println("findKthPositiveOptimal : "+ findKthPositiveOptimal(arr, k));
    }
}
