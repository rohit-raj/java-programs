package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    static boolean checkerBrute(char[][] board, int row, int col){
        int originalRow = row;
        int originalCol = col;

        while (row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = originalRow;
        col = originalCol;

        while (col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = originalRow;
        col = originalCol;

        while (col>=0 && row<board.length){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    static List<String> stringCreator(char[][] board){
        List<String> strings = new ArrayList<>();
        for (char[] chars : board){
            strings.add(new String(chars));
        }
        return strings;
    }

    static void solveBrute(int col, int n, char[][] board, List<List<String>> res){
        if(col == n){
            res.add(stringCreator(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(checkerBrute(board, row, col)){
                board[row][col] = 'Q';
                solveBrute(col+1, n, board, res);
                board[row][col] = '.';
            }
        }
    }

    static List<List<String>> solveNQueensBrute(int n){
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        //Logic
        solveBrute(0, n, board, res);
        return res;
    }

    static void solveOptimal(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] upperLeftDiagonal, int[] lowerLeftDiagonal){
        int n = board.length;
        if(col == n){
            res.add(stringCreator(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(leftRow[row] == 0 && lowerLeftDiagonal[row+col] == 0 && upperLeftDiagonal[n-1+col-row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerLeftDiagonal[row+col] = 1;
                upperLeftDiagonal[n-1+col-row] = 1;
                solveOptimal(col+1, board, res, leftRow, upperLeftDiagonal, lowerLeftDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerLeftDiagonal[row+col] = 0;
                upperLeftDiagonal[n-1+col-row] = 0;
            }

        }

    }

    static List<List<String>> solveNQueensOptimal(int n){
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        //Logic

        int[] leftRow = new int[n];
        int[] upperLeftDiagonal = new int[2*n-1];
        int[] lowerLeftDiagonal = new int[2*n-1];

        solveOptimal(0, board, res, leftRow, upperLeftDiagonal, lowerLeftDiagonal);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueensBrute(n));
        System.out.println(solveNQueensOptimal(n));
    }
}
