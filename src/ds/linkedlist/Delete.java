package ds.linkedlist;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class Delete {

    public Node deleteFromStart(Node head){
        if(head ==null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        head = head.next;
        return head;
    }

    public Node deleteFromLast(Node head){
        if(head ==null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node curr = head;
        Node prev = null;
        while(curr.next !=null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

    public Node deleteAtPos(Node head, int pos){
        if (pos <= 0){
            System.out.println("incorrect position");
            return head;
        }
        if(pos ==1){
            head = head.next;
            return head;
        }

        if(head == null){
            System.out.println("No item in list");
            return null;
        }


        if(head.next == null){
            head = null;
            return head;
        }

        int count = 0;
        Node curr = head;
        Node prev = null;

        while (curr.next != null){
            count++;
            if(count == pos){
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next =curr.next;
        return head;
    }

    public Node deleteByValue(Node head, int value) {
        if(head == null){
            return null;
        }

        boolean headElement = true;
        Node curr = head;
        Node prev = curr;

        while(curr != null) {
            if(curr.data == value) {
                if(headElement) {
                    head = head.next;
                    curr = head;
                    prev = curr;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                    headElement = false;
                }
            } else {
                prev = curr;
                curr = curr.next;
                headElement = false;
            }
        }
        return head;
    }

    public Node deleteAtPosFromLast(Node head, int pos){
        SinglyLinkedList sll = new SinglyLinkedList();
        int length = sll.getLength(head);

        int posFromStart = length-pos+1;

        head = deleteAtPos(head, posFromStart);
        return head;
    }

    /**
     * one pass
     */
    public Node deleteAtPosFromLastOptimal(Node head, int pos){
        Node start = new Node(0);
        start.next = head;
        Node slow = start;
        Node fast = start;

        //No length computation

        //Move to pos position from start
        for(int i=0;i<pos;i++){
            fast = fast.next;
        }

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    Node deleteMiddle(Node head){
        if (head.next == null) return null;

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Delete d = new Delete();

        Node head = null;

        head = sll.insertAtLast(head, 1);
        head = sll.insertAtLast(head, 2);
        head = sll.insertAtLast(head, 3);

        sll.print(head);

        System.out.println(sll.getLength(head));
//        d.deleteAtPosFromLast(1);

//        d.deleteMiddle(d.head);
        d.deleteAtPosFromLastOptimal(head, 1);
        sll.print(head);
    }

}
