package ds.trie;

public class TrieNode {
    public TrieNode[] childNode;
    int wordCount=0;
    final int R = 26;
    public boolean isEnd=false;
    public int endsWith;
    public int commonPrefix;
    public String word;

    public TrieNode() {
        childNode = new TrieNode[R];
        isEnd=false;
        endsWith = 0;
        commonPrefix = 0;
        word = "";
    }

    public boolean containsKey(char ch) {
        return childNode[ch -'a'] != null;
    }

    public TrieNode get(char ch) {
        return childNode[ch -'a'];
    }

    public void put(char ch, TrieNode node) {
        childNode[ch -'a'] = node;
    }

    public void delete(char ch){
        childNode[ch-'a'] = null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getWordCount(){
        return wordCount;
    }

    public void incrementWordCount(){
        wordCount+=1;
    }

    public void setWord(String word){
        this.word = word;
    }
}