package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int removed = 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevEnd > intervals[i][0]){
                removed++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return removed;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("ans "+ eraseOverlapIntervals(intervals));
    }
}
