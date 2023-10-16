package ds.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class Add2Numbers2 {
    SinglyLinkedList sll;

    public Add2Numbers2(){
        sll = new SinglyLinkedList();
    }

    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = head;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public Node insert(Node head, int num){
        Node node = new Node(num);

        node.next = head;
        head = node;
        return head;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        Node currL1 = l1;
        Node currL2 = l2;

        Node ans = null;
        int carry =0;
        int sum = 0;

        while (currL1 !=null || currL2!= null){
            if(currL1 != null) sum+= currL1.val;
            if(currL2 != null) sum+= currL2.val;
            int num = sum%10;
            ans = insert(ans, num);
            carry = sum/10;
            sum = carry;

            currL1 = currL1!=null ? currL1.next: null;
            currL2 = currL2!=null ? currL2.next: null;
        }
        System.out.println("carry = "+ carry);
        if(carry > 0){
            insert(ans, carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        Add2Numbers2 add = new Add2Numbers2();
        Node head1 = add.sll.createListFromItems(new int[]{2,7});
        Node head2 = add.sll.createListFromItems(new int[]{5});

        add.sll.print(head1);
        add.sll.print(head2);
        System.out.println("output ==================");

        Node ans = add.addTwoNumbers(head1, head2);

        add.sll.print(ans);

    }
}
