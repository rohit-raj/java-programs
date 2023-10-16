package algo.misc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore {

    HashMap<String, ArrayList<Pair<Integer, String>>> store;

    public TimeBasedKeyValueStore(){
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        ArrayList<Pair<Integer, String>> entry = store.getOrDefault(key, new ArrayList<>());
//        System.out.println("entry size for "+key + " : is : "+ entry.size());
        if(entry.size() > 0){
            return binarySearch(entry, 0, entry.size()-1, timestamp);
        }
        return "";
    }

    public String binarySearch(ArrayList<Pair<Integer, String>> entry, int low, int high, int target){
        while (low <= high){
            int mid = low + (high-low)/2;
//            System.out.println("mid : "+ mid+ " : low : "+low);
            if(entry.get(mid).getKey() < target){
                low = mid+1;
            } else if(entry.get(mid).getKey() > target){
                high = mid-1;
            } else {
                return entry.get(low).getValue();
            }
        }
//        System.out.println(" : low : "+low);
        if(low == 0) return "";
        return entry.get(low-1).getValue();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
        timeMap.set("love","high",10);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.set("love","low",20);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("love",5));         // return "bar"
        System.out.println(timeMap.get("love",10));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(timeMap.get("love",15));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(timeMap.get("love",20));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(timeMap.get("love",25));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//        System.out.println(timeMap.get("foo", 4));         // return "bar2"
//        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
