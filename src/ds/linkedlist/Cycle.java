package ds.linkedlist;

/**
 * Created by rohit on 02/09/20.
 */
public class Cycle {
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int item) {
            data = item;
            next = null;
        }
    }

    static boolean findCycle (Node head) {
        if(head == null || head.next ==null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
