package ds.linkedlist;

import java.util.Random;

/**
 * Created by rohit on 18/09/20.
 */

/**
 * merge sort on linked list
 */
public class Sort extends SinglyLinkedList {

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

    static Node mergeSort(Node node){
        if(node == null || node.next == null) return node;

        Node middle = findMiddle(node);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(node);

        Node right = mergeSort(nextOfMiddle);
        return sortedMerge(left, right);
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

    public static void main(String[] args) {
        Random random = new Random();
        int lLSize = random.nextInt(10);
        SinglyLinkedList ll = new SinglyLinkedList();
        for(int j = 0; j < lLSize; j++) {
            int x = random.nextInt(50);
            ll.insertAtStart(x);
        }

        ll.print();
        System.out.println("======Output======");

        ll.head = mergeSort(ll.head);

        SinglyLinkedList.printByHead(ll.head);
    }
}
