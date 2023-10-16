package algo.misc;

import org.omg.CORBA.INTERNAL;

/**
 * https://leetcode.com/problems/detect-squares/
 * Neetcode
 */
public class DetectSquares {
    private Integer[][] points;

    public DetectSquares() {
        points = new Integer[1001][1001];
    }

    public void add(int[] point) {
        if(points[point[0]][point[1]] == null){
            points[point[0]][point[1]] = 1;
        } else {
            points[point[0]][point[1]] = points[point[0]][point[1]] + 1;
        }
    }

    public int count(int[] point) {
        return 0;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        detectSquares.count(new int[] {11, 10}); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int[] {14, 8});  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[] {11, 2});    // Adding duplicate points is allowed.
        detectSquares.count(new int[] {11, 10}); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points
    }

}
