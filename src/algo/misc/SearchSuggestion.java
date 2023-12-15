package algo.misc;

import ds.trie.Trie;
import ds.trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class SearchSuggestion {
    public static int lower_bound(String[] products, int start, String word){
        int i=start, j=products.length-1;
        while (i<=j){
            int mid = i+(j-i)/2;
            if(products[mid].compareTo(word) >= 0){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return i;
    }
    public static List<List<String>> suggestedProductsBinary(String[] products, String searchWord) {
        Arrays.sort(products);
        System.out.println("products : "+ Arrays.asList(products));

        List<List<String>> result = new ArrayList<>();
        int start = 0,bsStart = 0, n=products.length;
        String prefix = new String();

        for (char c : searchWord.toCharArray()){
            prefix+=c;

            start = lower_bound(products, bsStart, prefix);

            System.out.println("prefix : " + prefix + " : start : "+ start);

            result.add(new ArrayList<>());

            for (int i=start;i<Math.min(start+3, n);i++){
                if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)){
                    break;
                }
                result.get(result.size()-1).add(products[i]);
            }
            bsStart = Math.abs(start);
        }
        return result;
    }


    public static List<List<String>> suggestedProductsLoop(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        for (int i=0;i<searchWord.length();i++){
            result.add(new ArrayList<>());
        }

        int count = 0;

        for(int i=0;i<products.length;i++){
            if(count == searchWord.length() * 3)
                break;

            int len = Math.min(searchWord.length(), products[i].length());

            for(int j=0;j<len;j++){
                if(products[i].charAt(j) == searchWord.charAt(j)){
                    List<String> list = result.get(j);
                    if(list.size() < 3){
                        list.add(products[i]);
                        count++;
                    }
                } else {
                    break;
                }
            }
        }

        return result;
    }



    public static void insertToTrie(TrieNode root, String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
            node.commonPrefix++;
        }
        node.setEnd();
    }

    public static List<String> searchPrefix(TrieNode node, String word, List<String> result) {
        if(result.size() == 3){
            return result;
        }
        if(node.isEnd()){
            result.add(word);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) {
                searchPrefix(node.get(c), word+c, result);
            }
        }
        return result;
    }

    public static List<String> getWordsStartingWith(TrieNode root, String word){
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
        searchPrefix(node, word, ans);
        return ans;
    }


    public static List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        TrieNode root = new TrieNode();
        Trie trie = new Trie();
        for (String product : products){
            insertToTrie(root, product);
        }

//        trie.printTrieTree(root);

        String prefix = "";
        for(char c : searchWord.toCharArray()){
            prefix+=c;
            result.add(getWordsStartingWith(root, prefix));
        }
//        System.out.println("count : "+ getWordsStartingWith(root, "mo"));
        return result;
    }

    public static void main(String[] args) {
        String [] products = {"havana","car","camera","cart","cag","cozy","camp"};
        String searchWord = "car";

        System.out.println("suggestedBinary : "+ suggestedProductsTrie(products, searchWord));
//        System.out.println("suggestedBinary : "+ suggestedProductsLoop(products, searchWord));
    }
}
