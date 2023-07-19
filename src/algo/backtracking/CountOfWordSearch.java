package algo.backtracking;

public class CountOfWordSearch {
    int count = 0;

    public void countWord(char board[][], String word, int m, int n) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    int cnt = backTrack(board, row, col, 0, word);
                    count+=cnt;
                }
            }
        }
    }

    public int backTrack(char[][] board, int row, int col, int index, String word) {
//        leftToRight(board, word, m, n, i, j, 0);
//        topToBottom(board, word, m, n, i, j, 0);
//        rightBottomDiagonal(board, word, m, n, i, j, 0);
        return 0;
    }

    public static void main(String[] args) {
//        char[][] board = {{'s','o','s','o'},{'s','o','o','s'},{'s','s','s','s'}};
        char[][] board = {
                "aa".toCharArray(),
                "aa".toCharArray()
        };
        int m = board.length;
        int n = board[0].length;
        String word = "aa";

        CountOfWordSearch cs = new CountOfWordSearch();
        cs.countWord(board, word, m,n);
        System.out.println("count : "+cs.count);
    }


}

/**
 {'j','o','s','o'},
 {'s','j','o','s'},
 {'s','s','r','s'}
 */