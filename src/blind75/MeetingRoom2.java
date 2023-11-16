package blind75;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoom2 {

    public static int minMeetingRooms(int[][] intervals) {
        int confRooms = 0;
        int n = intervals.length;

        if(n==1) return 1;
        Integer[] startTime = new Integer[n];
        Integer[] endTime = new Integer[n];
        for(int i=0;i<n;i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime, Integer::compare);
        Arrays.sort(endTime, (a,b)->Integer.compare(a,b));

        int startPtr=0, endPtr=0;
        while(startPtr < n){
            if(startTime[startPtr] >= endTime[endPtr]){
                confRooms--;
                endPtr++;
            }
            confRooms++;
            startPtr++;
        }
        return confRooms;
    }

    public static int minMeetingRoomsOptimal(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        for (int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            if (cur[0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.offer(cur);
        }
        return pq.size();

    }


    public static void main(String[] args) {
        int[][] intervals = {{9,10}, {4,9},{4,17}};
//        int[][] intervals = {{7,10},{2,4}};
        System.out.println("minMeetingRooms : "+ minMeetingRoomsOptimal(intervals));
    }
}
