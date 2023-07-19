package blind75;
/**
 * Created by rohit on 18/09/20.
 *
 */

import ds.linkedlist.Node;
import ds.linkedlist.SinglyLinkedList;
import ds.linkedlist.Sort;

import java.util.Comparator;
import java.util.PriorityQueue;


class NodeComparator implements Comparator<Node>{
    public int compare(Node a, Node b){
        if(a.data > b.data) return 1;
        else if(a.data < b.data) return -1;
        else return 0;
    }
}

/**
 * Merge k sorted linked list in an array
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

public class Merge{

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */
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

    static Node sortedMergeInPlace(Node left, Node right){
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

    /**
     * O(N)*(N+M)
     * O(1)
     */
    static Node mergeListBetter(Node [] lists) {
        Node result = null;
        if (lists.length == 0) return result;
        if(lists.length  == 1) return lists[0];

        for(int i = 0; i < lists.length; i++) {
//            result = sortedMerge(result, lists[i]);
            //or
            result = sortedMergeInPlace(result, lists[i]);
        }

        return result;
    }

    static Node mergeListOptimal(Node[] lists, int k){
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        Node head = new Node(0);
        Node last = head;


        for(int i=0;i<k;i++){
            if(lists[i] != null)
                queue.add(lists[i]);
        }

        if(queue.isEmpty()){
            return null;
        }

        while (!queue.isEmpty()){
            Node curr = queue.poll();// get the top element
            last.next = curr;
            last = last.next;

            if(curr.next !=null){
                queue.add(curr.next);
            }
        }
        return head.next;

    }

    public static void main(String[] args) {
        int k = 4;
        Node [] lists1 = new Node[k];
        Node [] lists2 = new Node[k];
        SinglyLinkedList sll = new SinglyLinkedList();
        for(int i = 0; i < k; i++) {
            lists1[i] = sll.createRandomList();
        }

        for (int j = 0; j < lists1.length; j++) {
            Node node1 = lists1[j];
            node1 = Sort.mergeSort(node1);
            sll.printByHead(node1);
            System.out.println();
            lists1[j] = node1;
            Node node2 = sll.duplicateList(node1);
            lists2[j] = node2;
        }
        System.out.println("======***Output***======");

        Node ll = mergeListBetter(lists1);

        System.out.print("Brute   : ");
        sll.printByHead(ll);

        Node op2 = mergeListOptimal(lists2, k);
        System.out.print("Optimal : ");
        sll.printByHead(op2);
    }
}
