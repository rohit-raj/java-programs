package ds.linkedlist;

public class Node {
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
}
