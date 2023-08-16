package blind75;

import java.util.Arrays;

public class UniquePaths {

    public static int uniquePathsBrute(int m, int n, int row, int col){
        if(row == m-1 && col == n-1) return 1;
        if(row >= m || col >= n) return 0;

        int rightCount = uniquePathsBrute(m, n, row, col+1);
        int downCount = uniquePathsBrute(m,n,row+1, col);
        return downCount+rightCount;
    }

    public static int uniquePathsBetter(int m, int n, int row, int col, int[][]dp){
        if(row == m-1 && col == n-1) return 1;
        if(row >= m || col >= n) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int rightCount = uniquePathsBetter(m, n, row, col+1, dp);
        int downCount = uniquePathsBetter(m,n,row+1, col, dp);
        dp[row][col] =  downCount+rightCount;
        return dp[row][col];
    }

    public static int uniquePathsTabulation(int m, int n){
        int[][] dp = new int[m][n];

        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 && j==n-1)
                    dp[i][j]=1;
                else {
                    int rightCount = 0;
                    int downCount = 0;
                    if(j<n-1) rightCount = dp[i][j+1];
                    if(i<m-1) downCount = dp[i+1][j];
                    dp[i][j] = rightCount + downCount;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println("uniquePathsBrute : "+ uniquePathsBrute(m,n, 0,0));
        System.out.println("uniquePathsBetter : "+ uniquePathsBetter(m,n, 0,0, dp));
        System.out.println("uniquePathsBetter : "+ uniquePathsTabulation(m,n));

    }
}
