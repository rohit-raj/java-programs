package ds.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoAndBananas {

    static int minEatingSpeedBrute(int[] bunches, int hours){
        int n = bunches.length;

        int speed=1;
        while(true){
            int sum = computeHours3(bunches, speed);
//            System.out.println("speed: "+speed+" :: sum : "+sum);
//            System.out.println();
            if (sum > hours) {
                speed++;
            } else break;
        }
        return speed;
    }

    static int max (int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static int computeHours3(int[] bunches, int speed){
        int hours=0;
        for(int i=0;i<bunches.length;i++){
            hours += Math.ceil((double)bunches[i]/(double)speed);
        }
        return hours;
    }

    static int minEatingSpeedOptimal(int[] bunches, int hours){
        int speed = 1;
        int maxSpeed = max(bunches);
        int ans = Integer.MAX_VALUE;
        while(speed <= maxSpeed){
            int midSpeed = speed + (maxSpeed-speed)/2;
//            System.out.print("midSpeed "+ midSpeed);
            int sumHours = computeHours3(bunches, midSpeed);
//            int sumHours = computeHours2(bunches, midSpeed, hours);
//            System.out.println(": sumHours2 : "+sumHours2+" : sumHours "+ sumHours);
//            System.out.println();
            /*if (sumHours == 0) {
                return midSpeed;
            } else if(sumHours == 1){
                maxSpeed = midSpeed-1;
            } else {
                speed = midSpeed+1;
            }*/
            if(sumHours <= hours){
                ans = Math.min(ans, midSpeed);
                maxSpeed = midSpeed-1;
            } else {
                speed = midSpeed+1;
            }

        }
        return speed;
    }

    public static void main(String[] args) {
//        int[] nums = {312884470};
        int[] nums = {3,6,7,11};
//        int[] nums = {30,11,23,4,20};
//        int[] nums = {1,1,1,999999999};
        int h = 8;
//        int h = 312884469;

        System.out.println("minEatingSpeedBrute : "+minEatingSpeedBrute(nums, h));
        System.out.println("minEatingSpeedOptimal : "+minEatingSpeedOptimal(nums, h));
    }
}
