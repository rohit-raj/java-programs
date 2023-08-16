package ds.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {
    private final TrieNode root;
    private List<String> ans;
    WordSearch2(){
        root = new TrieNode();
    }

    public void insertWordsToTrie(String[] words){
        for (String word : words){
            TrieNode node = root;
            for (char ch : word.toCharArray()){
                if(!node.containsKey(ch)){
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.word = word;
        }
    }

    public void checker(char[][] board){
        ans = new ArrayList<>();
        for (int row=0;row<board.length;row++) {
            for (int col=0;col<board[row].length;col++) {
                if (root.containsKey(board[row][col])) {
                    backtracking(board, row, col, root);
                }
            }
        }
    }

    public void backtracking(char[][] board, int row, int col, TrieNode root){
        if(row<0 || col<0 || row >=board.length || col >= board[0].length) return;

        char ch = board[row][col];
        if (ch == '_' || root.get(ch) == null) return;

        root = root.get(ch);

        if(root!=null && root.word!=null){
            ans.add(root.word);
            root.word=null;
        }

        board[row][col] = '_';

        backtracking(board, row, col+1, root);
        backtracking(board, row+1, col, root);
        backtracking(board, row-1, col, root);
        backtracking(board, row, col-1, root);

        board[row][col] = ch;
        if (root.get(ch) == null) {
            root.delete(ch);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        insertWordsToTrie(words);
        checker(board);
        return ans;
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

        WordSearch2 ws = new WordSearch2();


        Trie trie = new Trie();
        ws.findWords(board, words);

        List<String> answer = ws.findWords(board, words);

        System.out.println("answer : "+ answer);
//        ws.trie.printTrieTree(ws.root);

    }
}
