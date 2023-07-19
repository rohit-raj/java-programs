package ds.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateMatrix {

    static int[][] rotateBrute(int[][] mat){
        int n = mat.length; // row
        int m = mat[0].length; // col

        int[][] temp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[j][n-i-1] = mat[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = temp[i][j];
            }
        }
        return mat;
    }


    static int[][] rotateOptimal(int[][] mat){
        int n = mat.length; // row
        int m = mat[0].length; // col

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
//        printMatrix(mat);

        for(int i=0;i<n;i++){
            int k = n-1;
            for(int j=0;j<m/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k]=temp;
                k--;
            }
        }
        return mat;
    }

    static int[][] rotateAnotherWay(int[][] mat){
        int n = mat.length;

        for (int layer=0;layer<n/2;++layer){
            int first = layer;
            int last = n-1-layer;

            for (int i=first;i<last;++i){
                int offset = i-first;

                int top = mat[first][i]; // saving top

                mat[first][i] = mat[last-offset][first]; // left -> top

                mat[last-offset][first] = mat[last][last-offset]; // bottom -> left

                mat[last][last-offset] = mat[i][last]; // right -> bottom

                mat[i][last] = top; // top -> right
            }
        }
        return mat;
    }

    public static void main(String[] args) {
//        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mat2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mat3 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] mat4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mat5 = {{1,2,3},{5,6,7},{9,10,11}};
        System.out.println("Brute");
        printMatrix(mat1);
        int[][] res1 = rotateBrute(mat1);
        printMatrix(res1);

        System.out.println("Optimal");
//        printMatrix(mat2);
        int[][] res2 = rotateOptimal(res1);
        printMatrix(res2);

        System.out.println("Another");
//        printMatrix(mat5);
        int[][] res3 = rotateAnotherWay(res2);
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
