package ds.linkedlist;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertToDecimal {
    static int convertToDecimal(Node head){
        int num = 0;
        while(head != null){
            num = num*2 + head.data;
            head = head.next;
        }

        return num;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        Node head = null;
        head = sll.insertAtLast(head, 1);
        head = sll.insertAtLast(head, 0);
        head = sll.insertAtLast(head, 1);
        head = sll.insertAtLast(head, 0);
        head = sll.insertAtLast(head, 0);

        System.out.println("decimal Number = "+ convertToDecimal(head));

    }
}
