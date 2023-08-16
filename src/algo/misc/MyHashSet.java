package algo.misc;

import ds.linkedlist.Node;

/**
 * https://leetcode.com/problems/design-hashset/
 */

public class MyHashSet {
    Node head;

    public MyHashSet() {
        head = null;
    }

    public void add(int key) {
        Node node = new Node(key);
        if (head == null) {
            head = node;
            return;
        }
        if(contains(key)) return;
        Node curr = head;

        while (curr.next != null){
            curr = curr.next;
        }
        curr.next= node;
    }

    public void remove(int key) {
        if (head == null) {
            return;
        }
        if(head.data == key){
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = curr;
        while (curr != null){
            if (curr.data == key){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

    }

    public boolean contains(int key) {
        if (head == null) {
            return false;
        }
        Node curr = head;
        while (curr != null){
            if (key == curr.data){
                return true;
            }
            curr = curr.next;
        }
        return false;

    }

    public static void main(String[] args) {


        MyHashSet obj = new MyHashSet();
        System.out.println("++++++++++++add+++++++++++");
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(3);
        obj.print(obj.head);
        obj.add(2);
        obj.print(obj.head);
        System.out.println("++++++++++contains++++++++++");
        System.out.println("contains(1) : "+obj.contains(1));
        System.out.println("contains(3) : "+obj.contains(3));
        System.out.println("contains(0) : "+obj.contains(0));

        System.out.println("++++++++++remove++++++++++");
        obj.remove(3);
        obj.print(obj.head);

    }

    public void print(Node n) {
        while (n != null){
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println("Null");
    }

}
