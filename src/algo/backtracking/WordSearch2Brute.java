package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2Brute {
    public List<String> foundWords;
    int count = 0;

    public boolean backTrack(char[][] board, int row, int col, int index, String word) {
        if(index == word.length()) {
            foundWords.add(word);
            count++;
            return true;
        }

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
                if(board[row][col] == word.charAt(0))
                     backTrack(board, row, col, 0, word);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                "oaan".toCharArray(),
                "etae".toCharArray(),
                "ihkr".toCharArray(),
                "iflv".toCharArray()
        };
        String[] words = {"oath","pea","eat","rain"};

        int m = board.length;
        int n = board[0].length;
        System.out.println("============================================");
        WordSearch2Brute ws = new WordSearch2Brute();
        ws.foundWords = new ArrayList<>();
        for (String word : words) {
            System.out.println("search word " + word + " in board");

            boolean res = ws.exist(board, word);
//        System.out.println("res : " + res);
        }
        System.out.println("words : "+ ws.foundWords);
        System.out.println("words : "+ ws.count);

    }
}
