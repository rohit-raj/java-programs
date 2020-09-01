package ds.linkedlist;

/**
 * Created by rohit on 02/09/20.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * question : https://leetcode.com/problems/intersection-of-two-linked-lists/solution/
 */
public class IntersectingLinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int item){
            data = item;
            next = null;
        }
    }

    //Solution 1
    //By using Hash table to see if the entry is present or not

    public Node hashTable (Node A, Node B) {
        Node pA = A;
        Node pB = B;

        Set<Node> nodes = new HashSet<Node>();

        while(pA != null) {
            nodes.add(pA);
            pA = pA.next;
        }

        if(nodes.size() == 0) {
            return null;
        }

        while(pB != null) {
            if(nodes.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }


    //Solution 2
    //Recursive iteration by pointing to next list
    public Node iterative (Node A, Node B) {
        Node currA = A;
        Node currB = B;

        while(currA != currB) {
            currA = (currA != null) ? currA.next : B;
            currB = (currB != null) ? currB.next : A;
        }
        return currA;
    }

    public static void main(String[] args) {

    }
}
