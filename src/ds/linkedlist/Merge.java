package ds.linkedlist;
//import SinglyLinkedList;
/**
 * Created by rohit on 18/09/20.
 */

import java.util.Random;

/**
 * Merge k sorted linked list in an array
 */
public class Merge extends SinglyLinkedList{

    static Node sortedMerge(Node list1, Node list2) {
        Node result;

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.data <= list2.data) {
            result = list1;
            result.next = sortedMerge(list1.next, list2);
        } else {
            result = list2;
            result.next = sortedMerge(list1, list2.next);
        }

        return result;
    }

    static Node mergeList(Node [] lists) {
        Node result = null;
        if (lists.length == 0) return result;
        if(lists.length  == 1) return lists[0];

        for(int i = 0; i < lists.length; i++) {
            result = sortedMerge(result, lists[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Node [] lists = new Node[4];

        for(int i = 0; i < 4; i++) {
            Random random = new Random();
            int lLSize = random.nextInt(10);
            SinglyLinkedList ll = new SinglyLinkedList();
            for(int j = 0; j < lLSize; j++) {
                int x = random.nextInt(50);
                ll.insertAtStart(x);
            }
            lists[i] = ll.head;
        }

        for (int k = 0; k < lists.length; k++) {
            Node ll = lists[k];
//            SinglyLinkedList.printByHead(ll);
//            System.out.println("======after sorting======");
            ll = Sort.mergeSort(ll);
            SinglyLinkedList.printByHead(ll);
            lists[k] = ll;
        }

        System.out.println("======Output======");

        Node op = mergeList(lists);

        SinglyLinkedList.printByHead(op);
    }
}
