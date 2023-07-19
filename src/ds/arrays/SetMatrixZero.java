package ds.arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SetMatrixZero {

    static void markRow(int[][] mat, int i, int m){
        for(int j=0;j<m;j++){
            if(mat[i][j] !=0){
                mat[i][j]=-1;
            }
        }
    }

    static void markCol(int[][] mat, int j, int n){
        for(int i=0;i<n;i++){
            if(mat[i][j] != 0){
                mat[i][j]=-1;
            }
        }
    }


    // complexity : m*n *(m + n) + m*n ~ n^3
    // space : O(1)
    static int[][] setZerosBrute(int[][] mat){
        int n = mat.length;//rows
        int m = mat[0].length;//columns

        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (mat[i][j] == 0) {
                    //set -1 in i row and j column
                    markRow(mat,i, m);
                    markCol(mat, j, n);
                }
            }
        }

        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (mat[i][j] == -1) {
                    //set zeros in i row and j column
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    // complexity : m*n + m*n ~ n^2
    // space : O(m)+O(n)
    static int[][] setZerosBetter(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[] rowArray = new int[n];
        int[] colArray = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    rowArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((rowArray[i] == 1) || (colArray[j] == 1)){
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }

    // complexity : m*n + m*n + m + n
    // space : O(1)
    static int[][] setZerosOptimal(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

//        int[] rowArray = new int[n]; // mat[...][0]
//        int[] colArray = new int[m]; // mat[0][...]

        int col0 = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;//setting row as 0
                    if(j !=0)
                        mat[0][j]=0;
                    else
                        col0 = 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j] !=0) {
                    if ((mat[i][0] == 0) || (mat[0][j] == 0)) {
                        mat[i][j] = 0;
                    }
                }
            }
        }

//        System.out.println(" "+col0);
//        printMatrix(mat);

        if(mat[0][0] == 0){
            for(int j=0;j<m;j++){
                mat[0][j] = 0;
            }
        }
//        printMatrix(mat);

        if(col0 == 0){
            for(int i=0;i<m;i++){
                mat[i][0] = 0;
            }
        }
//        printMatrix(mat);
        return mat;
    }

    public static void main(String[] args) {
//        int[][] mat1 = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int[][] mat1 = {{1,1,1,0},{1,0,1,1},{1,1,0,1},{1,1,1,1}};
        int[][] mat2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        int[][] mat3 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Brute");
        printMatrix(mat1);
        int[][] res1 = setZerosBrute(mat1);
        printMatrix(res1);

        System.out.println("Better");
        printMatrix(mat2);
        int[][] res2 = setZerosBetter(mat2);
        printMatrix(res2);

        System.out.println("Optimal");
        printMatrix(mat1);
        int[][] res3 = setZerosOptimal(mat1);
        printMatrix(res3);

    }

    static void printMatrix(int[][] mat){
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.println(list);
        }

        System.out.println();
    }

    static void printArray (String message, int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(message+list);
    }
}
