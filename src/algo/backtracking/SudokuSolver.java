package algo.backtracking;

/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * 20ms
 */
public class SudokuSolver {

    public static boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0;i<9;i++){
            if(board[i][col] == c){
                return false;
            }
            if(board[row][i] == c){
                return false;
            }

            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){
                return false;
            }
        }
        return true;
    }
    public static boolean solveSudoku(char[][] board){
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if(board[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board, i, j, c)){
                            board[i][j]=c;
                            if(solveSudoku(board))return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
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
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
/**
 *                 {'.','.','9','.','.','.','6','.','2'},
 *                 {'1','.','.','7','2','.','.','.','9'},
 *                 {'.','.','3','9','.','.','.','.','.'},
 *                 {'4','.','.','.','3','.','.','6','.'},
 *                 {'.','.','.','5','.','9','.','.','.'},
 *                 {'.','1','.','.','6','.','.','.','3'},
 *                 {'.','.','.','.','.','5','2','.','.'},
 *                 {'5','.','.','.','4','7','.','.','8'},
 *                 {'9','.','8','.','.','.','3','.','.'}
 */
