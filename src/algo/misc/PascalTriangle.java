package algo.misc;

//https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

    static int printElementAtPos(int n, int r){
        //nCr
        int totalNumerator = 1;
        int totalDenominator = 1;
        for(int i=0;i<r;i++){
            totalNumerator = totalNumerator * (n-i);
            totalDenominator = totalDenominator * (r-i);
        }

        return totalNumerator/totalDenominator;
    }

    static int[] printAllElementsBrute(int n){
        //int at depth =0, elements = 1
        // at a given depth element count is depth+1
        int[]res = new int[n];
        for(int i=0;i<n;i++){
//            System.out.println("value at "+ n + " and "+ i);
            res[i] = printElementAtPos(n-1, i);
        }
        return res;
    }

    static int[][] printPascalTriangleBrute(int n){
        int[][] res = new int[n][];
        for(int i=0;i<n;i++){
//            System.out.println("value at "+ n + " and "+ i);
            int[] ans = printAllElementsBrute(i+1);
            res[i] = ans;
        }
        return res;
    }

    static List<Integer> printAllElementsOptimal(int n){
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        int r = n;
        for(int i=1;i<n;i++){
            ans = ans * (n-i)/i;
            res.add(ans);
        }
        return res;
    }

    static List<List<Integer>> printPascalTriangleOptimal(int n){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> ans = printAllElementsOptimal(i);
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5; //depth of triangle
        int r = 3; // position from left at a given depth

        System.out.println("value at "+ n + " and "+ r+ " is : "+ printElementAtPos(n-1,r-1));

        //print all elements at a given level
        int[] res = printAllElementsBrute(n);
        printArray(res);

        List<Integer> res2 = printAllElementsOptimal(n);
        System.out.println("printAllElementsOptimal :  "+res2);

        //print whole triangle till given level

        int[][] res3 = printPascalTriangleBrute(n);
        printMatrix(res3);

        List<List<Integer>> res4 = printPascalTriangleOptimal(n);
        System.out.println("printPascalTriangleOptimal "+res4);
    }

    static void printArray (int[] array) {
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }

    static void printMatrix(int[][] mat){
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.println(list);
        }

        System.out.println();
    }

}
