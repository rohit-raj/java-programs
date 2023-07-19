package ds.linkedlist;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */


public class DeepCopy {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int item){
            this.val = item;
            this.next = null;
            this.random = null;
        }
    }

    static Node copyRandomListBrute(Node head){

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        while (curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node temp2 = head;

        while (temp2 != null){
            Node node = map.get(temp2);
            node.next = (temp2.next != null)? map.get(temp2.next).next:null;
            node.random = (temp2.random != null)? map.get(temp2.random).random:null;
            temp2 = temp2.next;
        }

        return head;

    }

    static Node copyRandomListOptimal(Node head){
        Node curr = head;
        while (curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        printList(head);

        curr = head;
        Node newPtr =head;

        while (curr != null){
            newPtr = curr.next;
            if(curr.random != null) {
                newPtr.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newList = new Node(0);
        curr = head;
        Node temp = newList;
        Node fast;

        while (curr != null){
            fast = curr.next.next;
            temp.next = curr.next;
            curr.next = fast;
            temp = temp.next;
            curr = fast;
        }

        return newList.next;
    }



    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        System.out.println("Original list:");
        printList(head);

        System.out.println("Copy list:");
//        Node newHead = copyRandomListBrute(head);
        Node newHead = copyRandomListOptimal(head);
        printList(newHead);
    }

    static void printList(Node n) {
        while (n != null){
            System.out.print(n.val + " => ");
            n = n.next;
        }
        System.out.println("Null");
    }

}
