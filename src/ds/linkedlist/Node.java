package ds.linkedlist;

public class Node {
    public int key;
    public int data;
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}

    public Node(int _data){
        data = _data;
        val = _data;
        left=right=next=null;
    }

    public Node(int _key, int _val){
        key = _key;
        val = _val;
        left=right=next=null;
    }
}
