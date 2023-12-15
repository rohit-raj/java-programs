package algo.misc;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverage {
    int maxSize;
    ArrayList<Integer> values;
    public MovingAverage(int size) {
        values = new ArrayList<>();
        maxSize = size;
    }

    public double next(int val) {
        values.add(val);
        if(values.size()> maxSize) values.remove(0);
        int sum = 0;
        for(int i=0;i<values.size();i++){
            sum += values.get(i);
        }
        return (double)sum/values.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("next val -> 1 : " + movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println("next val -> 10 : " + movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println("next val -> 3 : " + movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println("next val -> 5 : " + movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
