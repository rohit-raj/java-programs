package ds.arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class MakeBouquets {

    static int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(min, num);
        }
        return min;
    }

    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }
        return max;
    }

    static boolean possible(int[] bloomDay, int m, int k, int day){
        int count=0;
        int bouquets=0;
        for (int value : bloomDay) {
            if (value <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count/k;
        return bouquets >= m;
    }

    static int minDaysBrute(int[] bloomDay, int m, int k) {

        int min = min(bloomDay);
        int max = max(bloomDay);

        for (int i=min;i<=max;i++){
            if(possible(bloomDay, m, k, i)){
                return i;
            }
        }

        return -1;
    }

    static int minDaysOptimal(int[] bloomDay, int m, int k){
        if((m*k) > bloomDay.length){
            return -1;
        }
        int low = min(bloomDay);
        int high = max(bloomDay);
        int ans = -1;

        while (low <= high){
            int mid = low + (high-low)/2;
            boolean isItPossible = possible(bloomDay, m, k, mid);
            if(isItPossible){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;

        System.out.println("minDaysBrute : "+ minDaysBrute(bloomDay, m, k));
        System.out.println("minDaysOptimal : "+ minDaysOptimal(bloomDay, m, k));

    }
}
