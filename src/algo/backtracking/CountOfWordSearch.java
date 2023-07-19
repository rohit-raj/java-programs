package algo.backtracking;

public class CountOfWordSearch {
    int count = 0;

    public void countWord(char[][] board, String word) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    backTrack(board, row, col, word);
                }
            }
        }
    }

    public void backTrack(char[][] board, int row, int col, String word) {
        leftToRight(board, word, row, col, 0);
        topToBottom(board, word, row, col, 0);
        rightBottomDiagonal(board, word, row, col, 0);
    }

    public void leftToRight(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){
            count++;
            return;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx))
            return;

        char ch = board[row][col];
        board[row][col]='_';

        leftToRight(board, word, row, col+1, idx+1);
        board[row][col] = ch;
    }

    public void topToBottom(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){
            count++;
            return;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx))
            return;

        char ch = board[row][col];
        board[row][col]='_';

        topToBottom(board, word, row+1, col, idx+1);//only right
        board[row][col] = ch;
    }

    public void rightBottomDiagonal(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){
            count++;
            return;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx))
            return;


        char ch = board[row][col];
        board[row][col]='_';

        rightBottomDiagonal(board, word, row+1, col+1, idx+1);//only right
        board[row][col] = ch;
    }

    public static void main(String[] args) {
//        char[][] board = {{'s','o','s','o'},{'s','o','o','s'},{'s','s','s','s'}};
        char[][] board = {
                "aa".toCharArray(),
                "aa".toCharArray()
        };

        String word = "aa";

        CountOfWordSearch cs = new CountOfWordSearch();
        cs.countWord(board, word);
        System.out.println("count : "+cs.count);
    }


}

/**
 {'j','o','s','o'},
 {'s','j','o','s'},
 {'s','s','r','s'}
 */