package ds.linkedlist;

/**
 * https://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/
 */
public class ReverseAlternateAndAppendAtEnd {
    public static SinglyLinkedList ll;

    static Node solveNormal(Node head){
        // If linked list has less than 3 nodes,
        // no change is required
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // even points to the beginning
        // of even list
        Node even = head.next;

        // Remove the first even node
        head.next = head.next.next;

        // head points to next node in head list
        head = head.next;

        // Set terminator for even list
        even.next = null;

        // Traverse the  list
        while (head.next != null) {

            // Store the next node in head list
            Node temp = head.next.next;

            // Link the next even node at the
            // beginning of even list
            head.next.next = even;
            even = head.next;

            // Remove the even node from middle
            head.next = temp;

            // Move head to the next head node
            if (temp != null) {
                head = temp;
            }
        }

        // Append the even list at the end of head list
        head.next = even;

        return head;
    }


    //optimal without using extra space
    static Node solveOptimal(Node head){
        if(head == null) return head;

        Node curr=head;

        while(curr.next !=null && curr.next.next!=null){
            curr = curr.next.next;
        }

//        System.out.println("curr :: "+ curr.val);

        Node endPtr = curr, marker = curr;

        curr = head;
        Node prev = head;
        Node next;

        int count=0;
        while (curr!=marker && curr.next!=null){
            next = curr.next;

            if(count%2==1){
                prev.next = curr.next;
                curr.next = endPtr.next;
                endPtr.next = curr;
                endPtr=endPtr.next;
            }
            count++;
            prev = curr;
            curr = next;
        }


//        System.out.println("marker : "+ marker.val);

//        ll.print(head);
//        System.out.println("********************************");

        //reverse from marker to end
        curr = marker.next;
        prev = null;
        next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        marker.next = prev;

        return head;
    }


    public static void main(String[] args) {

        ll = new SinglyLinkedList();
        Node head = ll.createListFromItems(new int[]{8,4,3,7,5,6,2,1});

        ll.print(head);
        System.out.println("======================================");

        solveNormal(head);
        ll.print(head);

        System.out.println("================Optimal=================");
        Node head2 = ll.createListFromItems(new int[]{8,4,3,7,5,6,2,1});
        ll.print(head2);
        System.out.println("======================================");

        solveOptimal(head2);

        ll.print(head2);
    }


}

// refyne
// 5: vp/engineer/cto
// technicals : 2 + tech managerial