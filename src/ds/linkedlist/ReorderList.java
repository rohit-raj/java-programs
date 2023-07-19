package ds.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(Node head) {
        if (head == null) return;

        //Find middle
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node curr = slow.next; // head and curr are two lists now;
        slow.next = null;

        Node prev = null;
        Node next = null;

        //Reverse the curr list
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //prev holds the start of the reversed list
        //start merging head and prev elements

        while (prev!=null){
            Node a = head.next;
            Node b = prev.next;

            head.next = prev;
            prev.next = a;
            prev = b;
            head = a;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node head = sll.createRandomList();
        sll.print(head);
        System.out.println("====================================");

        ReorderList rl = new ReorderList();
        rl.reorderList(head);
        sll.print(head);
    }
}
