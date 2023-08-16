package algo.dp;

import java.util.Arrays;

public class UniquePaths2 {

    public static int uniquePathsBrute(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if(row == m-1 && col == n-1) return 1;
        if(row>=m || col>=n) return 0;
        if(grid[row][col] == 1) return 0;

        int right = uniquePathsBrute(grid, row, col+1);
        int down = uniquePathsBrute(grid, row+1, col);
        return right+down;
    }

    public static int uniquePathsBetter(int[][] grid, int row, int col, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        if(row == m-1 && col == n-1 && grid[m-1][n-1] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(row>=m || col>=n) return 0;
        if(grid[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int right = uniquePathsBetter(grid, row, col+1, dp);
        int down = uniquePathsBetter(grid, row+1, col, dp);
        dp[row][col] = right+down;
        return dp[row][col];
    }

    public static int uniquePathsTabu(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][]dp = new int[m][n];
        for (int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1 && grid[m-1][n-1] == 1) return 0;
                else if(grid[i][j] == 1) dp[i][j] = 0;
                else if(i == m-1 && j == n-1) dp[i][j]=1;
                else {
                    int right = 0;
                    int down = 0;
                    if(j<n-1) right = dp[i][j+1];
                    if(i<m-1) down = dp[i+1][j];
                    dp[i][j]=right+down;
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println("brute : "+uniquePathsBrute(grid, 0,0));


        int[][]dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println("better : "+ uniquePathsBetter(grid, 0,0, dp));
        System.out.println("tabula : "+ uniquePathsTabu(grid));
    }
}
