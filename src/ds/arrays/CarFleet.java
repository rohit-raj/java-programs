package ds.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * https://leetcode.com/problems/car-fleet/
 */
public class CarFleet {



    public static int carFleetBrute(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        Arrays.sort(combined, Comparator.comparingInt(o->o[0]));
        /*for (int i=0;i<n;i++){
            System.out.println(i +": "+combined[i][0]);
        }*/
        for (int i=n-1;i>=0;i--){
            double currTime = (double)(target-combined[i][0])/combined[i][1];
            if(!stack.isEmpty() && currTime <= stack.peek()){
                continue;
            } else {
                stack.push(currTime);
            }
        }
        return stack.size();
    }

    public static int carFleetOptimal(int target, int[] position, int[] speed) {
        int fleets=0;
        float[] time = new float[target];
        float maxTime=0;
        for(int i=0;i<position.length;i++)
        {
            time[position[i]]=(float)(target-position[i])/speed[i];
        }

        for(int i=target-1;i>=0;i--)
        {
            if(time[i]>maxTime)
            {
                maxTime=time[i];
                fleets++;
            }
        }
        return fleets;
    }

    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        System.out.println("ans :: "+ carFleetBrute(target, position, speed));
        System.out.println("ans :: "+ carFleetOptimal(target, position, speed));
    }
}
