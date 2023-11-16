package algo.misc;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sales force hackerrank OA question
 * https://leetcode.com/discuss/interview-question/570407/salesforce-oa-hackerrank
 */
public class VmPricing {

    public static String interpolate(int n, int[] instances, double[] prices) {
        List<Integer> res = findClosestElements(instances, n);
        HashMap<Integer,Double> hm = new HashMap<>();
        for(int i=0;i<instances.length;++i) {
            hm.put(instances[i], prices[i]);
        }
        int x1= res.get(0);
        int x2 = res.get(1);
        Double y1 = hm.get(x1);
        Double y2 = hm.get(x2);
        Double m = (y2-y1)/(x2-x1);
        Double y = m*(n-x1)+y1;

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        return df.format(y);
    }

    public static List<Integer> findClosestElements( int[] instances, int x) {
        // Initialize binary search bounds
        int k = 2;
        int left = 0;
        int right = instances.length-k;
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - instances[mid] > instances[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(instances[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] instances = {10, 25, 50, 100, 500};
        double[] prices = {2.46, 2.58, 2.0, 2.25, 3.0};

        System.out.println(interpolate(25, instances, prices));
    }

    static void printMatrix(int[][] mat){
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.println(list);
        }

        System.out.println();
    }




}