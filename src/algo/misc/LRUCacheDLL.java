package algo.misc;

import ds.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCacheDLL {
    int capacity;
    Map<Integer, Node> dict;
    Node head;
    Node tail;
    public LRUCacheDLL(int capacity) {
        this.capacity = capacity;
        dict = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(!dict.containsKey(key)) return -1;

        Node node = dict.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)){
            Node oldNode = dict.get(key);
            remove(oldNode);
        }

        Node node = new Node(key, value);
        dict.put(key, node);
        add(node);

        if(dict.size() > capacity){
            Node nodeToDelete = head.right;
            remove(nodeToDelete);
            dict.remove(nodeToDelete.key);
        }
    }

    public void add(Node node){
        Node prev = tail.left;
        prev.right = node;
        tail.left = node;
        node.left = prev;
        node.right = tail;
    }

    public void remove(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
    }

    public void printFromHead(Node head){
        System.out.println();
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LRUCacheDLL lRUCache = new LRUCacheDLL(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.printFromHead(lRUCache.head);
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.printFromHead(lRUCache.head);
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
