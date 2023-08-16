package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertIntervals {

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                // Found the position, insert the interval and break from the loop.
                list.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }

        // If there is no interval with a greater value of start value,
        // then the interval must be inserted at the end of the list.
        if (!isIntervalInserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }


    public static int[][] mergeInterval(int[][] intervals){
        LinkedList<int[]> mergedList = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergedList.isEmpty()){
                mergedList.add(interval);
            } else if(mergedList.getLast()[1] < interval[0]){
                mergedList.add(interval);
            } else{
                mergedList.getLast()[1] = Math.max(interval[1], mergedList.getLast()[1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {4,8}, {6,7},{8,10}, {12,16}};

        int[] newInterval = {4,8};

        intervals = insertInterval(intervals, newInterval);

        int[][] res = mergeInterval(intervals);
        print2DArray("merged : ", res);
    }

    static void print2DArray(String message, int[][] mat){
        System.out.print(message);
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.print(list);
        }
        System.out.println();
    }
}
