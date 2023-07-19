package ds.linkedlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list
 */
public class Palindrome {

    public static SinglyLinkedList sll;
    static boolean isPalindromeBrute(Node head){
        Node curr = head;
        int length = sll.getLength(head);
        int[] llArray = new int[length];
        int i = 0;
        while (curr != null){
            llArray[i] = curr.data;
            i++;
            curr = curr.next;
        }

        int low = 0, high = length-1;

        while (low <= high){
            if(llArray[low] != llArray[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    static Node reverse(Node node){
        if (node == null) {
            System.out.println("No nodes present");
            return node;
        }
        Node next, prev = null;
        Node curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    static boolean isPalindromeOptimal(Node head){
        Node curr = head;
        Node middle = sll.getMid(head);

        middle.next = reverse(middle.next);

        Node slow = middle.next;

        while (slow!=null){
            if(curr.data != slow.data) return false;
            curr = curr.next;
            slow = slow.next;
        }
        return true;

    }

    public static void main(String[] args) {
        sll = new SinglyLinkedList();
        Node head = null;
        head = sll.insertAtLast(head,1);
        head = sll.insertAtLast(head,8);
        head = sll.insertAtLast(head,2);
        head = sll.insertAtLast(head,1);

        sll.printByHead(head);
        System.out.println("==============Output==============");

        System.out.println("is Palindrome : "+ isPalindromeBrute(head));
        System.out.println("is Palindrome : "+ isPalindromeOptimal(head));

    }
}
