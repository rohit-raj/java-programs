package algo.misc;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {
    private final int capacity;
    private int minFreq;
    private final HashMap<Integer, Pair<Integer, Integer>> cache;
    private final HashMap<Integer, LinkedHashSet<Integer>> frequencies;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        this.minFreq = 0;
    }

    private void insert(int key, int value, int frequency){
        cache.put(key, new Pair<>(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }

    public int get(int key) {
        Pair<Integer, Integer> pair = cache.get(key);
        if(pair == null){
            return -1;
        }

        int frequency = pair.getKey();
        Set<Integer> keys = frequencies.get(frequency);

        keys.remove(key);

        if(keys.isEmpty()){
            frequencies.remove(frequency);
            if(minFreq == frequency){
                ++minFreq;
            }
        }

        int value = pair.getValue();
        insert(key, value, frequency+1);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0){
            return;
        }

        Pair<Integer, Integer> pair = cache.get(key);

        if(pair != null){
            cache.put(key, new Pair<>(pair.getKey(), value));
            get(key);
            return;
        }

        if(capacity == cache.size()){
            Set<Integer> keys = frequencies.get(minFreq);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencies.remove(minFreq);
            }
        }
        minFreq = 1;
        insert(key, value, 1);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);      // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);      // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));         // return 1
                            // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);      // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                            // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));         // return -1 (not found)
        System.out.println(lfu.get(3));         // return 3
                            // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);      // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                            // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));         // return -1 (not found)
        System.out.println(lfu.get(3));         // return 3
                            // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));         // return 4
                            // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
