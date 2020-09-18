package algo.misc;

/**
 * Created by rohit on 18/09/20.
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

    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5};
        System.out.println("area : "+ getTrappedWater(heights));
    }
}
