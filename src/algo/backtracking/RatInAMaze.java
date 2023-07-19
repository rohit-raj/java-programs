package algo.backtracking;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 */
public class RatInAMaze {

    static void solve(int i, int j, int[][] inp, boolean[][] visited, int[] di, int[] dj, String moves, ArrayList<String> ans){
        int n = inp.length;
        if(i==n-1 &&j==n-1){
            ans.add(moves);
            return;
        }

        String dir = "DLRU";
        for(int ind=0;ind<4;ind++){
            int nextI = i+di[ind];
            int nextJ = j+dj[ind];

            if(nextI>=0 && nextJ>=0 && nextI<n && nextJ<n && !visited[nextI][nextJ] && inp[nextI][nextJ]==1){
                visited[i][j] = true;
                solve(nextI, nextJ, inp, visited, di, dj, moves+dir.charAt(ind), ans);
                visited[i][j] = false;
            }
        }
    }
    static ArrayList<String> findPath(int[][] inp, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();

        boolean[][] visited = new boolean[n][n]; // by default initialisation is false

        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};


        if(inp[0][0] == 1)
            solve(0,0, inp, visited, di, dj, "", ans);

        return ans;
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] inp = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        ArrayList <String> res = findPath(inp, n);

        System.out.println("findPath : "+res);
    }
}
