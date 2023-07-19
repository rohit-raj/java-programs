package ds.arrays;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
 *
 * https://www.youtube.com/watch?v=R_Mfw4ew-Vo&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=18
 */
public class AggressiveCows {

    static boolean placeCows(int[] stalls, int distanceBetweenCows, int totalCows){
        int countOfCowsPlaced = 1;
        int lastPlaceCow = stalls[0];

        for(int i=1;i<stalls.length;i++){
            if((stalls[i] - lastPlaceCow) >= distanceBetweenCows){
                countOfCowsPlaced++;
                lastPlaceCow = stalls[i];
            }

            if(countOfCowsPlaced >= totalCows){
                return true;
            }
        }
        return false;
    }

    static int findDistanceBrute(int[] stalls, int cows){
        Arrays.sort(stalls);

        int max = stalls[stalls.length-1];
        int min = stalls[0];

        for (int i=1;i<(max-min);i++){
            if(placeCows(stalls,i,cows)){
                //Don't do anything
            } else {
                return i-1;
            }
        }
        return -1;
    }

    static int findDistanceOptimal(int[] stalls, int cows){
        Arrays.sort(stalls);

        int low = 0;
        int high = stalls[stalls.length-1] - stalls[low];

        int ans = -1;
        while (low <=high){
            int mid = low + (high-low)/2;
            if(placeCows(stalls,mid,cows)){
                //Don't do anything
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] stalls = {87,93,51,81,68,99,59 };
        int cows = 4; //no of aggressive cows


        System.out.println("findDistanceBrute : "+ findDistanceBrute(stalls, cows));
        System.out.println("findDistanceOptimal : "+ findDistanceOptimal(stalls, cows));

    }

}
