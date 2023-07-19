package ds.arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrix2 {

    static boolean searchMatrixBrute(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col]==target){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20;

        System.out.println("searchMatrixBrute :: "+searchMatrixBrute(matrix, target));
        System.out.println("searchMatrixOptimal :: "+searchMatrixOptimal(matrix, target));
    }
}
