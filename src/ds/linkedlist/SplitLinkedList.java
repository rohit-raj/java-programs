package ds.linkedlist;

import java.util.Random;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class SplitLinkedList {

    public static int length (Node head){
        Node curr = head;
        int len=0;
        while (curr!=null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    public static Node[] splitListToParts(Node head, int k) {
        int len = length(head);

        int width = len/k;
        int rem = len%k;

        System.out.println("width : "+ width + " rem : "+ rem);

        Node[] ans = new Node[k];

        Node curr = head;
        for (int i=0;i<k;i++){
            Node head1 = curr;
            for (int j=0;j<width + (i<rem ? 1:0)-1;++j){
                if(curr!=null) curr = curr.next;
            }
            if(curr!=null){
                Node prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            ans[i] = head1;
        }
        return ans;
    }

    public static Node[] splitListToParts2(Node head, int k) {
        int len = length(head);

        int width = len / k, rem = len % k;

        System.out.println("width : "+ width + " rem : "+ rem);

        Node[] ans = new Node[k];
        Node curr = head;
        for (int i = 0; i < k; ++i) {
            Node head1 = curr;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (curr != null) curr = curr.next;
            }
            if (curr != null) {
                Node prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            ans[i] = head1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        Node head = sll.createRandomList();
        Node head = sll.createListFromItems(new int[]{1,2,3});

        sll.print(head);

        int len = sll.getLength(head);
        Random random = new Random();
        int k = random.nextInt(len+5);
        System.out.println("len = " + len + " : k = "+ k);
        System.out.println("output ====================");

        Node[] ans = splitListToParts(head, 5);

        for (int i=0;i<ans.length;i++){
            sll.print(ans[i]);
        }

        //2,22,8,24,1,29,15,34
    }
}
