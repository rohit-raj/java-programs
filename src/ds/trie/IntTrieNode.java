package ds.trie;

//Bitwise trie node
public class IntTrieNode {
    IntTrieNode[] childNode;

    public IntTrieNode(){
        childNode = new IntTrieNode[2];
    }

    boolean containsKey(int ind){
        return childNode[ind]!=null;
    }

    IntTrieNode get(int ind){
        return childNode[ind];
    }

    void put(int ind, IntTrieNode node){
        childNode[ind] = node;
    }
}
