package ds.linkedlist;

import java.util.Objects;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEven {

    static Node oddEvenList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node oddPtr = head;
        Node evenPtr = head.next;

        Node evenHead = evenPtr;

        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }

        oddPtr.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node head = null;
        head = sll.insertAtLast(head,1);
        head = sll.insertAtLast(head,2);
        head = sll.insertAtLast(head,3);
        head = sll.insertAtLast(head,4);

        sll.printByHead(head);
        System.out.println("==============Output==============");
        Node ans = oddEvenList(head);
        sll.printByHead(ans);
    }
}
