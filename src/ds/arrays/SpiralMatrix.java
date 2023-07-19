package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    static List<Integer> spiralBrute(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n-1;
        int left = 0, right = m-1;
        while(top <= bottom && left <= right){

            for(int j=left; j<=right;j++){
                list.add(matrix[top][j]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }

                bottom--;
            }
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] mat1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        int[][] mat1 = {{10,11,12,13,14,15}};
//        int[][] mat1 = {{10},{11},{12},{13},{14},{15}};
//        int[][] mat1 = {{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30},{31,32,33,34,35}};
        int[][] mat1 = {{11,12,13,14,15,16},{17,18,19,20,21,22},{23,24,25,26,27,28},{29,30,31,32,33,34},{35,36,37,38,39,40},{41,42,43,44,45,46}};
        printMatrix(mat1);
        List<Integer> res1 = spiralBrute(mat1);
//        List<Integer> list = Arrays.stream(res1).boxed().collect(Collectors.toList());
        System.out.println(res1);

//        System.out.println("Optimal");
//        printMatrix(mat2);
//        int[][] res2 = spiralOptimal(mat2);
//        printMatrix(res2);

    }

    static void printMatrix(int[][] mat){
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.println(list);
        }

        System.out.println();
    }

}
