package algo.backtracking;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 9ms
 */
public class SudokuSolverOptimal {
    boolean[][] Row;
    boolean[][] Col;
    boolean[][] Block;
    List<Point> uncertain;

    public void print(char[][] board) {
        for (char[] row : board) {
            for (Character c : row)
                System.out.print(c);
            System.out.println();
        }
        System.out.println("===========");
    }

    public void set3Cond(int i, int j, int x, boolean val) {
        Row[i][x] = val;
        Col[j][x] = val;
        int bidx = (i / 3) * 3 + j / 3;
        Block[bidx][x] = val;
    }

    public void setup(char[][] board) {
        uncertain = new ArrayList<>();
        Row = new boolean[9][9];
        Col = new boolean[9][9];
        Block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    uncertain.add(new Point(i, j));
                } else {
                    int x = (c - '0') % 9;
                    set3Cond(i, j, x, true);
                }
            }
        }
    }

    public boolean solve(char[][] board) {
        if (uncertain.isEmpty())
            return true;

        Point point = uncertain.get(uncertain.size() - 1);
        int i = point.x;
        int j = point.y;

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(i, j, c)) {
                board[i][j] = c;
                uncertain.remove(uncertain.size() - 1);

                int x = (c - '0') % 9;
                set3Cond(i, j, x, true);

                if (solve(board))
                    return true;

                board[i][j] = '.'; // trace back
                uncertain.add(new Point(i, j));
                set3Cond(i, j, x, false);
            }
        }
        return false;
    }

    public boolean isValid(int row, int col, char c) {
        int x = (c - '0') % 9;
        return !Row[row][x] && !Col[col][x] && !Block[(row / 3) * 3 + col / 3][x];
    }

    public void solveSudoku(char[][] board) {
        setup(board);
        solve(board);
    }

    public static void main(String[] args) {
        SudokuSolverOptimal ss = new SudokuSolverOptimal();
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        ss.solveSudoku(board);

        ss.print(board);
    }
}

/**__ ___ ___ ___ ___ ___ ___ ___ ___ __
 * |_9_|_5_|_7_|_6_|_1_|_3_|_2_|_8_|_4_|
 * |_4_|_8_|_3_|_2_|_5_|_7_|_1_|_9_|_6_|
 * |_6_|_1_|_2_|_8_|_4_|_9_|_5_|_3_|_7_|
 * |_1_|_7_|_8_|_3_|_6_|_4_|_9_|_5_|_2_|
 * |_5_|_2_|_4_|_9_|_7_|_1_|_3_|_6_|_8_|
 * |_3_|_6_|_9_|_5_|_2_|_8_|_7_|_4_|_1_|
 * |_8_|_4_|_5_|_7_|_9_|_2_|_6_|_1_|_3_|
 * |_2_|_9_|_1_|_4_|_3_|_6_|_8_|_7_|_5_|
 * |_7_|_3_|_6_|_1_|_8_|_5_|_4_|_2_|_9_|
 */
