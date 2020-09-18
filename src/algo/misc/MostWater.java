package algo.misc;

/**
 * Created by rohit on 18/09/20.
 */
public class MostWater {
    static int getMostWater(int[] heights) {
        int h1, h2;
        int maxArea = 0;
        int len = heights.length;
        int j = len-1;
        int distance;
        int i = 0;
        while(i < j) {
            h1 = heights[i];
            h2 = heights[j];
            distance = j-i;

            int area = h1 > h2 ? h2*distance : h1*distance;
            maxArea = area > maxArea ? area : maxArea;
            System.out.println("i : "+h1+" * j : "+h2+" = "+ maxArea);
            if(h1 > h2) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("area : "+ getMostWater(heights));
    }
}
