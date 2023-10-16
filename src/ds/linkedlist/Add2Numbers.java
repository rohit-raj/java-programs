package ds.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Add2Numbers {

    static Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr= head;
        Node next = null;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head= prev;
        return head;
    }

    static Node sum(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;

        Node ans = new Node(0);
        Node temp = ans;
        int carry = 0;



        while(a != null || b != null || carry ==1){
            int sum = 0;

            if(a != null) {
                sum += a.data;
                a = a.next;
            }

            if (b != null){
                sum += b.data;
                b = b.next;
            }

            sum += carry;

            carry = sum/10;
            sum = sum%10;
            temp.next = new Node(sum);
            temp = temp.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node ll1 = sll.createRandomList();
        Node ll2 = sll.createRandomList();

        sll.printByHead(ll1);
        sll.printByHead(ll2);
        System.out.println("===========Output===========");
//        Node a = reverse(ll1);
//        Node b = reverse(ll2);
        Node ans = sum(ll1, ll2);

        sll.printByHead(ans);




    }
}
