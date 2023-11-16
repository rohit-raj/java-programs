package blind75;

import ds.trie.Trie;
import ds.trie.TrieNode;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class DesignAddAndSearch {
    private final TrieNode root;

    public DesignAddAndSearch(){
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.childNode[index] == null){
                curr.childNode[index] = new TrieNode();
            }
            curr = curr.childNode[index];
        }
        curr.isEnd = true;
    }

    public boolean searchPrefix(TrieNode root, String word, int wordIndex){
        TrieNode node = root;
        if (node == null) return false;
        for (int i = wordIndex; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (word.charAt(i) == '.') {
                for (int j = 0; j < node.childNode.length; j++) {
                    if (searchPrefix(node.childNode[j], word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            if (node.childNode[idx] == null) return false;
            node = node.childNode[idx];
        }
        return node.isEnd;
    }

    public boolean search(String word){
        return searchPrefix(root, word,0);
    }


    public static void main(String[] args) {
        ds.trie.Trie trie = new Trie();
//        String[] words = { "the", "awesome", "there", "answer", "any", "by", "bye", "their" };

        String[] words = { "bad", "dad", "mad" };
        DesignAddAndSearch daas = new DesignAddAndSearch();
        for (String word : words) {
            daas.addWord(word);
        }

        trie.printTrieTree(daas.root, "", true);
        System.out.println("=============================================");

        System.out.println("wordDictionary.search(pad); "+ daas.search("pad"));
        System.out.println("wordDictionary.search(bad); "+ daas.search("bad"));
        System.out.println("wordDictionary.search(.ad); "+ daas.search(".ad"));
        System.out.println("wordDictionary.search(b..); "+ daas.search("b.."));

    }
}
