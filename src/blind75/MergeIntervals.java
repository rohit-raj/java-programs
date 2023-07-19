package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    /**
     * complexity
     * space : O(N)
     * time : NlogN + O(2N)
     */
    static int[][] mergeIntervalsBrute(int[][] intervals){
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();

        //sort
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));


        for(int i=0; i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            for(int j=i;j<n;j++){

                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }

        int[][] finalAns = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            finalAns[i][0] = ans.get(i).get(0);
            finalAns[i][1] = ans.get(i).get(1);
        }

        return finalAns;
    }

    /**
     *
     */
    static int[][] mergeIntervalsOptimal(int[][] intervals){
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty()){
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            else if(ans.get(ans.size()-1).get(1) < intervals[i][0]){
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            else {
                int start = ans.get(ans.size()-1).get(0);
                int end = intervals[i][1];
                ans.set(ans.size()-1, Arrays.asList(start, end));
            }
        }
        int[][] finalAns = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            finalAns[i][0] = ans.get(i).get(0);
            finalAns[i][1] = ans.get(i).get(1);
        }
        return finalAns;
    }

    static int[][] mergeIntervalsOptimal2(int[][] intervals){
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty()){
                merged.add(interval);
            } else if(merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

//        print2DArray("intervals : ", intervals);
        print2DArray("brute : ", mergeIntervalsBrute(intervals));
        print2DArray("optimal : ", mergeIntervalsOptimal(intervals));
        print2DArray("optimal2 : ", mergeIntervalsOptimal2(intervals));
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
