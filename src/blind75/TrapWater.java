package blind75;

/**
 * Created by rohit on 18/09/20.
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */

public class TrapWater {
    static int getTrappedWater(int[] heights) {
        int h1, h2;
        int maxArea = 0;
        int len = heights.length;
        int j = len-1;
        int i = 0;
        int h1x = 0, h2x = 0;
        while(i < j) {
            h1 = heights[i];
            h2 = heights[j];

            if(h1 > h2) {
                if(h2 >= h2x)
                    h2x = h2;
                else
                    maxArea += h2x-h2;
                j--;
            } else {
                if(h1 >= h1x)
                    h1x = h1;
                else
                    maxArea+=h1x-h1;
                i++;
            }
        }
        return maxArea;
    }

    static int trapWater(int[] heights){
        int n = heights.length;//7
        int maxWater = Integer.MIN_VALUE;
        int i =0, j=n-1;
        while (i < j){
            int h1 = heights[i];//0
            int h2 = heights[j];//6
            int gap = j-i;
            int water = Math.min(h1, h2)*gap;
            maxWater = Math.max(water, maxWater);
            if(h1 > h2) j--;
            else i++;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5,4,8,3,7};
//        System.out.println("area : "+ getTrappedWater(heights));
        System.out.println("area : "+ trapWater(heights));
    }
}
