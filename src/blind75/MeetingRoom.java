package blind75;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRoom {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1] ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{0,30}, {5,10},{15,20}};
        int[][] intervals = {{7,10},{2,4}};
        System.out.println("canAttendMeetings : "+ canAttendMeetings(intervals));
    }
}
