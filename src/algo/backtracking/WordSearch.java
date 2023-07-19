package algo.backtracking;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public boolean backTrack(char[][] board, int row, int col, int index, String word) {
        if(index == word.length())
            return true;

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;

        char current = board[row][col];
        board[row][col] = '-';
        boolean found = backTrack(board, row + 1, col, index+1, word) ||
                backTrack(board, row, col + 1, index+1, word) ||
                backTrack(board, row - 1, col, index+1, word) ||
                backTrack(board, row, col - 1, index+1, word);

        board[row][col] = current;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == word.charAt(0) && backTrack(board, row, col, 0, word))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
        };

        String word = "ABCCSE";

        System.out.println("exist : "+ws.exist(board, word));

    }
}
