package ds.linkedlist;

/**
 * https://leetcode.com/problems/rotate-list/description/
 */
public class Rotate {
    public static SinglyLinkedList sll;

    public int length(Node head){
        if(head == null){
            return 0;
        }
        Node curr = head;
        int count = 0;
        while (curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public Node findK(Node head, int pos){
        int count = 0;
        Node curr = head;
        while (curr != null){
            count++;
            if(count == pos){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     *  k == 0
     *  k  == length
     *
     */
    public Node rotate(Node head, int k){
        if(head == null || head.next == null) return head;
        int length = length(head);
        k = k%length;
        int posFromStart = length - k;
        if (k == 0 || posFromStart <= 0){
            return head;
        }

//        System.out.println("length ;: " + length+ " : posFromStart : "+ posFromStart);

        Node element = findK(head, posFromStart);
        Node node2 = element.next;
        element.next = null;

//        System.out.println("ele : ");
//        sll.printByHead(head);

//        System.out.println("node2 : ");
//        sll.printByHead(node2);



        Node curr = node2;
        while (curr.next != null){
            curr= curr.next;
        }
        curr.next = head;
        head = node2;
        return head;
    }

    public Node rotateRightOptimal(Node head, int k) {

        Node temp = head, prev = head, curr = head;

        if(head == null || head.next == null) return head;
        int size = 0, i = 1;

        //length
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        //last node
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;

        k %= size;
        while(i < (size - k)) {
            prev = prev.next;
            i++;
        }

        Node res = prev.next;
        prev.next = null;

        return res;
    }

    public static void main(String[] args) {
        sll = new SinglyLinkedList();
        Node ll = sll.createRandomList();

        sll.printByHead(ll);
        System.out.println("======***Output***======");

        Rotate r = new Rotate();


        System.out.println("count : "+ r.length(ll));

        Node rev = r.rotate(ll, 15);

        sll.printByHead(rev);


    }
}

