package ds.linkedlist;

import java.util.Random;

/**
 * Created by rohit on 18/09/20.
 */

/**
 * merge sort on linked list
 */
public class Sort {

    static Node sortedMerge(Node left, Node right) {
        Node result;

        if(left == null) return right;
        if(right == null) return left;

        if(left.data <= right.data) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }

    /**
     * Below uses the O(n) space only to merge
     */
    static Node sortedMerge2(Node left, Node right){
        Node dummy = new Node(0);
        Node tail = dummy;

        while (true) {

            if (left == null){
                tail.next = right;
                break;
            }

            if (right == null){
                tail.next = left;
                break;
            }

            if(left.data <= right.data){
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }
        return dummy.next;
    }

    static Node sortedMerge3(Node left, Node right){
        if(left == null) return right;

        if(right == null) return left;

        if(left.data > right.data){

            Node temp = left;
            left = right;
            right = temp;
        }

        Node res = left;

        while(left != null && right != null){
            Node temp = null;


            while(left != null && left.data <= right.data){
                temp= left;
                left = left.next;
            }
            temp.next = right;

            Node temp2 = right;
            right = left;
            left = temp2;
        }
        return res;
    }

    static Node findMiddle (Node head){

        if(head == null) return head;

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }

    public static Node mergeSort(Node node){
        if(node == null || node.next == null) return node;

        Node middle = findMiddle(node);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(node);

        Node right = mergeSort(nextOfMiddle);
        return sortedMerge3(left, right);
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node ll = sll.createRandomList();

        sll.printByHead(ll);
        System.out.println("======***Output***======");

        ll = mergeSort(ll);

        sll.printByHead(ll);
    }
}
