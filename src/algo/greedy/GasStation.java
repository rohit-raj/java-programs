package algo.greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/gas-station
 */
public class GasStation {
    public static int canCompleteCircuitBrute(int[] gas, int[] cost) {
        int sumOfGas = Arrays.stream(gas).sum();
        int sumOfCost = Arrays.stream(cost).sum();;

        if(sumOfGas< sumOfCost){
            return -1;
        }
        int startPosition = 0;
        int total = 0;

        for(int i=0;i<gas.length;i++){
            total += (gas[i]-cost[i]);
            if(total < 0){
                total = 0;
                startPosition = i+1;
            }
        }
        return startPosition;
    }

    public static int canCompleteCircuitOptimal(int[] gas, int[] cost) {
        int startPosition = 0;
        int total = 0;
        int totalSurplus = 0;

        for(int i=0;i<gas.length;i++){
            totalSurplus += (gas[i]-cost[i]);
            total += (gas[i]-cost[i]);
            if(total < 0){
                total = 0;
                startPosition = i+1;
            }
        }
        return totalSurplus < 0 ? -1 : startPosition;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost ={3,4,5,1,2};

        System.out.println("brute : "+ canCompleteCircuitBrute(gas, cost));
        System.out.println("Optimal : "+ canCompleteCircuitOptimal(gas, cost));
    }
}
