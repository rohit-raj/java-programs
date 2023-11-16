package blind75;


import ds.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    public void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
            node.commonPrefix++;
        }
        node.endsWith++;
        node.setEnd();
        root.incrementWordCount();
    }

    public TrieNode searchPrefix(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(TrieNode root, String word){
        TrieNode node = searchPrefix(root, word);
        return node!=null && node.isEnd();
    }

    public boolean startsWith(TrieNode root, String word) {
        TrieNode node = searchPrefix(root, word);
        return node!=null;
    }

    public int getTotalWords(TrieNode root){
        return root.getWordCount();
    }

    public void printTrieTree(TrieNode root) {
        printTrieTree(root, "", true);
    }
    public void printTrieTree(TrieNode root, String prefix, boolean isLast) {
        System.out.print(prefix);
        System.out.print(isLast ? "└── " : "├── ");

        if (root.isEnd()) {
            System.out.println("(end)");
            isLast = true;
        } else {
            System.out.println();
        }

        for (int i = 0; i < 26; i++) {
            TrieNode child = root.childNode[i];
            if (child != null) {
                String newPrefix = prefix + (isLast ? "    " : "│   ");
                char ch = (char) ('a' + i);
                printTrieTree(child, newPrefix+ch, false);
            }
        }
    }

    public int countWordsStartingWith (TrieNode root, String word){
        TrieNode node = searchPrefix(root, word);
        return node!=null ? node.commonPrefix : 0;
    }

    public int countWordsEqualTo(TrieNode root, String word){
        TrieNode node = searchPrefix(root, word);
        return node!=null && node.isEnd() ? node.endsWith : 0;
    }

    public List<String> getAllWords(TrieNode node, String word, List<String> result){
        if(node.isEnd()){
            result.add(word);
        }
        for(char c='a';c<='z';c++){
            if(node.containsKey(c)){
                getAllWords(node.get(c), word+c, result);
            }
        }
        return result;
    }

    public List<String> wordsStartingWith(TrieNode root, String word){
        List<String> ans = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return ans;
            }
        }
        getAllWords(node, word, ans);
        return ans;
    }

    public void delete(TrieNode root, String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if (node.containsKey(ch)){
                TrieNode curr= node;
                node = node.get(ch);
                if(node.commonPrefix > 1) {
                    node.commonPrefix--;
                } else {
                    curr.delete(ch);
                }

                if(node.endsWith > 0) node.endsWith--;
            } else {
                return;
            }
        }
    }

    public void erase(TrieNode root, String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if (node.containsKey(ch)){
                node = node.get(ch);
                node.commonPrefix--;
            } else {
                return;
            }
        }
        node.endsWith--;
    }

    public static void main(String[] args) {
        // words to be inserted in Trie
//        String[] words = { "the", "any", "there","answer","answer", "by", "bye", "their" };
//        String[] words = { "coding", "ninja"};
//        TrieNode root = new TrieNode();

//        System.out.println("===================================");
//        Trie trie = new Trie();
//         //Insert
//        for (String word : words) {
//            trie.insert(root, word);
//        }

//        trie.printTrieTree(root, "", true);
        Trie T =new Trie();
        TrieNode root = new TrieNode();
        T.insert(root,"coding");
        T.insert(root,"ninja");
        T.insert(root,"nine");
        String word1 = "coding";
        System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(root, word1));
        String word2 = "nin";
        System.out.println("Count Words Equal to "+word2+" "+T.wordsStartingWith(root, word2));
        T.erase(root, "coding");
        T.insert(root,"samsung");
        T.insert(root,"samsung");
        T.insert(root,"vivo");
        T.erase(root, "vivo");

        String word3 = "samsung";
        System.out.println("Count Words Starting With "+word3+" "+T.startsWith(root, word3));
        String word4 = "vi";
        System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith(root,word4));
    }
}
