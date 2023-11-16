package ds.arrays;

/**
 *
 */
public class Search2DMatrix {

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
        int m = matrix.length;
        int n = matrix[0].length;

        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println("searchMatrixBrute :: "+searchMatrixBrute(matrix, target));
        System.out.println("searchMatrixOptimal :: "+searchMatrixOptimal(matrix, target));
    }
}
