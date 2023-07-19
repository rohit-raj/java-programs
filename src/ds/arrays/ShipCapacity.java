package ds.arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Find min capacity of ship to send all the weights in given days.
 */
public class ShipCapacity {

    static int computeDays(int[] weights, int capacity){
        int days=1;
        int load = 0;

        for (int weight : weights) {
            if ((load + weight) > capacity) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }

    static int shipWithinDaysBrute(int[] weights, int days) {
        int capacity = Integer.MIN_VALUE;

        for (int weight : weights) {
            capacity = Math.max(capacity, weight);
        }

        while (true){
            int computedDays = computeDays(weights, capacity);
            if(computedDays > days){
                capacity++;
            }else {
                break;
            }
        }
        return capacity;
    }

    static int shipWithinDaysOptimal(int[] weights, int days){
        int capacity = Integer.MIN_VALUE;

        int maxCapacity = 0;
        for (int weight : weights) {
            capacity = Math.max(capacity, weight);
            maxCapacity += weight;
        }

        int ans = maxCapacity;

        while (capacity <= maxCapacity){
            int mid = capacity + (maxCapacity-capacity)/2;
            int computedDays = computeDays(weights, mid);
            if(computedDays <= days){
                ans = mid;
                maxCapacity = mid-1;
            }else {
                capacity = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int[] weights = {3,2,2,4,1,4};
        int days = 3;

        System.out.println("shipWithinDaysBrute : "+ shipWithinDaysBrute(weights, days)+"\n");
        System.out.println("shipWithinDaysOptimal : "+ shipWithinDaysOptimal(weights, days));
    }
}
