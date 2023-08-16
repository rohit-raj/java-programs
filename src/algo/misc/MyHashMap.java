package algo.misc;

/**
 * https://leetcode.com/problems/design-hashmap/
 */

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode(int k, int v){
        this.key = k;
        this.value = v;
        this.next = null;
    }
}

public class MyHashMap {
    ListNode head;
    public MyHashMap() {
        head = null;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if(head == null){
            head = node;
            return;
        }
        ListNode curr = head;
        while (curr.next != null){
            if (key == curr.key){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        if(curr.key == key){
            curr.value = value;
            return;
        }
        curr.next = node;
    }

    public int get(int key) {
        if (head == null) {
            return -1;
        }
        ListNode curr = head;
        while (curr != null){
            if (key == curr.key){
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        if(head == null){
            return;
        }
        if(head.key == key){
            head = head.next;
            return;
        }

        ListNode curr= head;
        ListNode prev = null;

        while(curr != null){
            if(curr.key == key){
                prev.next = curr.next;
                return;
            }
            prev =curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {


        MyHashMap obj = new MyHashMap();
        System.out.println("++++++++++++add+++++++++++");
        obj.put(1,1);
        obj.put(2, 2);
//        obj.put(3, 15);
//        obj.print(obj.head);
        obj.put(2,20);
        obj.print(obj.head);
        System.out.println("++++++++++contains++++++++++");
        System.out.println("contains(1) : "+obj.get(1));
        System.out.println("contains(3) : "+obj.get(3));
        System.out.println("contains(0) : "+obj.get(0));

        System.out.println("++++++++++remove++++++++++");
        obj.remove(4);
        obj.print(obj.head);

    }

    public void print(ListNode n) {
        while (n != null){
            System.out.print("["+n.key+", "+n.value + "] => ");
            n = n.next;
        }
        System.out.println("Null");
    }
}
