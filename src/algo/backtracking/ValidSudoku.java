package algo.backtracking;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public static boolean isValidSudokuBrute(char[][] board) {
        HashSet <String> seen = new HashSet<>();

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char c = board[i][j];
                if(c != '.')
                    if(!seen.add(c + "row" + i) ||
                    !seen.add(c + "col" + j) ||
                    !seen.add(c + "grid" + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static boolean isValidSudokuOptimal(char[][] board){
        int[] res;

        //row
        for(int i = 0;i < 9;i++){
            res = new int[9];
            for(int j = 0;j < 9;j++){
                if(board[i][j] != '.'){
                    res[board[i][j]-'1']++;
                    if(res[board[i][j]-'1'] > 1)
                        return false;
                }
            }
        }

        //col
        for(int i = 0;i < 9;i++){
            res = new int[9];
            for(int j = 0;j < 9;j++){
                if(board[j][i] != '.'){
                    res[board[j][i]-'1']++;
                    if(res[board[j][i]-'1'] > 1)
                        return false;
                }
            }
        }

        //Grid
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                res = new int[9];
                for(int p = 3*i;p < 3*i+3;p++){
                    for(int q = 3*j;q < 3*j+3;q++){
                        if(board[p][q] != '.'){
                            res[board[p][q]-'1']++;
                            if(res[board[p][q]-'1'] > 1)
                                return false;
                        }

                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board= {
                {'.','.','9','.','.','.','6','.','2'},
                {'1','.','.','7','2','.','.','.','9'},
                {'.','.','3','9','.','.','.','.','.'},
                {'4','.','.','.','3','.','.','6','.'},
                {'.','.','.','5','.','9','.','.','.'},
                {'.','1','.','.','6','.','.','.','3'},
                {'.','.','.','.','.','5','2','.','.'},
                {'5','.','.','.','4','7','.','.','8'},
                {'9','.','8','.','.','.','3','.','.'}
        };
        System.out.println(isValidSudokuBrute(board));
        System.out.println(isValidSudokuOptimal(board));

    }
}
