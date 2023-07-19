package ds.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a rectangular matrix of Engish lowercase letters board and a string word
 * your task is to find the number of occurrences if word in the
 * row
 * column and
 * diagonals of board
 *
 * board = [
 * ['s','o','s','o'],
 * ['s','o','o','s'],
 * ['s','s','s','s']
 * ]
 *
 * and word = "sos", the output should be 3
 * ['s','o','s','_'],
 * ['_','o','o','_'],
 * ['_','_','s','_']
 *
 *
 * board = [
 * ['a','a'],
 * ['a','a']
 * ]
 * and word = "aa", the output should be 5
 *
 * solved in /Users/rohit/IdeaProjects/java-programs/src/algo/strings/CountOfWordSearch.java
 *
 */
public class WordSearch3 {
    public boolean[][] visited;
    public List<String> foundWords;
    int totalCount = 0;
    int leftToRight = 0;
    int rightToLeft = 0;
    int topToBottom = 0;
    int bottomToTop = 0;
    int rightAndDown = 0;
    int rightAndUp = 0;
    int leftAndBottom = 0;
    int leftAndUp = 0;
    int rightBottomDiagonal = 0;
    int rightTopDiagonal = 0;
    int leftBottomDiagonal = 0;
    int leftTopDiagonal = 0;


    public boolean searchWord(char[][] board, String word, int m, int n){
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                if(board[i][j] == word.charAt(0)){
                    searchWord(board, word, m, n, i, j, 0);
                }
            }
        }
        return false;
    }

    public void searchWord(char[][] board, String word, int m, int n, int i, int j, int idx){
        leftToRight(board, word, m, n, i, j, 0);
        rightToLeft(board, word, m, n, i, j, 0);
        topToBottom(board, word, m, n, i, j, 0);
        bottomToTop(board, word, m, n, i, j, 0);
        rightAndBottom(board, word, m, n, i, j, 0);
        rightAndUp(board, word, m, n, i, j, 0);
        leftAndBottom(board, word, m, n, i, j, 0);
        leftAndUp(board, word, m, n, i, j, 0);
        rightBottomDiagonal(board, word, m, n, i, j, 0);
        rightTopDiagonal(board, word, m, n, i, j, 0);
        leftBottomDiagonal(board, word, m, n, i, j, 0);
        leftTopDiagonal(board, word, m, n, i, j, 0);
    }

    public boolean basicTestFailed(char[][] board, String word, int m, int n, int i, int j, int idx){
        if (i<0 || j<0 || i >= m || j >= n){
            return true;
        }

        if(visited[i][j] || board[i][j] != word.charAt(idx)){
            return true;
        }
        return false;
    }

    public void leftToRight(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            leftToRight++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        leftToRight(board, word, m, n, i, j+1, idx+1);
        visited[i][j] = false;
    }

    public void rightToLeft(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            rightToLeft++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        rightToLeft(board, word, m, n, i, j-1, idx+1);//only right
        visited[i][j] = false;
    }

    public void topToBottom(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            topToBottom++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        topToBottom(board, word, m, n, i+1, j, idx+1);//only right
        visited[i][j] = false;
    }

    public void bottomToTop(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            bottomToTop++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        bottomToTop(board, word, m, n, i-1, j, idx+1);//only right
        visited[i][j] = false;
    }

    public void rightAndBottom(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            rightAndDown++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        rightAndBottom(board, word, m, n, i, j+1, idx+1);//only right
        rightAndBottom(board, word, m, n, i+1, j, idx+1);
        visited[i][j] = false;
    }

    public void rightAndUp(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            rightAndUp++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        rightAndUp(board, word, m, n, i, j+1, idx+1);//only right
        rightAndUp(board, word, m, n, i-1, j, idx+1);
        visited[i][j] = false;
    }

    public void leftAndBottom(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            leftAndBottom++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        leftAndBottom(board, word, m, n, i, j-1, idx+1);//only right
        leftAndBottom(board, word, m, n, i+1, j, idx+1);
        visited[i][j] = false;
    }

    public void leftAndUp(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            leftAndUp++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        leftAndUp(board, word, m, n, i, j-1, idx+1);//only right
        leftAndUp(board, word, m, n, i-1, j, idx+1);
        visited[i][j] = false;
    }

    public void rightBottomDiagonal(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            rightBottomDiagonal++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        rightBottomDiagonal(board, word, m, n, i+1, j+1, idx+1);//only right
        visited[i][j] = false;
    }

    public void rightTopDiagonal(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            rightTopDiagonal++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        rightTopDiagonal(board, word, m, n, i-1, j+1, idx+1);//only right
        visited[i][j] = false;
    }

    public void leftBottomDiagonal(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            leftBottomDiagonal++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        leftBottomDiagonal(board, word, m, n, i+1, j-1, idx+1);//only right
        visited[i][j] = false;
    }

    public void leftTopDiagonal(char[][] board, String word, int m, int n, int i, int j, int idx){
        if(basicTestFailed(board, word, m, n, i, j, idx)) return;

        if(idx+1 >= word.length()){
            foundWords.add(word);
            leftTopDiagonal++;
            totalCount++;
            return;
        }

        visited[i][j] = true;

        leftTopDiagonal(board, word, m, n, i-1, j-1, idx+1);//only right
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {
            "aa".toCharArray(),
            "aa".toCharArray(),
//            "ssss".toCharArray()
        };
        String word = "aa";

        int m = board.length;
        int n = board[0].length;
        System.out.println("search word "+word+" in board");
        System.out.println("============================================");
        WordSearch3 ws = new WordSearch3();
        ws.visited = new boolean[m][n];
        ws.foundWords = new ArrayList<>();

        boolean res = ws.searchWord(board, word, m, n);
        System.out.println("totalCount : "+ ws.totalCount);
        System.out.println("leftToRight : "+ ws.leftToRight);
        System.out.println("rightToLeft : "+ ws.rightToLeft);
        System.out.println("topToBottom : "+ ws.topToBottom);
        System.out.println("bottomToTop   : "+ ws.bottomToTop);
        System.out.println("leftToRightAndDown : "+ ws.rightAndDown);
        System.out.println("leftToRightAndUp : "+ ws.rightAndUp);
        System.out.println("rightToLeftAndDown : "+ ws.leftAndBottom);
        System.out.println("rightToLeftAndUp : "+ ws.leftAndUp);
        System.out.println("rightBottomDiagonal : "+ ws.rightBottomDiagonal);
        System.out.println("rightTopDiagonal : "+ ws.rightTopDiagonal);
        System.out.println("leftBottomDiagonal : "+ ws.leftBottomDiagonal);
        System.out.println("leftTopDiagonal : "+ ws.leftTopDiagonal);

    }
}
