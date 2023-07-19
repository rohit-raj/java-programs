package ds.linkedlist;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroups{

    private static SinglyLinkedList sll;
    public static Node reverse(Node head){
        if (head == null) {
            return head;
        }
        Node next, prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }


    public static Node reverseKGroup(Node head, int k){
        if(head == null) return head;
        Node curr = head;
        int counter = 0;
        while (counter < k){
            counter++;
            if(counter == k){
                break;
            } else {
                if (curr.next == null) return head;
                curr = curr.next;
            }
        }
        Node last = curr;
        Node right = last.next;
        last.next = null;

//        printByHead(head);
//        printByHead(right);

        Node newHead = reverse(head);

//        System.out.println("after reverse : ");
//        printByHead(newHead);
        curr = newHead;
        while (curr.next != null){
            curr = curr.next;
        }

        if(right != null) {
            right = reverseKGroup(right, k);
        }
        curr.next = right;
//        System.out.println("newHead");
//        printByHead(newHead);
//        System.out.println("newHead end");
        return newHead;
    }


    public static Node reverseKNodesOptimal(Node head, int k){
        if(head == null || head.next == null)return head;

        int length = sll.getLength(head);

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node prev = dummyHead;
        Node curr = null;
        Node next = null;

        while (length >= k){
            curr = prev.next;
            next = curr.next;

            for(int i=1;i<k;i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length-=k;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        sll = new SinglyLinkedList();
        Node ll = sll.createRandomList();

        sll.printByHead(ll);
        System.out.println("======***Output***======");

        Node res = reverseKGroup(ll, 3);
        sll.printByHead(res);
        Node res2 = reverseKNodesOptimal(res, 3);
        sll.printByHead(res2);
    }
}
